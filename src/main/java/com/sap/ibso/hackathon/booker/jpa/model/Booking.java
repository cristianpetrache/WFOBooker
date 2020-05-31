package com.sap.ibso.hackathon.booker.jpa.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class Booking extends UUIDEntity {

    @NotNull
    @Column(name = "employee_id", columnDefinition = "CHAR(36)", nullable = false)
    @Type(type = "uuid-char")
    private UUID employeeId;
    @NotNull
    @Column(name = "seat_id", columnDefinition = "CHAR(36)", nullable = false)
    @Type(type = "uuid-char")
    private UUID seatId;
    @NotNull
    @Column(nullable = false)
    private Date date;
    @Size(max = 250)
    @Column(length = 250)
    private String comments;
}
