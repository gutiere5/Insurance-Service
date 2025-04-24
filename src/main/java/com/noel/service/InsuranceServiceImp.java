package com.noel.service;


import com.noel.model.Insurance;
import com.noel.model.InsuranceStatus;
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
  public Insurance create(Insurance insurance, String vehicleId) {
    insurance.setId(UUID.randomUUID().toString());
    insurance.setVehicleId(vehicleId);
    return insuranceRepository.save(insurance);
  }

  @Override
  public List<Insurance> getAllInsurances() {
    return (List<Insurance>)  insuranceRepository.findAll();
  }

  @Override
  public Insurance findById(String insuranceID) {
    return insuranceRepository.findById(insuranceID).orElseThrow();
  }

  @Override
  public Insurance findByVehicleID(String vehicleId) {
    return insuranceRepository.findById(vehicleId).orElseThrow();
  }

  @Override
  public void removeInsurance(String insuranceID) {
      insuranceRepository.deleteById(insuranceID);
  }
}
