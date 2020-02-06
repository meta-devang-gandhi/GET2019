package com.metacube.SpringMVCStudentDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
public class SpringMvcStudentDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcStudentDetailsApplication.class, args);
	}

}
