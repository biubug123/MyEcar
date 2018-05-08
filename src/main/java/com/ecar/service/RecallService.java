package com.ecar.service;

import com.ecar.entity.Recall;
import com.ecar.entity.Vin;

import java.util.List;

public interface RecallService {

    List<Recall> listRecall();

    Recall getRecallByUUID(String uuid);

    List<Vin> listVinByRid(String rid);

    Boolean getVinIsRecall(String vin);

    List<Recall> listRecallByKeyword(String keyword);
}
