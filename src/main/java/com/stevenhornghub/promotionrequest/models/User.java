package com.stevenhornghub.promotionrequest.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stevenhornghub.promotionrequest.models.enums.SalaryCurrency;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(name = "user_username_unique", columnNames = "username"),
        @UniqueConstraint(name = "user_email_unique", columnNames = "email")
})
@DiscriminatorColumn(name = "employee_type", discriminatorType = DiscriminatorType.STRING,
        columnDefinition = "VARCHAR(31)")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    //    @NotNull
//    @NotEmpty
    @Column(name = "username", nullable = false, length = 255)
    private String username;

    //    @NotNull
    @Size(min = 8, message = "Password must have at least 8 characters!")
    @Column(name = "password", nullable = false, length = 255)
    private String password;

    //    @NotBlank
    @Email
    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "telegram", nullable = false, length = 255)
    private String telegram;

    //    @NotBlank
    @Column(name = "mobile_phone", nullable = false, length = 255)
    private String mobilePhone;

    @Column(name = "home_phone", length = 255)
    private String homePhone;

    //    @NotEmpty
    @Column(name = "address", nullable = false, length = 255)
    private String address;

    //    @NotEmpty
    @Column(name = "first_name", nullable = false, length = 255)
    private String firstName;

    //    @NotEmpty
    @Column(name = "last_name", nullable = false, length = 255)
    private String lastName;

    //    @NotNull
    @JsonFormat(pattern = "yyyy/MM/dd")
    @Column(name = "date_of_entry", nullable = false)
//    @Temporal(TemporalType.DATE)
    private Date dateOfEntry;

    //    @NotBlank
    @Column(name = "position", nullable = false, length = 255)
    private String position;

    //    @NotBlank
    @Column(name = "department", nullable = false, length = 255)
    private String department;

    //    @NotEmpty
    @Column(name = "rank", nullable = false, length = 255)
    private String rank;

    //    @NotEmpty
    @Column(name = "nationality", nullable = false, length = 255)
    private String nationality;

    //    @NotEmpty
    @Column(name = "immediate_supervisor", nullable = false, length = 255)
    private String immediateSupervisor;

    //    @NotEmpty
    @Column(name = "salary", nullable = false, length = 255)
    private String salary;

    //    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false, length = 255)
    private SalaryCurrency salaryCurrency;

}
