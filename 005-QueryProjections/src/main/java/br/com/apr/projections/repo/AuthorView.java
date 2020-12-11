package br.com.apr.projections.repo;

import java.util.List;

public interface AuthorView {
    String getFirstName();
    String getLastName();
    
    List<BookView> getBooks();
    
    interface BookView {   
        String getTitle();
    }
}