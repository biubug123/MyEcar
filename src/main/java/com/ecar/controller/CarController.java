package com.ecar.controller;

import com.ecar.dao.CarMaintenanceDAO;
import com.ecar.entity.Car;
import com.ecar.entity.CarLogo;
import com.ecar.entity.Check;
import com.ecar.service.CarLogoService;
import com.ecar.service.CarMaintenanceService;
import com.ecar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class CarController {

    @Autowired
    private CarLogoService carLogoService;

    @Autowired
    private CarService carService;

    @Autowired
    private CarMaintenanceService carMaintenanceService;

    @RequestMapping(value = "/listCarLogo", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public Map<String, List<CarLogo>> getCarLogoList() {
        Map<String, List<CarLogo>> carLogoMap = carLogoService.listCarLogo();

        return carLogoMap;
    }

    @RequestMapping(value = "/listCarByBrandId",method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public List<Car> listCarByBrandId(@RequestParam("brandId") String brandId) {
        List<Car> carList = carService.listCarByBrandId(brandId);

        return carList;
    }

    @RequestMapping(value = "/listChecksByBrandIdAndType", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public List<Check> getChecksByBrandIdAndType(@RequestParam("brandId") String brandId, @RequestParam("type") int type) {
        List<Check> checks = carMaintenanceService.listChecksByBrandIdAndType(brandId, type);

        return checks;
    }

    @RequestMapping(value = "/calCost", method = RequestMethod.GET)
    @ResponseBody

    public int calCost(@RequestParam("carPrice") String carPrice, @RequestParam("zj") int zj, @RequestParam("basePrice") int basePrice) {
        int cost = carMaintenanceService.calCost(carPrice, zj, basePrice);

        return cost;
    }


    @RequestMapping(value = "/getCarByCid", method = RequestMethod.GET)
    @ResponseBody
    public Car getCarByCid(@RequestParam("cid")String cid) {
        Car car = carService.getCarByCid(cid);

        return car;
    }
}
