package com.sap.ibso.hackathon.booker.jpa.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Entity
public class Building extends UUIDEntity {

    @NotBlank
    @Pattern(regexp = "[0-9abcde]{8}-[0-9abcde]{4}-[0-9abcde]{4}-[0-9abcde]{4}-[0-9abcde]{12}")
    @Column(name = "location_id", columnDefinition = "CHAR(36)", nullable = false)
    @Type(type = "uuid-char")
    private UUID locationId;
    @NotBlank
    @Size(max = 100)
    @Column(length = 100)
    private String name;
    @Size(max = 10)
    @Column(length = 10)
    private String code;
    private double latitude;
    private double longitude;
    @Size(max = 250)
    @Column(length = 250)
    private String picture;
}
