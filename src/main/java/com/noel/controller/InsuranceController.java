package com.noel.controller;

import com.noel.model.Insurance;
import com.noel.service.InsuranceService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insurance")
@AllArgsConstructor
public class InsuranceController {
    // http://localhost:8081/vehicles
    private final InsuranceService insuranceService;

    @PostMapping("/{vehicleId}")
    public Insurance create(@Valid @RequestBody Insurance insurance, @PathVariable String vehicleId) {
    return insuranceService.create(insurance, vehicleId);
    }

    @GetMapping
    public List<Insurance> getAllInsurance() {
        return insuranceService.getAllInsurances();
    }

    @GetMapping("/{vehicleId}")
    public Insurance findById(@PathVariable String insuranceID) {
        return insuranceService.findById(insuranceID);
    }

    // http://localhost:8081/vehicles/{vehicleId}/user/{userId}
    @PostMapping("/{vehicleId}/user/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void findByVehicleID(@PathVariable String vehicleId) {
        insuranceService.findByVehicleID(vehicleId);
    }

    @DeleteMapping("/{vehicleId}/user/{userId}")
    public void removeInsurance(@PathVariable String insuranceID) {
        insuranceService.removeInsurance(insuranceID);
    }
}