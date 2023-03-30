package com.stevenhornghub.promotionrequest.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Employee")
@DiscriminatorValue("Employee")
@Data
public class Employees extends User {

    @Column(name = "contract_type", length = 255)
    private String contractType;

}
