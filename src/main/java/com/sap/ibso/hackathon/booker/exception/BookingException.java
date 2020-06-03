package com.sap.ibso.hackathon.booker.exception;

public class BookingException extends RuntimeException {
    private static final long serialVersionUID = -7339347159954617726L;

    public BookingException(String message) {
        super(message);
    }
}
