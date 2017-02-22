package es.salesianos.edu.model;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
	
	private String nameBook;
	private int ISBN;
	private String author;
	
	public String getNameBook() {
		return nameBook;
	}
	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
