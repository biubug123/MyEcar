package com.ecar.dao;

import com.ecar.entity.Recall;
import com.ecar.entity.Vin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecallDAO {

    List<Recall> listRecall();

    Recall getRecallByUUID(@Param("uuid") String uuid);

    List<Vin> listVinByRid(@Param("rid")String rid);

    List<Vin> listVin();

    List<Recall> listRecallByKeyword(@Param("keyword")String keyword);
}
