package com.jpa.entitygraph.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jpa.entitygraph.entity.Author;
import com.jpa.entitygraph.entity.Book;
import com.jpa.entitygraph.repository.AuthorRepository;

@Configuration
public class DatabaseInitializerConfig {
	
	@Bean
    CommandLineRunner initDatabase(AuthorRepository authorRepository) {
		return args->{
			Author author = new Author("James");
			//author = authorRepository.save(author);
			
			List<Book> books = new ArrayList<>();
			books.add(new Book("eBook",author));
			books.add(new Book("google",author));
			books.add(new Book("Apach eBook",author));
			author.setBooks(books);
			authorRepository.saveAndFlush(author);
			
		};
	}

}
