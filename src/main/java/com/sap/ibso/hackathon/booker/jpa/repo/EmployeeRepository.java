package com.sap.ibso.hackathon.booker.jpa.repo;

import com.sap.ibso.hackathon.booker.jpa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    Optional<Employee> findOptionalByCode(String code);
}
