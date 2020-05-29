package com.sap.ibso.hackathon.booker.mapper;

public interface Mapper<Y, Z> {

    Y mapZtoY(Z z);

    Z mapYtoZ(Y y);
}
