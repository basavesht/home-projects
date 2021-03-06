package com.tcs.sample.jaxb;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.tcs.sample.jaxb.model.Book;
import com.tcs.sample.jaxb.model.BookStore;

/**
 * @author 224703
 *
 */
public class BookClient {

	private static final String BOOKSTORE_XML = "./bookstore-jaxb.xml";

	public static void main(String[] args) throws JAXBException, IOException 
	{
		ArrayList<Book> bookList = new ArrayList<Book>();

		//Create Books..
		Book book1 = new Book();
		book1.setIsbn("978-0060554736");
		book1.setName("The Game");
		book1.setAuthor("Neil Strauss");
		book1.setPublisher("Harpercollins");
		bookList.add(book1);

		Book book2 = new Book();
		book2.setIsbn("978-3832180577");
		book2.setName("Feuchtgebiete");
		book2.setAuthor("Charlotte Roche");
		book2.setPublisher("Dumont Buchverlag");
		bookList.add(book2);

		// create bookstore, assigning book
		BookStore bookstore = new BookStore();
		bookstore.setName("Fraport Bookstore");
		bookstore.setLocation("Frankfurt Airport");
		bookstore.setBookList(bookList);

		JAXBContext context = JAXBContext.newInstance(BookStore.class);

		//Marshaling...
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(bookstore, System.out);

		Writer w = null;
		try {
			w = new FileWriter(BOOKSTORE_XML);
			m.marshal(bookstore, w);
		} finally {
			try {
				w.close();
			} catch (Exception e) {
			}
		}

		//UnMarshalling...
		System.out.println();
		System.out.println("Output from our XML File: ");
		Unmarshaller um = context.createUnmarshaller();
		BookStore bookstore2 = (BookStore) um.unmarshal(new FileReader(BOOKSTORE_XML));

		for (int i = 0; i < bookstore2.getBooksList().toArray().length; i++) {
			System.out.println("Book " + (i + 1) + ": "
					+ bookstore2.getBooksList().get(i).getName() + " from "
					+ bookstore2.getBooksList().get(i).getAuthor());
		}
	}
}


