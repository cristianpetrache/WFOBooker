package com.sap.ibso.hackathon.booker.service;

import com.sap.ibso.hackathon.booker.jpa.model.Preference;
import com.sap.ibso.hackathon.booker.jpa.repo.PreferenceRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class PreferenceService extends BookerEntityService<Preference> {

    private PreferenceRepository preferenceRepository;

    public PreferenceService(
            JpaRepository<Preference, UUID> jpaRepository,
            PreferenceRepository preferenceRepository) {
        super(jpaRepository);
        this.preferenceRepository = preferenceRepository;
    }

    public Set<Preference> findByEmployeeId(UUID employeeId) {
        return preferenceRepository.findByEmployeeId(employeeId);
    }
}
