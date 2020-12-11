package br.com.apr.dto;
public class AuthorSummaryDTO {
     
    private String firstName;
    private String lastName;
     
    public AuthorSummaryDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
     
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	@Override
	public String toString() {
		return "AuthorSummaryDTO [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
    
    
}