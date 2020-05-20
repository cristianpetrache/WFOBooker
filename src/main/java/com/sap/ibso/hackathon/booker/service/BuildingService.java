package com.sap.ibso.hackathon.booker.service;

import com.sap.ibso.hackathon.booker.jpa.model.Building;
import com.sap.ibso.hackathon.booker.jpa.model.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BuildingService {

    private JpaRepository<Building, UUID> buildingRepository;

    public BuildingService(
            JpaRepository<Building, UUID> buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @Transactional(readOnly = true)
    public Page<Building> getAll(PageRequest pageRequest) {
        Pageable pageable = pageRequest.getPageable();
        Page<Building> buildingPage = buildingRepository.findAll(pageable);
        return buildingPage;
    }

    public List<Building> createAll(List<Building> createBuildingList) {
        return buildingRepository.saveAll(createBuildingList);
    }

    public List<Building> deleteAll(List<UUID> deleteBuildingIdList) {
        List<Building> deleteBuildingList = buildingRepository.findAllById(deleteBuildingIdList);
        buildingRepository.deleteInBatch(deleteBuildingList);
        return deleteBuildingList;
    }
}
