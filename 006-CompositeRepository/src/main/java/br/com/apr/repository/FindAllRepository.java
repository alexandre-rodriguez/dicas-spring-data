package br.com.apr.repository;

import java.util.List;

import br.com.apr.model.Book;

public interface FindAllRepository {

	public List<Book> findAll();
	
}
