package com.sap.ibso.hackathon.booker.jpa.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sap.ibso.hackathon.booker.jpa.model.Restriction;

public interface RestrictionRepository extends JpaRepository<Restriction, UUID> {

}
