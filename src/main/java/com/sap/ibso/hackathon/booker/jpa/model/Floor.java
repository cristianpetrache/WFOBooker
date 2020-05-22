package com.sap.ibso.hackathon.booker.jpa.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Entity
public class Floor extends UUIDEntity {

    @NotNull
    @Column(name = "building_id", columnDefinition = "CHAR(36)", nullable = false)
    @Type(type = "uuid-char")
    private UUID buildingId;
    @NotBlank
    @Size(max = 100)
    @Column(length = 100)
    private String name;
}
