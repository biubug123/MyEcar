package com.ecar.controller;

import com.ecar.entity.Collect;
import com.ecar.entity.Recall;
import com.ecar.entity.Record;
import com.ecar.entity.User;
import com.ecar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@RequestParam("userPhone")String userPhone, @RequestParam("password")String password){
        User user = userService.getUser(userPhone, password);

        return user;
    }

    @RequestMapping(value = "/collectRecord", method = RequestMethod.GET)
    @ResponseBody
    public Integer collectRecord(@RequestParam("userPhone")String userPhone, @RequestParam("videoId")String videoId) {
        int result;
        if(userService.getRecord(userPhone, videoId) == null) {
            result = userService.insertVideoRecord(userPhone, videoId);
        } else {
            result = userService.updateVideoRecord(userPhone, videoId);
        }
        return result;
    }

    @RequestMapping(value = "/insertOrUpdateRecord", method = RequestMethod.GET)
    @ResponseBody
    public int insertOrUpdateRecord(@RequestParam("userPhone")String phone, @RequestParam("vid")String vid) {
        int result = userService.insertOrUpdateRecord(phone, vid);

        return result;
    }

    @RequestMapping(value = "/getRecord", method = RequestMethod.GET)
    @ResponseBody
    public Record getRecord(@RequestParam("userPhone")String phone, @RequestParam("videoId")String videoId) {
        Record record = userService.getRecord(phone, videoId);

        return record;
    }

    @RequestMapping(value = "/listCollectByPhone", method = RequestMethod.GET)
    @ResponseBody
    public List<Collect> listCollectByPhone(@RequestParam("userPhone")String phone) {
        List<Collect> collects = userService.listCollectByPhone(phone);

        return collects;
    }

    @GetMapping(value = "/listRecordByPhone")
    @ResponseBody
    public List<Record> listRecordByPhone(@RequestParam("userPhone")String phone) {
        List<Record> records = userService.listRecordByPhone(phone);

        return records;
    }
}
