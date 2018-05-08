package com.ecar.controller;

import com.ecar.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SmsController {

    @Autowired
    private SmsService smsService;

    @GetMapping(value = "/sendSmsCodeByPhone")
    @ResponseBody
    public boolean sendSmsCodeByPhone(@RequestParam("phone")String phone) {

        boolean result = smsService.sendCode(phone);

        return result;
    }

    @GetMapping(value = "/getSmscodeByPhone")
    @ResponseBody
    public boolean getSmscodeByPhone(@RequestParam("phone")String phone, @RequestParam("code")String code) {
        System.out.println(phone);
        boolean result = smsService.getSmscodeByPhone(phone, code);

        return result;
    }
}
