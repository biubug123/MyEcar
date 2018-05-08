package com.ecar.controller;

import com.ecar.entity.Consult;
import com.ecar.service.ConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ConsultController {

    @Autowired
    private ConsultService consultService;

    @RequestMapping(value = "/getConsult",method = RequestMethod.GET)
    @ResponseBody
    public List<Consult> getConsult(String videoId) {
        List<Consult> consults = consultService.listConsult(videoId);

        return consults;
    }

    @RequestMapping(value = "/insertConsult", method = RequestMethod.POST)
    @ResponseBody
    public int insertResult(@RequestParam("title")String title, @RequestParam("content")String content, @RequestParam("vid")String vid, @RequestParam("userPhone")String phone) {
        int result = consultService.insertConsult(vid, title, content, phone);

        return result;
    }
}
