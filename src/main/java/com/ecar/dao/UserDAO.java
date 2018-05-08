package com.ecar.dao;

import com.ecar.entity.Collect;
import com.ecar.entity.Consult;
import com.ecar.entity.Record;
import com.ecar.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface UserDAO {
    User getUser(@Param("phone")String phone, @Param("password")String password);

    Integer insertUser(@Param("phone")String phone, @Param("openId")String openId);

    Integer insertVideoRecord(@Param("uuid")String uuid, @Param("phone")String phone, @Param("videoId") String videoId, @Param("collectDate")Long collectDate);

    Integer updateVideoRecord(@Param("phone")String phone, @Param("videoId")String videoId, @Param("collectDate")Long collectDate, @Param("isCollect")int isCollect);

    Record getRecord(@Param("phone")String phone, @Param("videoId")String videoId);

    List<Collect> listCollectByPhone(@Param("phone") String phone);

    List<Record> listRecordByPhone(@Param("phone") String phone);

    int insertRecord(@Param("uuid")String uuid, @Param("phone")String phone, @Param("videoId")String videoId, @Param("date")Long date);

    int updateRecord(@Param("phone")String phone, @Param("videoId")String videoId, @Param("date")Long date);

    int getSmsCode(@Param("smsCode")String smsCode);


}
