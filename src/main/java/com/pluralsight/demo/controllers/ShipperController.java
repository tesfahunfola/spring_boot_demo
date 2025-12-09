package com.pluralsight.demo.controllers;

import com.pluralsight.demo.daos.ShipperDao;
import com.pluralsight.demo.models.Product;
import com.pluralsight.demo.models.Shipper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shippers")
public class ShipperController {
    private ShipperDao shipperDao;

    public ShipperController(ShipperDao shipperDao) {
        this.shipperDao = shipperDao;
    }

    @GetMapping
    public List<Shipper> getAllShippers(){
        return shipperDao.getAllShippers();
    }

    @GetMapping("/search")
    public List<Shipper> searchShippersByName(@RequestParam String name){
        return shipperDao.getShipperByName(name);
    }
}
