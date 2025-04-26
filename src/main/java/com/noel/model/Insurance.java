package com.noel.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.noel.constants.AppConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Insurance {
    @Id
    @Column(length = 50)
    private String id;

    @Column(length = 15)
    @Enumerated(EnumType.STRING)
    private InsuranceStatus status;

    @NotBlank(message = AppConstants.VEHICLEID_MANDATORY)
    @Column(length = 50)
    private String vehicleId;

    @NotBlank(message = AppConstants.PROVIDER_MANDATORY)
    @Column(length = 50)
    private String provider;

    @NotBlank(message = AppConstants.POLICYNUMBER_MANDATORY)
    @JsonProperty("policy_number")
    @Column(length = 50)
    private String policyNumber;

    @JsonProperty("start_date")
    @Column(length = 50)
    private Date startDate;

    @JsonProperty("end_date")
    @Column(length = 50)
    private Date endDate;

}

