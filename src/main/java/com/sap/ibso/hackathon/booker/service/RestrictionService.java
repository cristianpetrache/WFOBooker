package com.sap.ibso.hackathon.booker.service;

import com.sap.ibso.hackathon.booker.jpa.model.Restriction;
import com.sap.ibso.hackathon.booker.jpa.repo.RestrictionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Service
public class RestrictionService extends BookerEntityService<Restriction> {

    RestrictionRepository restrictionRepository;

    public RestrictionService(
            JpaRepository<Restriction, UUID> jpaRepository,
            RestrictionRepository restrictionRepository) {
        super(jpaRepository);
        this.restrictionRepository = restrictionRepository;
    }

    public Set<Restriction> findByEntityTypeAndEntityIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            String entityType, UUID entityId, Date startDate, Date endDate) {
        return restrictionRepository.findByEntityTypeAndEntityIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                entityType, entityId, startDate, endDate);
    }
}
