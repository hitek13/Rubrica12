package es.salesianos.edu.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.salesianos.edu.connection.DataBase;
import es.salesianos.edu.model.*;
import es.salesianos.edu.webpages.Author.*;

public class BookRepository {
	DataBase db = new DataBase();
	
	public void addAuthor(Book book){
		db.getListBook().add(book);
	}
	public List listAuthor(){
		 return db.getListBook();
	}
}
