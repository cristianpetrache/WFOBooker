package com.sap.ibso.hackathon.booker.service;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sap.ibso.hackathon.booker.jpa.model.Preference;

@Service
public class PreferenceService extends BookerEntityService<Preference> {

	public PreferenceService(JpaRepository<Preference, UUID> preferenceRepository) {
		super(preferenceRepository);
	}

}
