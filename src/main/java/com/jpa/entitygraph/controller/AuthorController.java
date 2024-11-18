package com.jpa.entitygraph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.entitygraph.entity.Author;
import com.jpa.entitygraph.services.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/{name}")
    public ResponseEntity<Author> getAuthorWithBooks(@PathVariable String name) {
        Author author = authorService.getAuthorWithBooks(name);
        return ResponseEntity.ok(author);
    }
    
    
    @GetMapping("/list")
    public List<Author> listOfAuthors(){
		return authorService.getAllAuthors();
    	
    }
    

}
