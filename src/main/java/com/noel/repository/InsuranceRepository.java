package com.noel.repository;

import com.noel.model.Insurance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InsuranceRepository extends CrudRepository<Insurance, String> {
    Optional<Insurance> findByVehicleId(String vehicleId);
}
