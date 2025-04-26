package com.noel.service;


import com.noel.model.Insurance;
import com.noel.repository.InsuranceRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class InsuranceServiceImp implements InsuranceService {

  private final InsuranceRepository insuranceRepository;

  @Override
  public Insurance create(Insurance insurance) {
    insurance.setId(UUID.randomUUID().toString());
    return insuranceRepository.save(insurance);
  }

  @Override
  public List<Insurance> getAllInsurances() {
    return (List<Insurance>)  insuranceRepository.findAll();
  }

  @Override
  public Insurance findInsuranceByID(String insuranceID) {
    return insuranceRepository.findById(insuranceID).orElseThrow();
  }

  @Override
  public Insurance findInsuranceByVehicleID(String vehicleId) {
    return insuranceRepository
            .findByVehicleId(vehicleId)
            .orElseThrow();
  }

  @Override
  public void deleteInsurance(String insuranceID) {
      insuranceRepository.deleteById(insuranceID);
  }
}
