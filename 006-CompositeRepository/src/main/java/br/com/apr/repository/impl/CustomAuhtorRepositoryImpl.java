package br.com.apr.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.apr.dto.AuthorSummaryDTO;
import br.com.apr.model.Author;
import br.com.apr.model.Author_;
import br.com.apr.repository.CustomAuthorRepository;

public class CustomAuhtorRepositoryImpl implements CustomAuthorRepository{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<AuthorSummaryDTO> getAuthorsByFirstName(String firstName) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<AuthorSummaryDTO> query = cb.createQuery(AuthorSummaryDTO.class);
		
		Root<Author> root = query.from(Author.class);
		
		query.select(cb.construct(AuthorSummaryDTO.class, root.get(Author_.firstName), root.get(Author_.lastName)))
			.where(cb.equal(root.get(Author_.firstName), firstName));
		
		List<AuthorSummaryDTO> list = entityManager.createQuery(query).getResultList();
		
		return list;
	}

}
