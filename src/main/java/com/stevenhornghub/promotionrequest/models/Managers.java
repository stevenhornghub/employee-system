package com.stevenhornghub.promotionrequest.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Manager")
@DiscriminatorValue("Manager")
@Data
public class Managers extends User {

    @Column(name = "work_type", length = 255)
    private String workType;

}
