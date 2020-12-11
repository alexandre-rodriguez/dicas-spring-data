package br.com.apr.repository;

import java.util.List;

import br.com.apr.dto.AuthorBookSummaryDTO;
import br.com.apr.model.Book;

public interface CustomBookRepository {
	
	public List<AuthorBookSummaryDTO> findBookByAuthorId(Long authorId);
	
	public List<Book> findAll();

}
