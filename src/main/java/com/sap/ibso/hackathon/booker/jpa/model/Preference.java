package com.sap.ibso.hackathon.booker.jpa.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
public class Preference extends UUIDEntity {

	@NotNull
	@Column(name = "employee_id", columnDefinition = "CHAR(36)", nullable = false)
	@Type(type = "uuid-char")
	private UUID employeeId;

	@NotNull
	@Column(columnDefinition = "CHAR(1)", nullable = false)
	private char entityType;

	@NotNull
	@Column(columnDefinition = "CHAR(36)", nullable = false)
	@Type(type = "uuid-char")
	private UUID entityId;

}
