package com.ecar.controller;

import com.ecar.entity.Recall;
import com.ecar.entity.Vin;
import com.ecar.service.CarLogoService;
import com.ecar.service.RecallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RecallController {

    @Autowired
    private RecallService recallService;

    @RequestMapping(value = "/listRecall", method = RequestMethod.GET)
    @ResponseBody
    public List<Recall> listRecall() {
        List<Recall> listRecall = recallService.listRecall();

        return listRecall;
    }

    @RequestMapping(value = "/listRecall/getRecallByUUID", method = RequestMethod.GET)
    @ResponseBody
    public Recall getRecallByUUID(@RequestParam("rid") String rid) {
        Recall recall = recallService.getRecallByUUID(rid);

        return recall;
    }

    @GetMapping("/listVinByRid")
    @ResponseBody
    public List<Vin> listVinByRid(@RequestParam("rid")String rid) {
        List<Vin> vinList = recallService.listVinByRid(rid);

        return vinList;
    }

    @PostMapping("/getVinIsRecall")
    @ResponseBody
    public boolean getVinIsRecall(@RequestParam("vin")String vin) {
        boolean result = recallService.getVinIsRecall(vin);

        return result;
    }

    @GetMapping("/listRecallByKeyword")
    @ResponseBody
    public List<Recall> listRecallByKeyword(@RequestParam("keyword")String keyword) {
        List<Recall> recallList = recallService.listRecallByKeyword(keyword);

        return recallList;
    }
}
