package com.ecar.service.serviceimplement;

import com.ecar.dao.RecallDAO;
import com.ecar.entity.Recall;
import com.ecar.entity.Vin;
import com.ecar.service.RecallService;
import com.ecar.util.VinValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecallImp implements RecallService{

    @Autowired
    private RecallDAO recallDAO;

    @Override
    public List<Recall> listRecall() {
        List<Recall> listRecall = recallDAO.listRecall();

        return listRecall;
    }

    @Override
    public Recall getRecallByUUID(String uuid) {
        Recall recall = recallDAO.getRecallByUUID(uuid);

        return recall;
    }

    @Override
    public List<Vin> listVinByRid(String rid) {
        List<Vin> vinList = recallDAO.listVinByRid(rid);

        return vinList;
    }

    @Override
    public Boolean getVinIsRecall(String vin) {
            List<Vin> vinList = recallDAO.listVin();
            boolean result = false;
            for(Vin v : vinList) {
                if(VinValidate.validate(v.getStartnumber(), v.getEndnumber(), vin)) {
                    result = true;
                    break ;
                }
            }
            return result;
    }

    @Override
    public List<Recall> listRecallByKeyword(String keyword) {
        List<Recall> recalls = recallDAO.listRecallByKeyword(keyword);

        return recalls;
    }

}
