package es.salesianos.edu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import es.salesianos.edu.model.*;

@Service
public class SimulacroService {

	private static final Logger logger = LogManager.getLogger(SimulacroService.class.getName());

	public boolean insertAuthor(Author author) {
		logger.debug("simulando insercion");
		return true;
	}

	public List searchAllAuthor(Author author) {
		List list = new ArrayList();
		if (author.getNameAuthor() != null) {
			Author author1 = new Author();
			author1.setNameAuthor("Bat");
			author1.setDateOfBirth(new Date());
			Author author2 = new Author();
			author2.setNameAuthor("Bi");
			author2.setDateOfBirth(new Date());
			Author author3 = new Author();
			author3.setNameAuthor("Iru");
			author3.setDateOfBirth(new Date());
			list.add(author1);
			list.add(author2);
			list.add(author3);
		}

		return list;
	}
	
	public boolean insertBook(Book book) {
		logger.debug("simulando insercion");
		return true;
	}

	public List searchAllBook(Book book) {
		List list = new ArrayList();
		if (book.getNameBook() != null) {
			Book book1 = new Book();
			book1.setNameBook("El primero");
			book1.setISBN(1);
			book1.setAuthor("El primer autor");
			Book book2 = new Book();
			book2.setNameBook("El segundo");
			book2.setISBN(2);
			book2.setAuthor("El segundo autor");
			Book book3 = new Book();
			book3.setNameBook("El tercero");
			book3.setISBN(3);
			book3.setAuthor("El tercer autor");

			list.add(book1);
			list.add(book2);
			list.add(book3);
		}

		return list;
	}

}
