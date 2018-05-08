package com.ecar.service;


import com.ecar.entity.Smscode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

public interface SmsService {
    boolean getSmscodeByPhone(String phone, String code);

    int updateSmscode(String code, String phone);

    int inserSmscode(String phone, String code);

    boolean sendCode(String phone);

}
