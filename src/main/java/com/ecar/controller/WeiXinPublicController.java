package com.ecar.controller;

import com.ecar.util.weiXinPublic.WeChatUser;
import com.ecar.util.weiXinPublic.WechatUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ecar
 * @description: 微信公众号
 * @author: ziHeng
 * @create: 2018-05-07 16:20
 **/
@RestController
public class WeiXinPublicController {

    @PostMapping
    public void GetCode(@RequestParam("code") String code){
        if(code!=null){
            WeChatUser weChatUser = WechatUtil.getAccessToken(code);

            System.out.println(weChatUser);
        }
    }


}
