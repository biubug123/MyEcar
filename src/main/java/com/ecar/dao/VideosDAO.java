package com.ecar.dao;

import com.ecar.entity.Videos;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Mapper
public interface VideosDAO {

    // 根据视频种类提取视频
    List<Videos> listVideoByType(@Param("type") String type);

    Videos getVideosByUUID(@Param("uuid") String uuid);

    int insertRecord(@Param("phone")String phone, @Param("videoId")String videoId, @Param("lastDate")Date lastDate);

    List<Videos> listVideosByKeyword(@Param("keyword")String keyword);

    List<Videos> listVideoPage(@Param("type")String type, @Param("startRow")int startRow, @Param("size")int size);

    List<Videos> listVideo();
}
