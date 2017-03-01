package es.salesianos.edu.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.salesianos.edu.connection.DataBase;
import es.salesianos.edu.model.*;
import es.salesianos.edu.webpages.Author.*;

public class AuthorRepository {
	DataBase db = new DataBase();
	
	public void addAuthor(Author author){
		db.getListAuthor().add(author);
	}
	public List listAuthor(){
		 return db.getListAuthor();
	}
	public void deleteAuthor(){
		
	}
}
