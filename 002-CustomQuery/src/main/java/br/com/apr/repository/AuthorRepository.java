package br.com.apr.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.apr.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

	//@Query("FROM #{#entityName} WHERE firstName = ?1")
	@Query("FROM Author WHERE firstName = ?1")
    List<Author> findByFirstName(String firstName);
 
    @Query("SELECT a FROM Author a WHERE firstName = :firstName AND lastName = :lastName")
    List<Author> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
    
    @Query("FROM Author WHERE firstName = ?1 ORDER BY lastName ASC")
    List<Author> findByFirstNameOrderByLastname(String firstName);
    
    @Query("FROM Author WHERE firstName = ?1")
    List<Author> findByFirstName(String firstName, Sort sort);
    
    @Query("FROM Author WHERE firstName = ?1")
    List<Author> findByFirstName(String firstName, Pageable pageable);
 	
    //@Query("FROM Author WHERE UPPER(firstName) LIKE CONCAT('%', UPPER(?1), '%')")
    @Query("FROM Author WHERE UPPER(firstName) LIKE %?#{[0].toUpperCase()}%")
    List<Author> findByFirstNameContainingIgnoreCase(String firstName);
    
    @Query(value = "SELECT * FROM author WHERE first_name = :firstName", nativeQuery = true)
    List<Author> findAuthorsByFirstName(@Param("firstName") String firstName);
    
    @Query("UPDATE Author SET firstName = :prefix || firstName")
    @Modifying
    void addPrefixToFirstName(@Param("prefix") String prefix);
}
