package com.sap.ibso.hackathon.booker.mapper;

import com.sap.ibso.hackathon.booker.dto.SeatDto;
import com.sap.ibso.hackathon.booker.jpa.model.Seat;
import org.springframework.stereotype.Service;

@Service
public class SeatMapper implements Mapper<Seat, SeatDto> {

    @Override
    public Seat mapZtoY(SeatDto seatDto) {
        Seat seat = new Seat();
        seat.setId(seatDto.getId());
        seat.setCode(seatDto.getCode());
        return seat;
    }

    @Override
    public SeatDto mapYtoZ(Seat seat) {
        return SeatDto
                .builder()
                .id(seat.getId())
                .code(seat.getCode())
                .build();
    }
}
