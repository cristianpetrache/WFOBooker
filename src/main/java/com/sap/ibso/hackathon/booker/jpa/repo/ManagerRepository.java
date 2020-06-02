package com.sap.ibso.hackathon.booker.jpa.repo;

import com.sap.ibso.hackathon.booker.jpa.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface ManagerRepository extends JpaRepository<Manager, UUID> {

    /**
     * Finds the potential manager of this entity (employee, location, building, floor or seat)
     * @param entityType E, L, B, F or S - employee, location, building, floor or seat
     * @param entityId employee, location, building, floor or seat entity id
     * @return the optional manager of this entity
     */
    Optional<Manager> findOptionalByEntityTypeAndEntityId(String entityType, UUID entityId);

    /**
     * Finds the set of entities managed by this employee id
     * @param entityType E, L, B, F or S - employee, location, building, floor or seat
     * @param employeeId the manager employee id
     * @return the set of entities managed by this employee
     */
    Set<Manager> findByEntityTypeAndEmployeeId(String entityType, UUID employeeId);
}
