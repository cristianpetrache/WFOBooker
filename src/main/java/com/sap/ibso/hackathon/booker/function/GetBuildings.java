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
import com.sap.ibso.hackathon.booker.jpa.model.PageRequest;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;
import org.springframework.data.domain.Page;

import java.util.Optional;

public class GetBuildings extends AzureSpringBootRequestHandler<PageRequest, Page<Building>> {

    @FunctionName("getBuildings")
    public HttpResponseMessage getBuildings(
            @HttpTrigger(name = "request", methods = {HttpMethod.GET}, route = "buildings",
                    authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<PageRequest>> request,
            ExecutionContext context) {

        PageRequest pageRequest = request.getBody().orElse(PageRequest.getFirst1K());
        context.getLogger().info("get buildings: " + pageRequest);
        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(handleRequest(pageRequest, context))
                .header("Content-Type", "application/json")
                .build();
    }
}
