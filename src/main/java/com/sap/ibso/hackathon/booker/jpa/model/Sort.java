package com.sap.ibso.hackathon.booker.jpa.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Sort implements Serializable {

    private static final long serialVersionUID = -2016350876293786027L;

    enum Direction {
        ASC,
        DESC
    }

    private Direction direction;
    private String field;

    public boolean isAsc() {
        return Direction.ASC == direction;
    }
}
