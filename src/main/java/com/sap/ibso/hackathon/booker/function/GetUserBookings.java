package com.sap.ibso.hackathon.booker.function;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.BindingName;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.sap.ibso.hackathon.booker.dto.ExceptionDto;
import com.sap.ibso.hackathon.booker.dto.UserBookingDto;
import com.sap.ibso.hackathon.booker.dto.UserBookingRequestDto;
import com.sap.ibso.hackathon.booker.exception.UUIDEntityNotFoundException;
import com.sap.ibso.hackathon.booker.jpa.model.PageRequest;
import com.sap.ibso.hackathon.booker.service.ExecutionContextHolderService;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Validated
public class GetUserBookings extends AzureSpringBootRequestHandler<UserBookingRequestDto, UserBookingDto> {

    @FunctionName("getUserBookings")
    public HttpResponseMessage getUserBookings(
            @HttpTrigger(name = "request", methods = {HttpMethod.GET}, route = "userBookings/{userCode}",
                    authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<PageRequest>> request,
            @BindingName("userCode") String userCode,
            ExecutionContext context) {

        ExecutionContextHolderService.getInstance().setExecutionContext(context);
        UserBookingDto userBookingDto = null;
        String startDate = request.getQueryParameters().get("startDate");
        String endDate = request.getQueryParameters().get("endDate");
        context.getLogger().info("get user bookings for '" + userCode + "', start date: " + startDate +
                ", end date " + endDate);
        try {
            userBookingDto = handleRequest(UserBookingRequestDto.builder()
                                                                .code(userCode)
                                                                .startDate(startDate)
                                                                .endDate(endDate)
                                                                .build(), context);
        } catch (UUIDEntityNotFoundException uuidEntityNotFoundException) {
            return request
                    .createResponseBuilder(HttpStatus.NOT_FOUND)
                    .body(ExceptionDto.builder().message(uuidEntityNotFoundException.getMessage()).build())
                    .header("Content-Type", "application/json")
                    .build();
        }
        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(userBookingDto)
                .header("Content-Type", "application/json")
                .build();
    }
}
