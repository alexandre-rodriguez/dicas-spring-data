package br.com.apr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Book {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    @Version
    private int version;
    
	private String title;
	 
    @ManyToOne
    private Author author;
 
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthors(Author author) {
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public int getVersion() {
		return version;
	}
}