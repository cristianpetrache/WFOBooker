package com.sap.ibso.hackathon.booker.exception;

import com.sap.ibso.hackathon.booker.jpa.model.UUIDEntity;
import lombok.Getter;

public class UUIDEntityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -6909051897962683375L;

    @Getter
    private Class<? extends UUIDEntity> notFoundEntityType;

    public UUIDEntityNotFoundException(
            Class<? extends UUIDEntity> notFoundEntityType) {
        this.notFoundEntityType = notFoundEntityType;
    }

    @Override
    public String getMessage() {
        return "UUID Entity not found: " + getNotFoundEntityType().getSimpleName();
    }
}
