package com.sap.ibso.hackathon.booker.function;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.sap.ibso.hackathon.booker.jpa.model.Building;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Validated
public class PostBuildings extends AzureSpringBootRequestHandler<List<Building>, List<Building>> {

    @FunctionName("postBuildings")
    public HttpResponseMessage postBuildings(
            @HttpTrigger(name = "request", methods = {HttpMethod.POST}, route = "buildings",
                    authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<List<Building>>> request,
            ExecutionContext context) {

        List<Building> emptyList = Collections.emptyList();
        context.getLogger().info("post buildings: " + request.getBody().orElse(emptyList));
        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(handleRequest(request.getBody().orElse(emptyList), context))
                .header("Content-Type", "application/json")
                .build();
    }
}
