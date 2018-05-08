package com.ecar.service;

import com.ecar.entity.Car;
import com.ecar.entity.CarLogo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface CarLogoService {

    // 获取车标
    Map<String, List<CarLogo>> listCarLogo();

}
