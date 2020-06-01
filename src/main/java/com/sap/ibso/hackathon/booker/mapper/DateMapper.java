package com.sap.ibso.hackathon.booker.mapper;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DateMapper implements Mapper<Date, String> {

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date mapZtoY(String stringDate) {
        try {
            return stringDate != null ? dateFormat.parse(stringDate) : null;
        } catch (ParseException e) {
            //TODO log the event
            return null;
        }
    }

    @Override
    public String mapYtoZ(Date date) {
        return date != null ? dateFormat.format(date) : null;
    }
}
