package com.ecar.dao;

import com.ecar.util.weiXinPublic.WeChatPublicUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
  * @Description: 微信公众号Dao
  * @Author: ziHeng
  * @Date: 2018/5/7 下午5:59
  * @Param:
  * @return:
  */
@Repository
@Mapper
public interface WeiXinPublic {

    //tb_wechat_user中取得openId 查看是否有该用户
    WeChatPublicUser getWeChatUserByOpenid(@Param("openId") String openid);

    //更新tb_weChat_user表
    int updateWechatUser(WeChatPublicUser weChatUser);

    //插入到tb_weChat_user
    int insertWeChatUser(WeChatPublicUser weChatUser);
}
