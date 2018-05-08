package com.ecar.service;

import com.ecar.entity.Check;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarMaintenanceService {

    List<Check> listChecksByBrandIdAndType(String brandId, int type);

    int calCost(String carPrice, int zj, int basePrice);

}
