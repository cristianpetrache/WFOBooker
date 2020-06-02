package com.sap.ibso.hackathon.booker.jpa.repo;

import com.sap.ibso.hackathon.booker.jpa.model.Preference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface PreferenceRepository extends JpaRepository<Preference, UUID> {

    Set<Preference> findByEmployeeId(UUID employeeId);
}
