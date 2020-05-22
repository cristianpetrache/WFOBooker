package com.sap.ibso.hackathon.booker.function;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.sap.ibso.hackathon.booker.jpa.model.Location;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Validated
public class PostLocations extends PostBookerEntities<Location> {

    @FunctionName("postLocations")
    public HttpResponseMessage postLocations(
            @HttpTrigger(name = "request", methods = {HttpMethod.POST}, route = "locations",
                    authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<List<Location>>> request,
            ExecutionContext context) {

        return postEntities(request, context);
    }
}
