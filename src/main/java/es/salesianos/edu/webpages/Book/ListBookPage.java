package es.salesianos.edu.webpages.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.ws.Holder;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import es.salesianos.edu.model.Book;
import es.salesianos.edu.service.BookService;
import es.salesianos.edu.webpages.*;

public class ListBookPage extends WebPage {
	private static final long serialVersionUID = -1935854748907274886L;

	@SpringBean
	BookService bookService;
	
	@SpringBean
	Book book;

	private String title = null;
	
	private String isbn = null;
	
	private String author = null;

	private List<Book> listBook =  Collections.emptyList();

	public ListBookPage(PageParameters parameters) {
		title = parameters.get("title").toString();
		isbn = parameters.get("isbn").toString();
		author = parameters.get("author").toString();
		initComponents();
	}

	public ListBookPage() {
		initComponents();
	}

	private void initComponents() {
		add(new Label("title", "Lista de Libros"));
		addFormBook();
		addFeedBackPanel();
		addListBookView();
		add(new BookmarkablePageLink<String>("libraryLink", HomePage.class));
	}

	private void addFormBook() {
		Form<Book> form = new Form<Book>("formListBook", new CompoundPropertyModel<Book>(book)) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				super.onSubmit();
				listBook.clear();
				PageParameters pageParameters = new PageParameters();
				if(getModelObject().getNameBook() != null)
					pageParameters.add("title", getModelObject().getNameBook());
				if(getModelObject().getISBN() != null)
					pageParameters.add("isbn", getModelObject().getISBN());
				if(getModelObject().getNameAuthor() != null)
					pageParameters.add("author", getModelObject().getNameAuthor());
				setResponsePage(ListBookPage.class, pageParameters);
			}
		};
		form.add(new TextField<String>("nameBook"));
		form.add(new TextField<String>("ISBN"));
		form.add(new TextField<String>("nameAuthor"));
		add(form);
	}

	private void addFeedBackPanel() {
		FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackMessage");
		add(feedbackPanel);
	}

	private void addListBookView() {
		Book book = new Book();
		if(title != null)
			book.setNameBook(title);
		if(isbn != null)
			book.setISBN(isbn);
		if(author != null)
			book.setNameAuthor(author);
		listBook = bookService.findBook(book);
		ListView<Book> listview = new ListView<Book>("book-group", listBook) {
			
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Book> item) {
				Book book = item.getModelObject();
				item.add(new Label("title", book.getNameBook()));
				item.add(new Label("isbn", book.getISBN()));
				item.add(new Label("author", book.getNameAuthor()));
			}
		};
		add(listview);
	}

}
