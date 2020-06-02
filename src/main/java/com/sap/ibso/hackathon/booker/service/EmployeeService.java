package com.sap.ibso.hackathon.booker.service;

import com.sap.ibso.hackathon.booker.jpa.model.Employee;
import com.sap.ibso.hackathon.booker.jpa.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService extends BookerEntityService<Employee> {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        super(employeeRepository);
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> findOptionalByCode(String employeeCode) {
        return employeeRepository.findOptionalByCode(employeeCode);
    }

    public Optional<Employee> findOptionalById(UUID id) {
        return employeeRepository.findById(id);
    }
}
