package com.sap.ibso.hackathon.booker.function;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.validation.annotation.Validated;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.sap.ibso.hackathon.booker.jpa.model.Preference;

@Validated
public class DeletePreferences extends DeleteBookerEntities<Preference> {

	@FunctionName("deletePreferences")
	public HttpResponseMessage deletePreferences(@HttpTrigger(name = "request", methods = {
			HttpMethod.DELETE }, route = "preferences", authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<List<UUID>>> request,
			ExecutionContext context) {

		return deleteEntities(request, context);
	}
}
