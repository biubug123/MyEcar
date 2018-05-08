package com.ecar.service.serviceimplement;

import com.ecar.dao.ConsultDAO;
import com.ecar.entity.Consult;
import com.ecar.service.ConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ConsultImp implements ConsultService {

    @Autowired
    private ConsultDAO consultDAO;

    public List<Consult> listConsult(String videoId) {
        List<Consult> consults = consultDAO.listConsult(videoId);

        return consults;
    }

    @Override
    public int insertConsult(String vid, String title, String content, String phone) {
        String cid = UUID.randomUUID().toString();
        Long date = new Date().getTime();

        int result = consultDAO.insertConsult(title, content, phone, cid, vid, date);

        return result;
    }

}
