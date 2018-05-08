package com.ecar.dao;

import com.ecar.entity.Car;
import com.ecar.entity.CarLogo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface CarLogoDAO {

    // 获取全部车标
    List<CarLogo> listCarLogo();

}
