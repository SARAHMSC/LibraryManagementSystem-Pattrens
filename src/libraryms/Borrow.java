package libraryms;
import com.borrow.State;
import com.borrow.StateBorrow;

public class Borrow {

	public void borrowBook(Member m, Book b) {
		System.out.println("Availability: " + b.checkAvailability() + " copies.");
		if (b.checkAvailability() > 0) {
			State StateBorrow = new StateBorrow();
			StateBorrow.doAction(m, b);
		} // if
		else {
			//State StateReturn = new StateReturn();
			//StateReturn.doAction(m, b);
		    System.out.println("This book can't be borrowed!");
		} // else
	}  // borrowBook()
} // Borrow