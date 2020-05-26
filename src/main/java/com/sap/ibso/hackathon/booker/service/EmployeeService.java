package com.sap.ibso.hackathon.booker.service;

import com.sap.ibso.hackathon.booker.jpa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeService extends BookerEntityService<Employee> {

    public EmployeeService(JpaRepository<Employee, UUID> employeeRepository) {
        super(employeeRepository);
    }
}
