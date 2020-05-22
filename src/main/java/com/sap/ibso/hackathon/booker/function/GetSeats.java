package com.sap.ibso.hackathon.booker.function;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.sap.ibso.hackathon.booker.jpa.model.PageRequest;
import com.sap.ibso.hackathon.booker.jpa.model.Seat;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Validated
public class GetSeats extends GetBookerEntities<Seat> {

    @FunctionName("getSeats")
    public HttpResponseMessage getSeats(@HttpTrigger(name = "request", methods = {HttpMethod.GET}, route = "seats",
            authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<PageRequest>> request,
                                        ExecutionContext context) {
        return getEntities(request, context);
    }
}
