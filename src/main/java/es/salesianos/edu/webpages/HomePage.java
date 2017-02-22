package es.salesianos.edu.webpages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import es.salesianos.edu.webpages.Author.*;
import es.salesianos.edu.webpages.Book.*;

public class HomePage extends WebPage {
	public HomePage() {
		BookmarkablePageLink bookmarkablePageLink1 = new BookmarkablePageLink("linkAuthorForm", AuthorPage.class);
		BookmarkablePageLink bookmarkablePageLink2 = new BookmarkablePageLink("linkListAuthor", ListAuthorPage.class);
		
		BookmarkablePageLink bookmarkablePageLink3 = new BookmarkablePageLink("linkBookForm", BookPage.class);
		BookmarkablePageLink bookmarkablePageLink4 = new BookmarkablePageLink("linkListBook", ListBookPage.class);
		
		add(bookmarkablePageLink1);
		add(bookmarkablePageLink2);
		add(bookmarkablePageLink3);
		add(bookmarkablePageLink4);
	}
}
