package com.giantlink.grh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.giantlink.grh.entities.Company;
import com.giantlink.grh.services.CompanyService;

@SpringBootApplication
public class EmployeeManagementApplication implements CommandLineRunner {

	@Autowired
	CompanyService companyService;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello employee management");
//		Company build2 = Company.builder().name("GIANTLINK").email("contact@giantlink.fr").address("FRANCE").build();
//		Company build = Company.builder().name("GIANTLINK").email("contact@giantlink.fr").address("FRANCE").build();
//		companyService.add(build);
//		companyService.add(build2);

	}

}
