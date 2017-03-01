package es.salesianos.edu.connection;

import java.util.ArrayList;
import java.util.List;

import es.salesianos.edu.model.Author;
import es.salesianos.edu.model.Book;

public class DataBase {
	ArrayList<Author> listAuthor = new ArrayList();
	ArrayList<Book> listBook = new ArrayList();

	public ArrayList<Author> getListAuthor() {
		return listAuthor;
	}

	public void setListAuthor(ArrayList<Author> listAuthor) {
		this.listAuthor = listAuthor;
	}

	public ArrayList<Book> getListBook() {
		return listBook;
	}

	public void setListBook(ArrayList<Book> listBook) {
		this.listBook = listBook;
	}
}
