package com.sap.ibso.hackathon.booker.mapper;

import com.sap.ibso.hackathon.booker.dto.BookingDto;
import com.sap.ibso.hackathon.booker.jpa.model.Booking;
import org.springframework.stereotype.Service;

@Service
public class BookingMapper implements Mapper<Booking, BookingDto> {

    private DateMapper dateMapper;

    public BookingMapper(DateMapper dateMapper) {
        this.dateMapper = dateMapper;
    }

    @Override
    public Booking mapZtoY(BookingDto bookingDto) {
        Booking booking = new Booking();
        booking.setComments(bookingDto.getComments());
        booking.setDate(dateMapper.mapZtoY(bookingDto.getDate()));
        booking.setSeatId(bookingDto.getSeatId());
        return booking;
    }

    @Override
    public BookingDto mapYtoZ(Booking booking) {
        return BookingDto.builder()
                         .comments(booking.getComments())
                         .date(dateMapper.mapYtoZ(booking.getDate()))
                         .seatId(booking.getSeatId())
                         .build();
    }
}
