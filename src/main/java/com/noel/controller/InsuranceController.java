package com.noel.controller;

import com.noel.model.Insurance;
import com.noel.service.InsuranceService;
import com.noel.util.UserContext;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insurances")
@AllArgsConstructor
public class InsuranceController {
    // http://localhost:8083/insurances
    private final InsuranceService insuranceService;
    private final ObjectFactory<UserContext> context;


    @PostMapping()
    public Insurance create(@Valid @RequestBody Insurance insurance) {
        context.getObject().assertAdmin();
        return insuranceService.create(insurance);
    }

    @GetMapping
    public List<Insurance> getAllInsurance() {
        return insuranceService.getAllInsurances();
    }

    @GetMapping("/{insuranceID}")
    public Insurance findByInsuranceId(@PathVariable String insuranceID) {
        return insuranceService.findInsuranceByID(insuranceID);
    }

    // http://localhost:8081/vehicles/{vehicleId}/user/{userId}
    @GetMapping("/vehicle/{vehicleID}")
    public Insurance findByVehicleID(@PathVariable String vehicleID) {
        return insuranceService.findInsuranceByVehicleID(vehicleID);
    }

    @DeleteMapping("/{insuranceID}")
    public void removeInsurance(@PathVariable String insuranceID) {
        context.getObject().assertAdmin();
        insuranceService.deleteInsurance(insuranceID);
    }
}