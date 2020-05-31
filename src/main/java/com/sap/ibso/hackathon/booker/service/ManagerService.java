package com.sap.ibso.hackathon.booker.service;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sap.ibso.hackathon.booker.jpa.model.Manager;

@Service
public class ManagerService extends BookerEntityService<Manager> {

	public ManagerService(JpaRepository<Manager, UUID> managerRepository) {
		super(managerRepository);
	}

}
