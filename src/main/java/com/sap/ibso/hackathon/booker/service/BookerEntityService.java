package com.sap.ibso.hackathon.booker.service;

import com.sap.ibso.hackathon.booker.jpa.model.PageRequest;
import com.sap.ibso.hackathon.booker.jpa.model.UUIDEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public class BookerEntityService<T extends UUIDEntity> {

    private JpaRepository<T, UUID> jpaRepository;

    public BookerEntityService(JpaRepository<T, UUID> jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Transactional(readOnly = true)
    public Page<T> getAll(PageRequest pageRequest) {
        Pageable pageable = pageRequest.getPageable();
        Page<T> tPage = jpaRepository.findAll(pageable);
        return tPage;
    }

    @Transactional
    public List<T> createAll(List<T> createTList) {
        return jpaRepository.saveAll(createTList);
    }

    @Transactional
    public List<T> deleteAll(List<UUID> deleteTIdList) {
        List<T> deleteTList = jpaRepository.findAllById(deleteTIdList);
        jpaRepository.deleteInBatch(deleteTList);
        return deleteTList;
    }
}
