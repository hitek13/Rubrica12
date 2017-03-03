package es.salesianos.edu.model;

import org.apache.wicket.proxy.LazyInitProxyFactory.SerializableNoOpCallback;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;

@Component
public class Book extends SerializableSerializer {

	private String nameBook;
	private String ISBN;
	private String nameAuthor;

	public String getNameAuthor() {
		return nameAuthor;
	}

	public void setNameAuthor(String nameAuthor) {
		this.nameAuthor = nameAuthor;
	}

	public String getNameBook() {
		return nameBook;
	}

	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
}
