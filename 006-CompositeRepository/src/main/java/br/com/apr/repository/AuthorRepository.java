package br.com.apr.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.apr.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>, CustomAuthorRepository{

}
