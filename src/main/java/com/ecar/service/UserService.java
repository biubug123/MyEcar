package com.ecar.service;

import com.ecar.entity.Collect;
import com.ecar.entity.Record;
import com.ecar.entity.User;

import java.util.List;

public interface UserService {
    User getUser(String userPhone, String password);

    Integer insertVideoRecord(String phone, String videoId);

    Integer updateVideoRecord(String userPhone, String videoId);

    Record getRecord(String phone, String videoId);

    List<Collect> listCollectByPhone(String phone);

    List<Record> listRecordByPhone(String phone);

    int insertOrUpdateRecord(String phone, String videoId);
}
