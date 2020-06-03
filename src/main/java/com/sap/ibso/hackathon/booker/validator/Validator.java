package com.sap.ibso.hackathon.booker.validator;

import java.util.Collection;

public interface Validator<T> {

    void validate(T element);

    default void validate(Collection<T> elementCollection) {
        elementCollection.stream().forEach(this::validate);
    }
}
