package com.ecar.dao;

import com.ecar.entity.Consult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ConsultDAO {

    List<Consult> listConsult(@Param("videoId")String videoId);

    int insertConsult(@Param("title")String title, @Param("content")String content, @Param("phone")String phone, @Param("cid")String cid,
        @Param("vid")String vid, @Param("date") Long date);
}
