package com.dreamquest.transportapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication(exclude = {
//	    DataSourceAutoConfiguration.class, 
//	    DataSourceTransactionManagerAutoConfiguration.class, 
//	    HibernateJpaAutoConfiguration.class
//	})
@SpringBootApplication
public class TransportApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransportApiApplication.class, args);
	}

}
