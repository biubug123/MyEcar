package com.ecar.service;

import com.ecar.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    // 根据车系查询对应车组
    List<Car> listCarByBrandId(String brandId);

    Car getCarByCid(String cid);

}
