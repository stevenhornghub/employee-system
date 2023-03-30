package com.stevenhornghub.promotionrequest.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@DiscriminatorValue(value = "PROMOTION")
public class Promotion extends Request implements Serializable {


    @Column(name = "reason_of_promotion", nullable = true)
    private String reasonOfPromotion;


    @JsonFormat(pattern = "yyyy/MM/dd")
    @Column(name = "effective_date", nullable = true)
    private Date effectiveDate;


}
