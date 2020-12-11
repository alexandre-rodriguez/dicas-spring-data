package br.com.apr;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.apr.model.Author;
import br.com.apr.repository.AuthorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestNamedQueries {

    private static Logger log = LoggerFactory.getLogger(TestNamedQueries.class);
    
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
        
}
