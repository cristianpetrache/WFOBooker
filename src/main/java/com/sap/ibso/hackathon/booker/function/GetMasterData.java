package com.sap.ibso.hackathon.booker.function;

import java.util.Optional;

import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;
import org.springframework.validation.annotation.Validated;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.sap.ibso.hackathon.booker.dto.MasterDataDto;
import com.sap.ibso.hackathon.booker.jpa.model.PageRequest;
import com.sap.ibso.hackathon.booker.service.ExecutionContextHolderService;

@Validated
public class GetMasterData extends AzureSpringBootRequestHandler<PageRequest, MasterDataDto> {

	@FunctionName("getMasterData")
	public HttpResponseMessage getMasterData(@HttpTrigger(name = "request", methods = {
			HttpMethod.GET }, route = "masterData", authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<PageRequest>> request,
			ExecutionContext context) {

		ExecutionContextHolderService.getInstance().setExecutionContext(context);

		context.getLogger().info(this.getClass().getName());

		PageRequest pageRequest = request.getBody().orElse(PageRequest.getFirst1K());
		MasterDataDto masterDataDto = handleRequest(pageRequest, context);

		return request.createResponseBuilder(HttpStatus.OK).body(masterDataDto)
				.header("Content-Type", "application/json").build();
	}
}
