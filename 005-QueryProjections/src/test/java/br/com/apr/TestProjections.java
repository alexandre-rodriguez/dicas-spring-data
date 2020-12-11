package br.com.apr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.apr.model.Author;
import br.com.apr.projections.dto.AuthorSummaryDTO;
import br.com.apr.projections.repo.AuthorView;
import br.com.apr.projections.repo.BookSummary;
import br.com.apr.repository.AuthorRepository;
import br.com.apr.repository.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestProjections {

    private static Logger log = LoggerFactory.getLogger(TestProjections.class);
    
    @Autowired
    private AuthorRepository authorRepository;
    
    @Autowired
    private BookRepository bookRepository;
 
    @Test
    @Transactional
    public void testGetBookIdAndTitle_wheUsingScalarProjection() {

        List<Object[]> books = bookRepository.getIdAndTitle();
        assertNotNull(books);
        books.stream().forEach(b -> log.info("Books: id {}, title {}", b[0], b[1]));
    }
    
    @Test
    @Transactional
    public void testGetAuhtorDetails_wheUsingDtoClassBasedProjection() {

        List<AuthorSummaryDTO> dtos = authorRepository.findByFirstName("Thorben");
        assertNotNull(dtos);
        assertEquals("Thorben", dtos.get(0).getFirstName());
    }
    
    @Test
    @Transactional
    public void testFindByFirstName_wheUsingClosedProjections() {

        AuthorView authorView = authorRepository.findViewByFirstName("Thorben");
        assertNotNull(authorView);
        assertEquals("Janssen", authorView.getLastName());
        assertEquals("Hibernate Tips", authorView.getBooks().get(0).getTitle());
    }
    
    @Test
    @Transactional
    public void testGetBookAndAuthorName_wheUsingOpenProjection() {
    	BookSummary bookSummary = bookRepository.findByTitle("Hibernate Tips");
    	assertNotNull(bookSummary);
    	log.info("Book Summary view >>>> {}", bookSummary.getBookNameAndAuthorName());
    	
    	String expected = "Hibernate Tips-Thorben";
        assertEquals(expected, bookSummary.getBookNameAndAuthorName());
    }
    
    @Test
    @Transactional
    public void testFindAll_wheUsingEntitiyProjection() {
    	List<Author> authors = (List<Author>) authorRepository.findAll();
    	assertNotNull(authors);
    	assertEquals(2, authors.size());
    }
    
    @Test
    @Transactional
    public void testGetAuthorsAndBook_wheUsingEntities() {
    	List<Author> authors = authorRepository.getAuthorsAndBook();
    	assertNotNull(authors);
    	assertEquals("Hibernate Tips", authors.get(0).getBooks().get(0).getTitle());
    }
    
    @Test
    @Transactional
    public void testGetAuthorSummary() {
    	AuthorSummaryDTO authorSummaryDTO = authorRepository.findByLastName("Janssen", AuthorSummaryDTO.class);
    	assertNotNull(authorSummaryDTO);
    	assertEquals("Thorben", authorSummaryDTO.getFirstName());
    }
    
}
