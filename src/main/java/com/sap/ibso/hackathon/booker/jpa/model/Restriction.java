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
public class Restriction extends UUIDEntity {

    @NotNull
    @Column(columnDefinition = "CHAR(1)", nullable = false)
    private char type;

    @NotNull
    @Column(nullable = false)
    private Date startDate;

    @NotNull
    @Column(nullable = false)
    private Date endDate;

    @NotNull
    @Column(columnDefinition = "CHAR(1)", nullable = false)
    private String entityType;

    @NotNull
    @Column(columnDefinition = "CHAR(36)", nullable = false)
    @Type(type = "uuid-char")
    private UUID entityId;

    @Size(max = 250)
    @Column(length = 250)
    private String comments;
}