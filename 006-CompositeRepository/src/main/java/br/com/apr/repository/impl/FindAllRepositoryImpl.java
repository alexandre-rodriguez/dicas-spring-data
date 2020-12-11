package br.com.apr.repository.impl;

import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.apr.model.Book;
import br.com.apr.repository.FindAllRepository;

public class FindAllRepositoryImpl implements FindAllRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(FindAllRepositoryImpl.class);

	@Override
	public List<Book> findAll() {
		logger.info("FindAllRepository.findAll() method");
		throw new NotYetImplementedException();
	}

}
