package com.ecar.service.serviceimplement;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.ecar.dao.SmsDAO;
import com.ecar.dao.UserDAO;
import com.ecar.entity.Collect;
import com.ecar.entity.Record;
import com.ecar.entity.Smscode;
import com.ecar.entity.User;
import com.ecar.service.SmsService;
import com.ecar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class UserImp implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    public User getUser(String userPhone, String password) {
        User user = userDAO.getUser(userPhone, password);

        return user;
    }


    @Override
    public Integer insertVideoRecord(String phone, String videoId) {
        String uuid = UUID.randomUUID().toString();
        Long collectDate = new Date().getTime();
        System.out.println(collectDate);

        int result = userDAO.insertVideoRecord(uuid,phone,videoId,collectDate);

        return result;
    }

    @Override
    public Integer updateVideoRecord(String userPhone, String videoId) {
        Long collectDate = new Date().getTime();
        int isCollect;
        Record record = this.getRecord(userPhone, videoId);
        System.out.println(record.getIscollect());
        if(record.getIscollect() == 1) {
            isCollect = 0;
        } else {
            isCollect = 1;
        }
        int result = userDAO.updateVideoRecord(userPhone, videoId, collectDate, isCollect);

        return isCollect;
    }

    @Override
    public Record getRecord(String phone, String videoId) {
        Record record = userDAO.getRecord(phone, videoId);

        return record;
    }

    @Override
    public List<Collect> listCollectByPhone(String phone) {
         List<Collect> collects = userDAO.listCollectByPhone(phone);

         return collects;
    }

    @Override
    public List<Record> listRecordByPhone(String phone) {
        List<Record> records = userDAO.listRecordByPhone(phone);

        return records;
    }

    @Override
    public int insertOrUpdateRecord(String phone, String videoId) {
        if(this.getRecord(phone, videoId) != null) {
            Long date = new Date().getTime();

            int result = userDAO.updateRecord(phone, videoId, date);

            return result;
        } else {
            String uuid = UUID.randomUUID().toString();
            Long date = new Date().getTime();

            int result = userDAO.insertRecord(uuid, phone, videoId, date);

            return result;
        }
    }
}
