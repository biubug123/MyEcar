package com.ecar.service.serviceimplement;

import com.ecar.dao.CarDAO;
import com.ecar.dao.CarLogoDAO;
import com.ecar.dao.CarMaintenanceDAO;
import com.ecar.entity.Car;
import com.ecar.entity.CarLogo;
import com.ecar.entity.Check;
import com.ecar.service.CarLogoService;
import com.ecar.service.CarMaintenanceService;
import com.ecar.service.CarService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarImp implements CarLogoService, CarService, CarMaintenanceService {

    @Autowired
    private CarLogoDAO carLogoDAO;

    @Autowired
    private CarDAO carDAO;

    @Autowired
    private CarMaintenanceDAO carMaintenanceDAO;

    @Value("${upLoadPath.logoPath}")
    private String logoPath;

    private static Logger logger = Logger.getLogger(CarImp.class);

    @Override
    public Map<String, List<CarLogo>> listCarLogo() {
        try {
            // 从DAO层取出所有车辆列表
            List<CarLogo> carLogoList = carLogoDAO.listCarLogo();

            List<CarLogo> carLogoArrayList = new ArrayList<>();

            for(CarLogo carLogo :  carLogoList) {
                carLogo.setLogoUrl(logoPath + carLogo.getLogoUrl());

                carLogoArrayList.add(carLogo);
            }
            // 创建Map集合存储Logo,key为logoAlphabet,value为具体车型.
            Map<String, List<CarLogo>> carLogoMap = new HashMap<>();

            // 将所有车辆列表对应存入Map集合
            for (CarLogo aCarLogoList : carLogoArrayList) {
                if (carLogoMap.containsKey(aCarLogoList.getLogoAlphabet())) {
                    List<CarLogo> carLogos = carLogoMap.get(aCarLogoList.getLogoAlphabet());
                    carLogos.add(aCarLogoList);
                    carLogoMap.put(aCarLogoList.getLogoAlphabet(), carLogos);
                } else {
                    List<CarLogo> carLogos = new ArrayList<>();
                    carLogos.add(aCarLogoList);
                    carLogoMap.put(aCarLogoList.getLogoAlphabet(), carLogos);
                }
            }

            return carLogoMap;
        } catch(Exception e) {
            // 日志记录错误信息
            logger.error(e.getMessage(), e);

            return null;
        }
    }

    @Override
    public List<Car> listCarByBrandId(String brandId) {
        try {
            List<Car> carList = carDAO.listCarByBrandId(brandId);

            return carList;
        } catch(Exception e) {
            logger.error(e.getMessage(), e);

            return null;
        }
    }

    @Override
    public Car getCarByCid(String cid) {
        Car car = carDAO.getCarByCid(cid);

        return car;
    }

    @Override
    public List<Check> listChecksByBrandIdAndType(String brandId, int type) {
        long weight = Math.round(type / 10000);

        System.out.println(weight);

        if(weight == 0) {
            type = 1;
        } else {
            if (weight % 4 == 1) type = 1;
            if (weight % 4 == 2) type = 2;
            if (weight % 4 == 3) type = 3;
            if (weight % 4 == 0) type = 4;
        }

        List<Check> checks = carMaintenanceDAO.listChecksByBrandIdAndType(brandId, type);

        return checks;
    }

    @Override
    public int calCost(String carPrice, int zj, int basePrice) {
        carPrice = carPrice.substring(0, carPrice.indexOf("万"));
        System.out.println(carPrice);

        double factor = Double.parseDouble(carPrice) * 10000 / basePrice;

        System.out.println("factor" + factor);

        double weight = 0;

        if(weight>=5){
            weight = zj*2*factor;
        }else if(weight>=3){
            weight = zj*1.667*factor;
        }else if(weight>=2){
            weight = zj*1.5*factor;
        }else if(weight>=1.5){
            weight = zj*1.333*factor;
        }else if(weight>=1.2){
            weight = zj*1.125*factor;
        }else if(weight>=1){
            weight = zj*1.083*factor;
        }else if(weight>=0.8){
            weight = zj*0.917*factor;
        }else if(weight>=0.6){
            weight = zj*0.8*factor;
        }else if(weight>=0.3){
            weight = zj*0.75*factor;
        }else{
            System.out.println("是这条不");
            weight = zj*0.5*factor;
            System.out.println(weight);
        }
        zj = (int)(Math.round(weight));
        System.out.println(zj);

        return zj;
    }
}
