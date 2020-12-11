package br.com.apr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.apr.model.Author;
import br.com.apr.projections.dto.AuthorSummaryDTO;
import br.com.apr.projections.repo.AuthorView;

public interface AuthorRepository extends JpaRepository<Author, Long>{

	// A linha abaixo não é necessária se o AuthorSummaryDTO tiver apenas um construtor e os nomes do atributos forem iguais a da entidade
	@Query("SELECT new br.com.apr.projections.dto.AuthorSummaryDTO(a.firstName, a.lastName) FROM Author a WHERE a.firstName = :firstName")
    List<AuthorSummaryDTO> findByFirstName(String firstName);
	
	AuthorView findViewByFirstName(String firstName);
	
	@Query("select a from Author a left join fetch a.books")
    List<Author> getAuthorsAndBook();
	
	<T> T findByLastName(String lastName, Class<T> type); 

}
