package com.sap.ibso.hackathon.booker.function;

import java.util.Optional;

import org.springframework.validation.annotation.Validated;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.sap.ibso.hackathon.booker.jpa.model.PageRequest;
import com.sap.ibso.hackathon.booker.jpa.model.Preference;

@Validated
public class GetPreferences extends GetBookerEntities<Preference> {

	@FunctionName("getPreferences")
	public HttpResponseMessage getPreferences(@HttpTrigger(name = "request", methods = {
			HttpMethod.GET }, route = "preferences", authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<PageRequest>> request,
			ExecutionContext context) {

		return getEntities(request, context);
	}
}
