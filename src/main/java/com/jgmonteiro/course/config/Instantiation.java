package com.jgmonteiro.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jgmonteiro.course.domain.User;
import com.jgmonteiro.course.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User viuva = new User(null, "Viuva Negra", "viuvan@gmail.com");
		User thor = new User(null, "Thor", "thor@gmail.com");
		User invernal = new User(null, "Soldado Invernal", "soldadoin@gmail.com");
		
		userRepository.saveAll(Arrays.asList(viuva,thor,invernal));
		
	}

}
