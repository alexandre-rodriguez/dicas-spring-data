package br.com.apr.projections.repo;

import org.springframework.beans.factory.annotation.Value;

public interface BookSummary {
 
    @Value("#{target.title + '-' + target.author.firstName}")
    String getBookNameAndAuthorName();
}