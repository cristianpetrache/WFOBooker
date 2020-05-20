package com.sap.ibso.hackathon.booker.jpa.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
public class Location extends UUIDEntity {

    @NotBlank
    @Size(max = 100)
    @Column(unique = true, length = 100)
    private String name;
    private double latitude;
    private double longitude;
    @Size(max = 250)
    @Column(length = 250)
    private String picture;
}
