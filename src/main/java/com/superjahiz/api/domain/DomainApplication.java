package com.superjahiz.api.domain;

import com.superjahiz.api.domain.entities.Role;
import com.superjahiz.api.domain.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DomainApplication {
	@Autowired
	private RoleRepository roleRepository;
	@PostConstruct
	public void initRoles() {
		try{
			roleRepository.save(new Role(null,"ADMIN"));
			roleRepository.save(new Role(null,"USER"));
		} catch (Exception e) {
			System.out.println("Roles already exist");
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(DomainApplication.class, args);
	}

}
