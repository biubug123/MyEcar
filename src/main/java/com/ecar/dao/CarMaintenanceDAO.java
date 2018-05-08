package com.ecar.dao;


import com.ecar.entity.Check;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CarMaintenanceDAO {

    List<Check> listChecksByBrandIdAndType(@Param("brandId") String brandId, @Param("type") int type);

}
