package com.sap.ibso.hackathon.booker.function;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.sap.ibso.hackathon.booker.dto.ExceptionDto;
import com.sap.ibso.hackathon.booker.exception.BookingException;
import com.sap.ibso.hackathon.booker.exception.UUIDEntityNotFoundException;
import com.sap.ibso.hackathon.booker.jpa.model.Booking;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Validated
public class PostBookings extends PostBookerEntities<Booking> {

    @FunctionName("postBookings")
    public HttpResponseMessage postBookings(
            @HttpTrigger(name = "request", methods = {HttpMethod.POST}, route = "bookings",
                    authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<List<Booking>>> request,
            ExecutionContext context) {

        try {
            return postEntities(request, context);
        } catch (UUIDEntityNotFoundException uuidEntityNotFoundException) {
            return request
                    .createResponseBuilder(HttpStatus.NOT_FOUND)
                    .body(ExceptionDto.builder().message(uuidEntityNotFoundException.getMessage()).build())
                    .header("Content-Type", "application/json")
                    .build();
        } catch (BookingException bookingException) {
            return request
                    .createResponseBuilder(HttpStatus.BAD_REQUEST)
                    .body(ExceptionDto.builder().message(bookingException.getMessage()).build())
                    .header("Content-Type", "application/json")
                    .build();
        }
    }
}
