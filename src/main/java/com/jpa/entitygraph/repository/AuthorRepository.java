package com.jpa.entitygraph.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jpa.entitygraph.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

	@EntityGraph(attributePaths =  "books")
	@Query("SELECT a FROM Author a WHERE a.name = :name")
	Optional<Author> findByNameWithBook(@Param("name") String name);
	
}
