package com.ecar.service;

import com.ecar.entity.Consult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConsultService {
    List<Consult> listConsult(String videoId);

    int insertConsult(String vid, String title, String content, String phone);
}
