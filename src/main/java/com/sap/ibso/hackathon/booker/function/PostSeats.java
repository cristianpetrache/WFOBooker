package com.sap.ibso.hackathon.booker.function;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.sap.ibso.hackathon.booker.jpa.model.Seat;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Validated
public class PostSeats extends PostBookerEntities<Seat> {

    @FunctionName("postSeats")
    public HttpResponseMessage postSeats(
            @HttpTrigger(name = "request", methods = {HttpMethod.POST}, route = "seats",
                    authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<List<Seat>>> request,
            ExecutionContext context) {

        return postEntities(request, context);
    }
}
