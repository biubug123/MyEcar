package com.ecar.service.serviceimplement;

import com.ecar.dao.VideosDAO;
import com.ecar.entity.Videos;
import com.ecar.service.VideoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoImp implements VideoService {

    @Autowired
    private VideosDAO videosDAO;

    private static Logger logger = Logger.getLogger(VideoImp.class);

    @Value("${upLoadPath.videoPath}")
    private String videoPath;

    @Override
    public List<Videos> listVideoByType(int type) {
        try {
            String function = "应急处理";
            switch(type) {
                case 0:
                    function = "全部视频";
                    break;
                case 1:
                    function = "应急处理";
                    break;
                case 2:
                    function = "功能介绍";
                    break;
                case 3:
                    function = "娱乐生活";
                    break;
                case 4:
                    function = "户外活动";
                    break;
            }

            List<Videos> videosList;

            if(function.equals("全部视频")) {
                videosList = videosDAO.listVideo();
            } else {
                videosList = videosDAO.listVideoByType(function);
            }

            List<Videos> videos = new ArrayList<>();
            for(Videos video : videosList) {
                video.setImageUrl(videoPath + video.getImageUrl());
                System.out.println(video.getImageUrl());
                videos.add(video);
            }

            for(Videos video : videosList) {
                System.out.println(videos);
            }

            return videos;
        } catch (Exception e) {
            // 获取失败，记录错误信息
            logger.error(e.getMessage(), e);

            return null;
        }

    }

    @Override
    public Videos getVideosByUUID(String uuid) {
        try{
            Videos videos = videosDAO.getVideosByUUID(uuid);

            return videos;
        } catch(Exception e) {
            logger.error(e.getMessage(), e);

            return null;
        }
    }

    @Override
    public List<Videos> listVideosByKeyword(String keyword) {
        List<Videos> videosList = videosDAO.listVideosByKeyword(keyword);

        return videosList;
    }

    @Override
    public List<Videos> listVideoPage(String type, int page, int size) {
        int startRow = (page - 1) * size;

        List<Videos> videosList = videosDAO.listVideoPage(type, startRow, size);

        return videosList;
    }

}
