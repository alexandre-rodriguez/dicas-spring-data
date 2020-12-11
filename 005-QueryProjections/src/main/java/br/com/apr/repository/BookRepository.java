package br.com.apr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.apr.model.Book;
import br.com.apr.projections.repo.BookSummary;

public interface BookRepository extends JpaRepository<Book, Long>{


	BookSummary findByTitle(String title);
	

	Object[] getByTitle(String title);
	
	@Query("SELECT b.id, b.title FROM Book b")
	List<Object[]> getIdAndTitle();
	
}
