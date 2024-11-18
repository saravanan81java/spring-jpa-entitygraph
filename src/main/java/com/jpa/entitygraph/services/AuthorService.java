package com.jpa.entitygraph.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.entitygraph.entity.Author;
import com.jpa.entitygraph.repository.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	AuthorRepository authorRepository;
	
	public Author getAuthorWithBooks(String name) {
		return authorRepository.findByNameWithBook(name).
				orElseThrow(()-> new RuntimeException("Author not found!"));
	}

	public List<Author> getAllAuthors() {
		List<Author> authors = authorRepository.findAll();
		for (Author author : authors) {
		    System.out.println(author.getBooks().size());  // Triggers N+1 queries
		}
		
		return authors;
	}

}
