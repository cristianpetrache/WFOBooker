package com.sap.ibso.hackathon.booker.jpa.model;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.StringJoiner;
import java.util.stream.Collectors;

public class PageableImpl implements Pageable {

    private PageRequest pageRequest;
    private transient Sort sort;

    public PageableImpl(PageRequest pageRequest) {
        this.pageRequest = pageRequest;
        sort = Sort.by(
                pageRequest.getSortList()
                           .stream()
                           .map(sort -> new Sort.Order(sort.isAsc() ? Sort.Direction.ASC : Sort.Direction.DESC,
                            sort.getField()))
                           .collect(Collectors.toList()));
    }

    @Override
    public int getPageNumber() {
        return pageRequest.getPageNumber();
    }

    @Override
    public int getPageSize() {
        return pageRequest.getPageSize();
    }

    @Override
    public long getOffset() {
        return pageRequest.getOffset();
    }

    @Override
    public Sort getSort() {
        return sort;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PageableImpl.class.getSimpleName() + "[", "]")
                .add("pageRequest=" + pageRequest)
                .toString();
    }
}
