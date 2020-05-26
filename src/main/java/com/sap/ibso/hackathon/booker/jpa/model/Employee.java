package com.sap.ibso.hackathon.booker.jpa.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class Employee extends UUIDEntity {

    @NotNull
    @Size(max = 10)
    @Column(length = 10, nullable = false)
    private String code;
    @NotBlank
    @Size(max = 100)
    @Column(length = 100, nullable = false)
    private String name;
    @Size(max = 100)
    @Column(length = 100)
    private String email;
}
