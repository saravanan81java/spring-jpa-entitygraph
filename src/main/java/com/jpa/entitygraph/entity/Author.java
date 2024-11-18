package com.jpa.entitygraph.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Fetch;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Author {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN) 
    private List<Book> books = new ArrayList<>();
    
    public Author() {
	}
    
    public Author(String name){
    	this.name = name;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
    
    
    

}
