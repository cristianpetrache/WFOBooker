package com.sap.ibso.hackathon.booker.jpa.repo;

import com.sap.ibso.hackathon.booker.jpa.model.Restriction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

public interface RestrictionRepository extends JpaRepository<Restriction, UUID> {

    Set<Restriction> findByEntityTypeAndEntityIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            String entityType, UUID entityId, Date startDate, Date endDate);
}
