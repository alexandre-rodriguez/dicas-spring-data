package br.com.apr;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.apr.model.Author;
import br.com.apr.model.Book;
import br.com.apr.repository.AuthorRepository;
import br.com.apr.repository.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestQueryMethod {

    private static Logger log = LoggerFactory.getLogger(TestQueryMethod.class);
    
    @Autowired
    private AuthorRepository authorRepository;
    
    @Autowired
    private BookRepository bookRepository;
 
    @Test
    @Transactional
    public void testFindByFirstName() {
        log.info("... testFindByFirstName ...");
 
        List<Author> a = authorRepository.findByFirstName("Thorben");
        Assert.assertNotNull(a);
        Assert.assertFalse(a.isEmpty());
        log.info("findByFirstName result: " + a.get(0).toString());
    }
    
    @Test
    @Transactional
    public void testFindByFirstNameAndLastName() {
        log.info("... testFindByFirstNameAndLastName ...");
 
        List<Author> a = authorRepository.findByFirstNameAndLastName("Thorben", "Janssen");
        Assert.assertNotNull(a);
        Assert.assertFalse(a.isEmpty());
        log.info("findByFirstNameAndLastName result: " + a.get(0).toString());
    }
    
    @Test
    @Transactional
    public void testFindByFirstNameContainingIgnoreCase() {
        log.info("... testFindByFirstNameContainingIgnoreCase ...");
 
        List<Author> a = authorRepository.findByFirstNameContainingIgnoreCase("Thorben");
        Assert.assertNotNull(a);
        Assert.assertFalse(a.isEmpty());
        log.info("findByFirstNameContainingIgnoreCase result: " + a.get(0).toString());
    }
    
    @Test
    @Transactional
    public void testFindByBooksTitle() {
        log.info("... testFindByBooksTitle ...");
 
        List<Author> a = authorRepository.findByBooksTitle("Hibernate Tips");
        Assert.assertNotNull(a);
        Assert.assertFalse(a.isEmpty());
        log.info("findByBooksTitle result: " + a.get(0).toString());
    }
    
     
    @Test
    @Transactional
    public void testByTitle() {
        log.info("... testByTitle ...");
 
        Book b = bookRepository.findByTitle("Hibernate Tips");
        Assert.assertEquals(Long.valueOf(1L), b.getId());
    }
    
    @Test
    @Transactional
    public void testFindByTitleContainsOrderByTitleAsc() {
        log.info("... testFindByTitleContainsOrderByTitleAsc ...");
 
        List<Book> b = bookRepository.findByTitleContainsOrderByTitleAsc("Hibernate");
        Assert.assertNotNull(b);
        Assert.assertFalse(b.isEmpty());
        
        log.info("findByTitleContainsOrderByTitleAsc result elements: " + b.size());
    }
    
    @Test
    @Transactional
    public void testFindByTitleContains() {
        log.info("... testFindByTitleContains ...");
 
		Sort sort = Sort.by(Sort.Direction.ASC, "title");
		List<Book> b = bookRepository.findByTitleContains("Hibernate", sort);
        Assert.assertNotNull(b);
        Assert.assertFalse(b.isEmpty());
        
        log.info("findByTitleContains result elements: " + b.size());
    }
    
    @Test
    @Transactional
    public void testFindFirst5ByTitleOrderByTitleAsc() {
        log.info("... testFindFirst5ByTitleOrderByTitleAsc ...");
 
        List<Book> b = bookRepository.findFirst5ByTitleOrderByTitleAsc("Hibernate");
        Assert.assertNotNull(b);
        
        log.info("findFirst5ByTitleOrderByTitleAsc result elements: " + b.size());
    }
    
    @Test
    @Transactional
    public void testFindAllPaginated() {
        log.info("... testFindAllPaginated ...");
        
        Pageable pageable = PageRequest.of(0, 10); 
        Page<Book> b = bookRepository.findAll(pageable);
        Assert.assertNotNull(b);
        Assert.assertFalse(b.isEmpty());
        
        log.info("testFindAllPaginated result elements: " + b.getNumber());
    }
     
    @Test
    @Transactional
    public void testPersistBook() {
        log.info("... testPersistBook ...");
 
        Book b = new Book();
        b.setTitle("Hibernate Tips - More than 70 solutions to common Hibernate problems");
 
        bookRepository.save(b);
    }

}
