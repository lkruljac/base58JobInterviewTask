package com.example.demo;

import com.example.demo.Services.BackgroundScheduledJob;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Base58Application {
	public static void main(String[] args) {
		//run all SPRING services related to DB and API
		SpringApplication.run(Base58Application.class, args);
		//initializing  scheduled task to fetch data from source API
		BackgroundScheduledJob.Start();
	}

}
