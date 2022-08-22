package com.giantlink.grh;

import com.giantlink.grh.entities.ERole;
import com.giantlink.grh.entities.Role;
import com.giantlink.grh.repositories.CompanyRepository;
import com.giantlink.grh.repositories.RoleRepository;
import com.giantlink.grh.services.CompanyImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.transaction.Transactional;


import com.giantlink.grh.services.CompanyService;


@SpringBootApplication
public class EmployeeManagementApplication implements CommandLineRunner {

	@Autowired
	CompanyService companyService;

	@Autowired
	CompanyImageService companyImageService;

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	RoleRepository roleRepository;



	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello employee management");
		companyImageService.initPath();

//		Company build2 = Company.builder().name("GIANTLINK").email("contact@giantlink.fr").address("FRANCE").build();
//		Company build = Company.builder().name("GIANTLINK").email("contact@giantlink.fr").address("FRANCE").build();
//		companyService.add(build);
//		companyService.add(build2);


		// roles

/*		roleRepository.deleteAll();

		roleRepository.save(new Role(ERole.ROLE_ADMIN));
		roleRepository.save(new Role(ERole.ROLE_USER));
		roleRepository.save(new Role(ERole.ROLE_MODERATOR));*/


	}

}
