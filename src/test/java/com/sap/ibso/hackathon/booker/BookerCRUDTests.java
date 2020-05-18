package com.sap.ibso.hackathon.booker;

import com.sap.ibso.hackathon.booker.model.Greeting;
import com.sap.ibso.hackathon.booker.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;

import static org.assertj.core.api.Assertions.assertThat;

public class BookerCRUDTests {

    private static final String JANE_DOE = "Jane Doe";
    private static final String WELCOME = "Welcome, ";

    @Test
    public void test() {
        Greeting result = new WfoBookerApplication().hello().apply(new User(JANE_DOE));
        assertThat(result.getMessage()).isEqualTo(WELCOME + JANE_DOE);
    }

    @Test
    public void start() throws Exception {
        AzureSpringBootRequestHandler<User, Greeting> handler = new AzureSpringBootRequestHandler<>(
                WfoBookerApplication.class);
        Greeting result = handler.handleRequest(new User(JANE_DOE), null);
        handler.close();
        assertThat(result.getMessage()).isEqualTo(WELCOME + JANE_DOE);
    }
}
