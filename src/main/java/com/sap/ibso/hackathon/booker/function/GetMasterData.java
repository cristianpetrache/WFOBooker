package com.sap.ibso.hackathon.booker.function;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.sap.ibso.hackathon.booker.dto.MasterDataDto;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Validated
public class GetMasterData extends AzureSpringBootRequestHandler<Optional<?>, MasterDataDto> {

    @FunctionName("getMasterData")
    public HttpResponseMessage getMasterData(
            @HttpTrigger(name = "request", methods = {HttpMethod.GET}, route = "masterData",
                    authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Void> request,
            ExecutionContext context) {

        context.getLogger().info("get " + getClass().getSimpleName() + " entities");
        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(handleRequest(Optional.empty(), context))
                .header("Content-Type", "application/json")
                .build();
    }
}
