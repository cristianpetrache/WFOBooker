package com.sap.ibso.hackathon.booker.function;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.sap.ibso.hackathon.booker.jpa.model.Location;
import com.sap.ibso.hackathon.booker.jpa.model.PageRequest;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;
import org.springframework.data.domain.Page;

import java.util.Optional;

public class GetLocations extends AzureSpringBootRequestHandler<PageRequest, Page<Location>> {

    @FunctionName("getLocations")
    public HttpResponseMessage getLocations(
            @HttpTrigger(name = "request", methods = {HttpMethod.GET}, route = "locations",
                    authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<PageRequest>> request,
            ExecutionContext context) {

        PageRequest pageRequest = request.getBody().orElse(PageRequest.getFirst1K());
        context.getLogger().info("get locations: " + pageRequest);
        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(handleRequest(pageRequest, context))
                .header("Content-Type", "application/json")
                .build();
    }
}
