package com.latamairline.flightSearchApp;

import com.latamairline.flightSearchApp.latam.LatamRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightSearchAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightSearchAppApplication.class, args);

		LatamRequest latamRequest = new LatamRequest();
		latamRequest.consumerAPILatam();
	}

}
