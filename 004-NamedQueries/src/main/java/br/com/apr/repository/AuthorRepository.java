package br.com.apr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.com.apr.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

    List<Author> findByFirstName(String firstName);
 
    List<Author> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
    
}
