package com.sap.ibso.hackathon.booker.service;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sap.ibso.hackathon.booker.jpa.model.Restriction;

@Service
public class RestrictionService extends BookerEntityService<Restriction> {

	public RestrictionService(JpaRepository<Restriction, UUID> restrictionRepository) {
		super(restrictionRepository);
	}

}
