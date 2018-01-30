package libraryms;
import com.borrow.State;
import com.borrow.StateReturn;

/**
 * 
 * @author seemaanwer
 */
public class Return {

	public void returnBook(Member m, Book b) {
		if (b.checkAvailability() < b.getNoOfCopies()) {
			State StateReturn = new StateReturn();
			StateReturn.doAction(m, b);
		} // if
		else {
		    System.out.println("This book can't be returned!");
		} // else
	}  // borrowBook()
} // Borrow