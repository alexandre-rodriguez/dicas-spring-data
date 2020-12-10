package br.com.apr;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.apr.model.Author;
import br.com.apr.repository.AuthorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestQueryAnnotation {

    private static Logger log = LoggerFactory.getLogger(TestQueryAnnotation.class);
    
    @Autowired
    private AuthorRepository authorRepository;
 
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
    public void testFindByFirstNameOrderByLastname() {
        log.info("... testFindByFirstNameOrderByLastname ...");
 
        List<Author> a = authorRepository.findByFirstNameOrderByLastname("Thorben");
        Assert.assertNotNull(a);
        Assert.assertFalse(a.isEmpty());
        log.info("findByFirstNameAndLastName result: " + a.get(0).toString());
    }
    
    @Test
    @Transactional
    public void testQueryAnnotationSort() {
        log.info("... testQueryAnnotationSort ...");
 
		Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
		List<Author> a = authorRepository.findByFirstName("Thorben", sort);
        Assert.assertNotNull(a);
        Assert.assertFalse(a.isEmpty());
        
        log.info("findByFirstName result elements: " + a.get(0).toString());
    }
    
    @Test
    @Transactional
    public void testQueryAnnotationPagination() {
        log.info("... testQueryAnnotationPagination ...");
 
		Pageable pageable = PageRequest.of(0,  10);
		List<Author> a = authorRepository.findByFirstName("Thorben", pageable);
        Assert.assertNotNull(a);
        Assert.assertFalse(a.isEmpty());
        
        log.info("findByFirstName result elements: " + a.get(0).toString());
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
    public void testFindAuthorsByFirstName() {
        log.info("... testFindAuthorsByFirstName ...");
 
        List<Author> a = authorRepository.findAuthorsByFirstName("Thorben");
        Assert.assertNotNull(a);
        Assert.assertFalse(a.isEmpty());
        log.info("findAuthorsByFirstName result: " + a.get(0).toString());
    }
    
    
    @Test
    @Transactional
    public void testAddPrefixToFirstName() {
        log.info("... testAddPrefixToFirstName ...");
 
        authorRepository.addPrefixToFirstName("Prefix: ");
        
    }
    
}
