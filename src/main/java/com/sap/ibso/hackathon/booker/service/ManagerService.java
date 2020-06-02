package com.sap.ibso.hackathon.booker.service;

import com.sap.ibso.hackathon.booker.jpa.model.Manager;
import com.sap.ibso.hackathon.booker.jpa.repo.ManagerRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class ManagerService extends BookerEntityService<Manager> {

    private ManagerRepository managerRepository;

    public ManagerService(
            JpaRepository<Manager, UUID> jpaRepository,
            ManagerRepository managerRepository) {
        super(jpaRepository);
        this.managerRepository = managerRepository;
    }

    public Optional<Manager> findOptionalByEntityTypeAndEntityId(String entityType, UUID entityId) {
        return managerRepository.findOptionalByEntityTypeAndEntityId(entityType, entityId);
    }

    public Set<Manager> findByEntityTypeAndEmployeeId(String entityType, UUID employeeId) {
        return managerRepository.findByEntityTypeAndEmployeeId(entityType, employeeId);
    }

}
