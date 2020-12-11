package br.com.apr.model;

public interface AuthorValueInf {
	
	String getFirstName();
	void setFirstName(String firstName);
	
	String getLastName();
	void setLastName(String lastName);
	
	public default String toStringValue() {
		return "FirstName: " + getFirstName() + " LastName: " + getLastName(); 
	}

}
