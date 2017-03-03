package es.salesianos.edu.model;

import java.io.Serializable;
import java.sql.Date;

public class Author implements Serializable {

	private String nameAuthor;
	private Date dateOfBirth;
	private int idAuthor;

	public int getIdAuthor() {
		return idAuthor;
	}
	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNameAuthor() {
		return nameAuthor;
	}

	public void setNameAuthor(String nameAuthor) {
		this.nameAuthor = nameAuthor;
	}

}
