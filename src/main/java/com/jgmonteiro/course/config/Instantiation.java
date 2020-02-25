package com.jgmonteiro.course.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jgmonteiro.course.domain.Post;
import com.jgmonteiro.course.domain.User;
import com.jgmonteiro.course.dto.AuthorDTO;
import com.jgmonteiro.course.repository.PostRepository;
import com.jgmonteiro.course.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User viuva = new User(null, "Viuva Negra", "viuvan@gmail.com");
		User thor = new User(null, "Thor", "thor@gmail.com");
		User invernal = new User(null, "Soldado Invernal", "soldadoin@gmail.com");
		
		userRepository.saveAll(Arrays.asList(viuva,thor,invernal));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(thor));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(thor));
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
	}

}
