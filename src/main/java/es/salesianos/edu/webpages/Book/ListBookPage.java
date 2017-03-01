package es.salesianos.edu.webpages.Book;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import es.salesianos.edu.model.*;
import es.salesianos.edu.service.SimulacroService;
import es.salesianos.edu.webpages.HomePage;

public class ListBookPage extends WebPage {

	private static final long serialVersionUID = -1935854748907274886L;

	@SpringBean
	SimulacroService service;

	private static final Logger logger = LogManager.getLogger(ListBookPage.class.getName());

	private String currentNameSearch = null;

	private List listBook = Collections.emptyList();

	public ListBookPage(PageParameters parameters) {
		currentNameSearch = parameters.get("currentSearchTerm").toString();
		logger.debug("Cargando la pagina con el parametro " + currentNameSearch);
		initComponents();
	}

	public ListBookPage() {
		BookmarkablePageLink bookmarkablePageIndex = new BookmarkablePageLink("linkIndex", HomePage.class);
		
		add(bookmarkablePageIndex);
		initComponents();
	}

	private void initComponents() {
		addForm();
		addFeedBackPanel();
		addlistBookView();
	}

	private void addForm() {
		Form form = new Form("formListBook", new CompoundPropertyModel(new Book())) {
			// @Override
			// protected void onSubmit() {
			// super.onSubmit();
			// listBook.clear();
			// PageParameters pageParameters = new PageParameters();
			// pageParameters.add("currentSearchTerm", ((Book)
			// getModelObject()).getNameBook());
			// setResponsePage(listBookPage.class, pageParameters);
			// }
		};
		Button okButton = new Button("okbutton") {
			public void onSubmit() {
				listBook.clear();
				info("OK was pressed!");
				Book Book1 = new Book();
				Book1.setNameBook("uno");
				Book1.setISBN(1);
				Book1.setAuthor("Lorem 1");
				Book Book2 = new Book();
				Book2.setNameBook("dos");
				Book2.setAuthor("Lorem 2");
				Book2.setISBN(2);
				Book Book3 = new Book();
				Book3.setNameBook("tres");
				Book3.setISBN(3);
				Book3.setAuthor("Lorem 3");
				listBook.add(Book1);
				listBook.add(Book2);
				listBook.add(Book3);
			}
		};
		Button cancelButton = new Button("cancelbutton") {
			public void onSubmit() {
				listBook.clear();
				info("cancel was pressed!");
				Book Book1 = new Book();
				Book1.setNameBook("one");
				Book1.setISBN(1);
				Book1.setAuthor("Lorem 1");
				Book Book2 = new Book();
				Book2.setNameBook("two");
				Book2.setISBN(2);
				Book2.setAuthor("Lorem 2");
				Book Book3 = new Book();
				Book3.setNameBook("three");
				Book3.setISBN(3);
				Book3.setAuthor("Lorem 3");
				listBook.add(Book1);
				listBook.add(Book2);
				listBook.add(Book3);
			}
		};
		form.add(okButton);
		form.add(cancelButton);

		form.add(new TextField("nameBook"));
		add(form);
	}

	private void addFeedBackPanel() {
		FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackMessage");
		add(feedbackPanel);
	}

	private void addlistBookView() {
		Book book = new Book();// service.newEntity()
		book.setNameBook(currentNameSearch);
		listBook = service.searchAllBook(book);
		ListView listview = new ListView("book-group", listBook) {
			@Override
			protected void populateItem(ListItem item) {
				Book Book = (Book) item.getModelObject();
				item.add(new Label("bookName", Book.getNameBook()));
				item.add(new Label("bookISBN", Book.getISBN()));
				item.add(new Label("bookAuthor", Book.getAuthor()));
			}
		};
		add(listview);
	}


}
