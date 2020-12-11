package br.com.apr.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.apr.dto.AuthorBookSummaryDTO;
import br.com.apr.model.Book;
import br.com.apr.repository.CustomBookRepository;

public class CustomBookRepositoryImpl implements CustomBookRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomBookRepositoryImpl.class);
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<AuthorBookSummaryDTO> findBookByAuthorId(Long authorId) {
		TypedQuery<AuthorBookSummaryDTO> query = entityManager.createQuery(
				"SELECT new br.com.apr.dto.AuthorBookSummaryDTO(b.title, a.firstName, a.lastName) " 
				+ "FROM Book b JOIN b.author a WHERE a.id = :id", AuthorBookSummaryDTO.class)
				.setParameter("id", authorId);
		
		return query.getResultList();
	}
	
	@Override
	public List<Book> findAll() {
		logger.info("CustomBookRepository.findAll() method");
		return entityManager.createQuery("SELECT b from Book b", Book.class).getResultList();
	}
}
