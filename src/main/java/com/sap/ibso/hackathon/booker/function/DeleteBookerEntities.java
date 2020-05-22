package com.sap.ibso.hackathon.booker.function;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.sap.ibso.hackathon.booker.jpa.model.UUIDEntity;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class DeleteBookerEntities<T extends UUIDEntity> extends AzureSpringBootRequestHandler<List<UUID>,
        List<T>> {

    public HttpResponseMessage deleteEntities(HttpRequestMessage<Optional<List<UUID>>> request,
                                              ExecutionContext context) {

        List<UUID> emptyList = Collections.emptyList();
        context.getLogger()
               .info("delete " + getClass().getSimpleName() + " entities: " + request.getBody().orElse(emptyList));
        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(handleRequest(request.getBody().orElse(emptyList), context))
                .header("Content-Type", "application/json")
                .build();
    }
}
