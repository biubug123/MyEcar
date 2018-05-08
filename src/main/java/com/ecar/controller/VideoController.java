package com.ecar.controller;

import com.ecar.entity.Videos;
import com.ecar.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VideoController  {

    @Autowired
    private VideoService videoService;

    @RequestMapping(value = "/listVideoByType", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public List<Videos> listVideoByType(@RequestParam("type") int type) {
        List<Videos> videosList = videoService.listVideoByType(type);


        return videosList;
    }

    @RequestMapping(value = "/getVideoByUUID", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public Videos getVideosByUUID(@RequestParam("vid") String uuid) {
        Videos videos = videoService.getVideosByUUID(uuid);

        return videos;
    }

    @RequestMapping(value= "/listVideosByKeyWord", method = RequestMethod.GET)
    @ResponseBody
    public List<Videos> listVideosByKeyword(@RequestParam("keyword")String keyword) {
        List<Videos> videosList = videoService.listVideosByKeyword(keyword);

        return videosList;
    }
    @GetMapping("/listVideoPage")
    @ResponseBody
    public List<Videos> listVideosPage(@RequestParam("type")String type, @RequestParam("page")int page, @RequestParam("size")int size) {
        List<Videos> videosList = videoService.listVideoPage(type, page, size);

        return videosList;
    }
}
