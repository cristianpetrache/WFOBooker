package com.sap.ibso.hackathon.booker.jpa.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Entity
public class Seat extends UUIDEntity {

    @NotNull
    @Column(name = "floor_id", columnDefinition = "CHAR(36)", nullable = false)
    @Type(type = "uuid-char")
    private UUID floorId;
    @Size(max = 10)
    @Column(length = 10)
    private String code;
}
