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
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Validated
public class DeleteLocations extends AzureSpringBootRequestHandler<List<UUID>, List<Location>> {

    @FunctionName("deleteLocations")
    public HttpResponseMessage deleteLocations(
            @HttpTrigger(name = "request", methods = {HttpMethod.DELETE}, route = "locations",
                    authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<List<UUID>>> request,
            ExecutionContext context) {

        List<UUID> emptyList = Collections.emptyList();
        context.getLogger().info("delete locations: " + request.getBody().orElse(emptyList));
        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(handleRequest(request.getBody().orElse(emptyList), context))
                .header("Content-Type", "application/json")
                .build();
    }
}
