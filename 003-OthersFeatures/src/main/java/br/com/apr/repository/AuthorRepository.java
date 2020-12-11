package br.com.apr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apr.model.Author;
import br.com.apr.model.AuthorValueInf;

public interface AuthorRepository extends JpaRepository<Author, Long>{

    List<AuthorValueInf> findByFirstName(String firstName);
 
}
