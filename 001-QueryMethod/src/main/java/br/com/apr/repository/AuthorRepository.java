package br.com.apr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apr.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

	List<Author> findByFirstName(String firstName);
	
	List<Author> findByFirstNameAndLastName(String firstName, String lastName);
	
	List<Author> findByFirstNameContainingIgnoreCase(String firstName);
	
	List<Author> findByBooksTitle(String title);
	
}
