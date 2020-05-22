package com.sap.ibso.hackathon.booker.function;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.sap.ibso.hackathon.booker.jpa.model.PageRequest;
import com.sap.ibso.hackathon.booker.jpa.model.UUIDEntity;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;
import org.springframework.data.domain.Page;

import java.util.Optional;

public abstract class GetBookerEntities<T extends UUIDEntity> extends AzureSpringBootRequestHandler<PageRequest,
        Page<T>> {

    public HttpResponseMessage getEntities(
            HttpRequestMessage<Optional<PageRequest>> request,
            ExecutionContext context) {

        PageRequest pageRequest = request.getBody().orElse(PageRequest.getFirst1K());
        context.getLogger().info("get " + getClass().getSimpleName() + " entities: " + pageRequest);
        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(handleRequest(pageRequest, context))
                .header("Content-Type", "application/json")
                .build();
    }
}
