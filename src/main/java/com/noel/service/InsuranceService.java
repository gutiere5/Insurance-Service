package com.noel.service;

import com.noel.model.Insurance;
import java.util.List;

public interface InsuranceService {

  Insurance create(Insurance insurance);

  List<Insurance> getAllInsurances();

  Insurance findInsuranceByID(String insuranceID);

  Insurance findInsuranceByVehicleID(String vehicleId);

  void deleteInsurance(String insuranceID);
}
