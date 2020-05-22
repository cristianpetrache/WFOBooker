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

public class PostBookerEntities<T extends UUIDEntity> extends AzureSpringBootRequestHandler<List<T>, List<T>> {

    public HttpResponseMessage postEntities(HttpRequestMessage<Optional<List<T>>> request,
                                            ExecutionContext context) {

        List<T> emptyList = Collections.emptyList();
        context.getLogger()
               .info("post " + getClass().getSimpleName() + " entities: " + request.getBody().orElse(emptyList));
        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(handleRequest(request.getBody().orElse(emptyList), context))
                .header("Content-Type", "application/json")
                .build();
    }
}
