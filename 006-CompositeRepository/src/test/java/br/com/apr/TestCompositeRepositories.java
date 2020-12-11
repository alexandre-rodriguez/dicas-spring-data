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

import br.com.apr.dto.AuthorBookSummaryDTO;
import br.com.apr.dto.AuthorSummaryDTO;
import br.com.apr.model.Book;
import br.com.apr.repository.AuthorRepository;
import br.com.apr.repository.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestCompositeRepositories {

    private static Logger log = LoggerFactory.getLogger(TestCompositeRepositories.class);
    
    @Autowired
    private AuthorRepository authorRepository;
    
    @Autowired
    private BookRepository bookRepository;
 
    @Test
    @Transactional
    public void testGetAuthorsByFirstName() {
        List<AuthorSummaryDTO> a = authorRepository.getAuthorsByFirstName("Thorben");
        Assert.assertNotNull(a);
        Assert.assertFalse(a.isEmpty());
        log.info("getAuthorsByFirstName result: " + a.get(0).toString());
    }
    
    @Test
    @Transactional
    public void testFindBookByAuthorId() {
        List<AuthorBookSummaryDTO> a = bookRepository.findBookByAuthorId(1L);
        Assert.assertNotNull(a);
        Assert.assertFalse(a.isEmpty());
        log.info("findBookByAuthorId result: " + a.get(0).toString());
    }
    
    @Test
    @Transactional
    public void tesFindAll() {
        List<Book> b = bookRepository.findAll();
        Assert.assertNotNull(b);
        Assert.assertFalse(b.isEmpty());
        log.info("findAll result: " + b.get(0).toString());
    }
        

}
