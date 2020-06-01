package com.sap.ibso.hackathon.booker.function;

import java.util.List;
import java.util.Optional;

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
public class PostPreferences extends PostBookerEntities<Preference> {

	@FunctionName("postPreferences")
	public HttpResponseMessage postPreferences(@HttpTrigger(name = "request", methods = {
			HttpMethod.POST }, route = "preferences", authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<List<Preference>>> request,
			ExecutionContext context) {

		return postEntities(request, context);
	}
}
