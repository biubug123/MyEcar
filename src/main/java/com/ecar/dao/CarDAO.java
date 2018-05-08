package com.ecar.dao;

import com.ecar.entity.Car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;

import java.util.List;

@Mapper
public interface CarDAO {

    //根据车系取相对应车
    List<Car> listCarByBrandId(@Param("brandId") String brandId);

    Car getCarByCid(@Param("cid")String cid);
}
