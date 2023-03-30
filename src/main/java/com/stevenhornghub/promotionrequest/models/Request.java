package com.stevenhornghub.promotionrequest.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stevenhornghub.promotionrequest.models.enums.Status;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "request", indexes = {
        @Index(name = "FKg03bldv86pfuboqfefx48p6u3", columnList = "id")
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "request_type", discriminatorType = DiscriminatorType.STRING)
public class Request implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;


    @JsonFormat(pattern = "yyyy/MM/dd")
    @Column(name = "date_of_request")
    private Date dateOfRequest;


    @JsonFormat(pattern = "yyyy/MM/dd")
    @Column(name = "date_of_update")
    private Date dateOfUpdate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "remarks", nullable = true)
    private String remarks;


}
