package com.sap.ibso.hackathon.booker.jpa.model;

import lombok.Data;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class PageRequest implements Serializable {

    private static final long serialVersionUID = 6535604995950533524L;
    private static final PageRequest First1K = new PageRequest(0, 1000, Collections.emptyList());
    private static final Map<Integer, Pageable> PAGEABLE_CACHE = new HashMap<>();

    private final int pageNumber;
    private final int pageSize;
    private final List<Sort> sortList;

    public static PageRequest getFirst1K() {
        return First1K;
    }

    public Pageable getPageable() {
        return PAGEABLE_CACHE.computeIfAbsent(hashCode(), (hashCode) -> new PageableImpl(this));
    }
}
