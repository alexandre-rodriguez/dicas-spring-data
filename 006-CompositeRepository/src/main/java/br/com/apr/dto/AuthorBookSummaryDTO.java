package br.com.apr.dto;

public class AuthorBookSummaryDTO {
	
	private String title;
	private String firstName; 
	private String lastName;
	
	public AuthorBookSummaryDTO(String title, String firstName, String lastName) {
		super();
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "AuthorBookSummaryDTO [title=" + title + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
