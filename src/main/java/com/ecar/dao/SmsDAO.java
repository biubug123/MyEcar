package com.ecar.dao;

import com.ecar.entity.Smscode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SmsDAO {

    Smscode getSmsCodeByPhone(@Param("phone")String phone);

    int updateSmscode(@Param("code")String code, @Param("lastTime")Long lastTime, @Param("phone")String phone);

    int insertSmscode(@Param("phone")String phone, @Param("code")String code, @Param("lastTime")Long lastTime);
}
