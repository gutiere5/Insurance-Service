package com.noel.service;

import com.noel.model.Insurance;
import java.util.List;

public interface InsuranceService {

  Insurance create(Insurance insurance, String vehicleId);

  List<Insurance> getAllInsurances();

  Insurance findById(String insuranceID);

  Insurance findByVehicleID(String vehicleId);

  void removeInsurance(String insuranceID);
}
