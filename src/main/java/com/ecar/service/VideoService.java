package com.ecar.service;

import com.ecar.entity.Videos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VideoService {

    // 根据类型提取视频
    List<Videos> listVideoByType(int type);

    // 根据uuid获取对应的视频
    Videos getVideosByUUID(String uuid);

    // 根据关键字查询对应视频
    List<Videos> listVideosByKeyword(String keyword);

    // 分页查询，用于上拉加载
    List<Videos> listVideoPage(String type, int page, int size);

}
