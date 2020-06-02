package com.sap.ibso.hackathon.booker.service;

import com.microsoft.azure.functions.ExecutionContext;

public class ExecutionContextHolderService {

    private static final ExecutionContextHolderService INSTANCE = new ExecutionContextHolderService();

    private ExecutionContextHolderService() {
    }

    private ThreadLocal<ExecutionContext> executionContextThreadLocal = new ThreadLocal<>();

    public ExecutionContext getExecutionContext() {
        return executionContextThreadLocal.get();
    }

    public void setExecutionContext(ExecutionContext executionContext) {
        executionContextThreadLocal.set(executionContext);
    }

    public static ExecutionContextHolderService getInstance() {
        return INSTANCE;
    }
}
