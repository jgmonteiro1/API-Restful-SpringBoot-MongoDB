package com.jgmonteiro.course.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgmonteiro.course.domain.Post;
import com.jgmonteiro.course.repository.PostRepository;
import com.jgmonteiro.course.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Postagem não encontrada")); 
	}
	
	public List<Post> findByTitle(String text){
		return repository.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		//Adicionando 1 dia a mais na data max
		maxDate = new Date(maxDate.getTime() + 24 * 60 *60*1000);
		return repository.fullSearch(text, minDate, maxDate);
	}
}
