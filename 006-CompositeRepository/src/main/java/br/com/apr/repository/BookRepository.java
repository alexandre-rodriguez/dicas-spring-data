package br.com.apr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apr.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>, CustomBookRepository, FindAllRepository {

}
