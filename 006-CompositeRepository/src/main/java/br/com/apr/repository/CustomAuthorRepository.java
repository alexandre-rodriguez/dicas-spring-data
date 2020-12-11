package br.com.apr.repository;

import java.util.List;

import br.com.apr.dto.AuthorSummaryDTO;

public interface CustomAuthorRepository {
	
	public List<AuthorSummaryDTO> getAuthorsByFirstName(String firstName);

}
