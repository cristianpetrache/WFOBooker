package com.sap.ibso.hackathon.booker.function;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.sap.ibso.hackathon.booker.jpa.model.Floor;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Validated
public class DeleteFloors extends DeleteBookerEntities<Floor> {

    @FunctionName("deleteFloors")
    public HttpResponseMessage deleteFloors(
            @HttpTrigger(name = "request", methods = {HttpMethod.DELETE}, route = "floors",
                    authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<List<UUID>>> request,
            ExecutionContext context) {

        return deleteEntities(request, context);
    }
}
