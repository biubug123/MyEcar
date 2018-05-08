package com.ecar.util.weiXinPublic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ecar.dao.WeiXinPublic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信第三方登录工具类 未测试
 * Created by huangpeiquan on 17/1/23.
 */
@Component
public class WechatUtil {
    private final static String APPID="wxb1801e7c577d6a01";
    private final static String SECRET="a6be415999d5c505b9583f1f184befcc";

    @Autowired
    public WeiXinPublic weiXinPublic;



    /**
     * 验证access_token
     * @param accessToken
     * @param openID
     * @return
     */
    public static JSONObject verifyAccessToken(String accessToken, String openID){
        String url = "https://api.weixin.qq.com/sns/auth?access_token=" + accessToken + "&openid=" + openID;
        return getJsonObject(url);
    }

    /**
     * 更新refresh_token
     * @param refreshToken
     * @return
     */
    public  WeChatPublicUser refreshAccessToken(String refreshToken){
        String url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=" + APPID + "&grant_type=refresh_token&refresh_token="
                + refreshToken;
        WeChatPublicUser wechatUser = getWechatUser(url);
        return wechatUser;
    }

    /**
     * 获取access_token
     * @param code
     * @return
     */
    public  WeChatPublicUser getAccessToken(String code) {
        final String URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+
                APPID+"&secret="+SECRET+"&code="+code+"&grant_type=authorization_code";
        System.out.println("getAccessToken");
        WeChatPublicUser wechatUser = getWechatUser(URL);
        return wechatUser;
    }


    private  WeChatPublicUser getWechatUser(String URL) {
        WeChatPublicUser wechatUser = new WeChatPublicUser();
        JSONObject jsonObject = getJsonObject(URL);
        System.out.println("执行到 getWechatUser");
        System.out.println("jsonObject:"+jsonObject);
        if(null!=jsonObject) {
            String accessToken = jsonObject.getString("access_token");
            String openID = jsonObject.getString("openid");
            String refreshToken = jsonObject.getString("refresh_token");
            Long expires_in = jsonObject.getLong("expires_in");
            Long accessTokenTime = System.currentTimeMillis();


            if (null != accessToken && !"".equals(accessToken)) {

                wechatUser.setOpenid(openID);
                wechatUser.setAccessToken(accessToken);
                wechatUser.setExpiresIn(expires_in);
                wechatUser.setRefreshToken(refreshToken);
                wechatUser.setAccessTokenTime(accessTokenTime);
                System.out.println("执行到 getWechatUserInof");
                System.out.println("###openid:"+openID+"  accessToken:"+accessToken+"   expires_in:"+expires_in);
                Map<String,Object> userInfoMap = getWechatUserInfo(accessToken,openID,expires_in,accessTokenTime);
                System.out.println("执行到 getWechatUserInof2222:"+userInfoMap);
                if(userInfoMap!=null){
                    wechatUser.setNickName(userInfoMap.get("nickname").toString());
                    //wechatUser.setSex(Integer.parseInt(userInfoMap.get("sex").toString()));
                    //wechatUser.setProvince(userInfoMap.get("province").toString());
                    //wechatUser.setCity(userInfoMap.get("city").toString());
                    //wechatUser.setContry(userInfoMap.get("country").toString());
                    wechatUser.setHeadImgUrl(userInfoMap.get("headimgurl").toString());
                    //wechatUser.setUnionid(userInfoMap.get("unionid").toString());
                }
                //tb_wechat_user中取得openId 查看是否有该用户
                WeChatPublicUser weChatPublicUser = weiXinPublic.getWeChatUserByOpenid(wechatUser.getOpenid());
                System.out.println("weChatPublicUserZI:"+weChatPublicUser);
                if(weChatPublicUser != null){
                    System.out.println("执行到 getWechatUserInof3333");
                    //更新tb_wechat_user用户
                    weiXinPublic.updateWechatUser(wechatUser);
                }else{
                    System.out.println("执行到 getWechatUserInof44444");
                    //添加该用户
                    weiXinPublic.insertWeChatUser(wechatUser);
                }
             }
        }
        return wechatUser;
    }

    /**
     * 拉取微信用户信息
     * @param accessToken
     * @param openID
     * @param expires_in
     * @return
     */
    public static Map<String,Object> getWechatUserInfo(String accessToken, String openID, long expires_in,long accessTokenTime) {
        Map<String,Object> map = new HashMap<String, Object>();
        if ( System.currentTimeMillis()-accessTokenTime < expires_in) {
            String uri = "https://api.weixin.qq.com/sns/userinfo?access_token=" + accessToken + "&openid=" + openID+"&lang=zh_CN";
            JSONObject jsonObject = getJsonObject(uri) ;
            System.out.println("userIfnoObject"+jsonObject);
            if(null != jsonObject){
                map.put("nickname",jsonObject.getString("nickname"));
                //用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
                //map.put("sex",jsonObject.getIntValue("sex"));
                //用户个人资料填写的省份
                //map.put("province",jsonObject.getString("province"));
                //普通用户个人资料填写的城市
                //map.put("city",jsonObject.getString("city"));
                //国家，如中国为CN
                //map.put("country",jsonObject.getString("country"));
                //用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
                map.put("headimgurl",jsonObject.getString("headimgurl"));
                //只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段
                //map.put("unionid",jsonObject.getString("unionid"));

            }
        }
        return map;
    }

    /**
     * 工具类 a=1&b=2 提取为json
     * @param uri
     * @return
     */
    // TODO: 17/1/24
    private static JSONObject getJsonObject(String uri) {
        try {
            URL url = new URL(uri);
            URLConnection connection = url.openConnection();
            if (null!=connection) {

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                StringBuilder sb = new StringBuilder();

                for (String temp = reader.readLine(); temp != null; temp = reader.readLine()) {
                    sb.append(temp);
                }
                reader.close();
                JSONObject jsonObject = JSON.parseObject(sb.toString().trim());
                reader.close();
                return jsonObject;
            }
        } catch ( Exception e) {
            System.out.println("io:"+e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
