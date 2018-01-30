package libraryms;
import java.util.ArrayList;

import com.filereader.*;

/**
 * 
 * @author seemaanwer
 */
public class BookFactory {

	private static BookFactory instance;

	public static synchronized BookFactory getInstance() {
		if (instance == null) {
			instance = new BookFactory();
		} // if
		return instance;
	} // BookFactory

	// Reads and generates all of the book objects.
	public static ArrayList<Book> getAllBooks(String filetype, String filename) {

		ArrayList<Book> booklist = new ArrayList<Book>();
		ArrayList<String[]> dataArr = null;
		try {

			FileReader fr = new FileReader();
			dataArr = fr.reader(filetype, filename);

			// Reads each line from the file.
			for (String[] data : dataArr) {
				if (!data.equals("")) {
					Book newBook = new Book(Integer.parseInt(data[0]), data[1],
							data[2], data[3], Integer.parseInt(data[4]));
					booklist.add(newBook);
				} // if
			} // for
		} // try
		// Catches and describes the cause of exception.
		catch (Exception E) {
			System.out.println(E.getMessage());
		} // catch

		return booklist;
	} // main
} // BookFactory