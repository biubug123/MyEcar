package com.ecar.controller;

import com.ecar.util.weiXinPublic.WeChatPublicUser;
import com.ecar.util.weiXinPublic.WechatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: ecar
 * @description: 微信公众号
 * @author: ziHeng
 * @create: 2018-05-07 16:20
 **/
@RestController
@RequestMapping("/weiXinPublic")
public class WeiXinPublicController {


    private Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private WechatUtil wechatUtil;

    @PostMapping("/getWeChatUser")
    public void GetCode(@RequestParam("code") String code,
                        HttpServletResponse response,
                        HttpServletRequest request){

        if(code!=null){
            WeChatPublicUser weChatUser = wechatUtil.getAccessToken(code);

            String openId = weChatUser.getOpenid();
            String headImg = weChatUser.getHeadImgUrl();
            String nickName = weChatUser.getNickName();
            //存放cookie
            Cookie openIdCookie = cookie("openId",openId);
            Cookie headImageUrlCookie = cookie("headImageUrl",headImg);
            Cookie nickCookie = cookie("nickName",nickName);
            response.addCookie(openIdCookie);
            response.addCookie(headImageUrlCookie);
            response.addCookie(nickCookie);
            logger.info("code值{}",code);

        }
    }

    public Cookie cookie(String name,String value){
        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");
        cookie.setMaxAge(60*60*2);
        return cookie;
    }


}
