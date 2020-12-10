package br.com.apr.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apr.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

	Book findByTitle(String title);

	List<Book> findByTitleContainsOrderByTitleAsc(String string);
	
	List<Book> findByTitleContains(String title, Sort sort);
	
	List<Book> findFirst5ByTitleOrderByTitleAsc(String title);
	
	Page<Book> findAll(Pageable pageable);
}
