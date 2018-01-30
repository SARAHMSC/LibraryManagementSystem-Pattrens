/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryms;
import java.util.ArrayList;

/**
 * 
 * @author seemaanwer
 */
public class LibraryManager {
	private static ArrayList<Book> bookList = new ArrayList<Book>();

	// List all of the books in the library.
	public static String listAllLibraryBooks(ArrayList<Book> bookList) {
		String str = "";

		int i = 0;
		for (Book BookListObj : bookList) {
			i = i + 1;
			str = str + "\n" + (i) + ") " + BookListObj.toString();
		} // for
		str = str + "\n";
		return str;
	} // toString()

	public static void main(String[] arg) {
		bookList = BookFactory.getAllBooks("csv",com.filereader.FileReader.class
				.getResource("datafile.csv").getPath());

		System.out.println("The library contains the following books: "
				+ listAllLibraryBooks(bookList));
	
		bookList.addAll(BookFactory.getAllBooks("json",com.filereader.FileReader.class
				.getResource("datafile.json").getPath()));

		System.out.println("The library contains the following books: "
				+ listAllLibraryBooks(bookList));
		
		bookList.addAll(BookFactory.getAllBooks("xml",com.filereader.FileReader.class
				.getResource("datafile.xml").getPath()));

		System.out.println("The library contains the following books: "
				+ listAllLibraryBooks(bookList));

		System.out.println("The members of the library are: ");
		Member m1 = new Member(1, "Johnathan", "UG");
		Member m2 = new Member(2, "Saaqib", "PG");
		System.out.println("Member: " + m1);
		System.out.println("Member: " + m2);
		System.out.println();

	    /* Logic for all book - commented for time being 
	    for (Book BookListObj : bookList) {			
			  Borrow b = new Borrow();
			  b.borrowBook(m, BookListObj);
			
			System.out.println("Book " + BookListObj);
			System.out.println("Member " + m);
			System.out.println();		
						
		}*/
		 Borrow b = new Borrow();
		 Return r = new Return();
		 
		 System.out.println("'Member' " + m1.getName()+ " wants to borrow the book " + bookList.get(0).getTitle());
		 b.borrowBook(m1, bookList.get(0)); 
		 System.out.println();
		 
		 System.out.println("'Member' " + m1.getName()+  " wants  to borrow the book " + bookList.get(0).getTitle());
		 b.borrowBook(m1, bookList.get(0));
		 System.out.println();
		 
		 System.out.println("'Member' " + m2.getName()+ " wants to borrow the book " + bookList.get(0).getTitle());
		 b.borrowBook(m2, bookList.get(0));	
		 System.out.println();
		 
		 System.out.println("'Member' " + m2.getName()+ " wants to borrow the book " + bookList.get(1).getTitle());
		 b.borrowBook(m2, bookList.get(1));
		 System.out.println();
		 
		 System.out.println("'Member' " + m2.getName()+ " wants to borrow the book " + bookList.get(1).getTitle());
		 b.borrowBook(m2, bookList.get(1));
		 System.out.println();
		 
		 System.out.println("'Member' " + m1.getName()+ " wants to borrow the book " + bookList.get(2).getTitle());
		 b.borrowBook(m1, bookList.get(2));
		 System.out.println();
		 
		 System.out.println("'Member' " + m2.getName()+ " wants to borrow the book " + bookList.get(2).getTitle());
		 b.borrowBook(m2, bookList.get(2));
		 System.out.println();
		 
		 System.out.println("'Member' " + m2.getName()+ " wants to borrow the book " + bookList.get(2).getTitle());
		 b.borrowBook(m2, bookList.get(2));
		 System.out.println();
		 
		 System.out.println("'Member' " + m2.getName()+ " wants to borrow the book " + bookList.get(2).getTitle());
		 b.borrowBook(m2, bookList.get(2));
		 System.out.println();
		 
		 System.out.println("'Member' " + m2.getName()+ " wants to borrow the book " + bookList.get(2).getTitle());
		 b.borrowBook(m2, bookList.get(2));
		 System.out.println();
		 
		 System.out.println("Current status:");
		 System.out.println(bookList.get(0).toString());
		 System.out.println(bookList.get(1).toString());
		 System.out.println(m1.toString());
		 System.out.println(m2.toString());
		 System.out.println();
		 
		 System.out.println("'Member' " + m2.getName()+ " wants to return the book " + bookList.get(0).getTitle());
		 r.returnBook(m2, bookList.get(0));
		 System.out.println();
		 
		 System.out.println("'Member' " + m1.getName()+ " wants to return the book " + bookList.get(0).getTitle());
		 System.out.println(bookList.get(0).toString());
		 System.out.println(m1.toString());
		 r.returnBook(m1, bookList.get(0));
		 System.out.println(bookList.get(0).toString());
		 System.out.println(m1.toString());
		 System.out.println();
		 
		 System.out.println("'Member' " + m1.getName()+ " wants to return the book " + bookList.get(0).getTitle());
		 r.returnBook(m1, bookList.get(0));
		 System.out.println(bookList.get(0).toString());
		 System.out.println(m1.toString());
		 System.out.println();
		 
		 System.out.println("'Member' " + m1.getName()+ " wants to return the book " + bookList.get(0).getTitle());
		 r.returnBook(m1, bookList.get(0));
		 System.out.println(bookList.get(0).toString());
		 System.out.println(m1.toString());
		 System.out.println();
		 
		 System.out.println("'Member' " + m1.getName()+ " wants to return the book " + bookList.get(2).getTitle());
		 r.returnBook(m1, bookList.get(2));
		 System.out.println(bookList.get(2).toString());
		 System.out.println(m1.toString());
		 System.out.println();
		 
		 System.out.println("'Member' " + m2.getName()+ " wants to return the book " + bookList.get(2).getTitle());
		 r.returnBook(m2, bookList.get(2));
		 System.out.println(bookList.get(2).toString());
		 System.out.println(m2.toString());
		 System.out.println();
	} // main()
} // LibraryManager