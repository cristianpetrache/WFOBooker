package com.sap.ibso.hackathon.booker;

import com.sap.ibso.hackathon.booker.model.Greeting;
import com.sap.ibso.hackathon.booker.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class WfoBookerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WfoBookerApplication.class, args);
	}

	@Bean
	public Function<User, Greeting> hello() {
		return user -> new Greeting("Welcome, " + user.getName());
	}

}
