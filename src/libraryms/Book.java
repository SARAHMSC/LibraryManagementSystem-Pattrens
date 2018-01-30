package libraryms;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author seemaanwer
 */
// Help from http://www.journaldev.com/1739/observer-design-pattern-in-java
// (3/04/2017) for subject pattern understanding.
public class Book implements Subject{
    
    private int id;
    private String title;
    private String author;
    private String category;
    private int noOfCopiesAvailable;
    private int[] borrowedBy;
    private int noOfCopies;
    
    private List<Observer> observers;
	private String message;
	private boolean changed;
	private final Object MUTEX= new Object();
	
	@Override
	public void register(Observer obj) {
		if (obj == null) {
			throw new NullPointerException("Null Observer!");
		} // if
		else if (obj.getSubject() == null) {
		   synchronized (MUTEX) {
		      if(!observers.contains(obj)){
			     observers.add(obj);
			     this.message = "" + noOfCopiesAvailable + " copies available!";
		      } // if
		   } // synchronized
		} // else
	} // register()

	@Override
	public void unregister(Observer obj) {
		synchronized (MUTEX) {
		   observers.remove(obj);
		   obj.setSubject(null);
		} // synchronized
	} // unregister()

	@Override
	public void notifyObservers() {
		List<Observer> observersLocal = null;
		
		// The synchronization is used to make sure any observer registered after message is received is not notified
		synchronized (MUTEX) {
			if (!changed)
				return;
			observersLocal = new ArrayList<Observer>(this.observers);
			this.changed=false;
		} // synchronized
		
		for (Observer obj : observersLocal) {
			obj.update();
		} // for
	} // notifyObservers()

	@Override
	public Object getUpdate(Observer obj) {
		return this.message;
	} // getUpdate()

    public Book (int bookId, String bookTitle, String bookAuthor, String bookCategory, int noOfBookCopies) {
        id = bookId;
        title = bookTitle;
        author = bookAuthor;
        category = bookCategory;
        noOfCopies = noOfBookCopies;
        noOfCopiesAvailable = noOfCopies;
        borrowedBy = new int[noOfCopies];
        for (int i = 0; i < noOfCopies; i++) {
            borrowedBy[i] = -1;
        } // for
        this.observers= new ArrayList<Observer>();
    } // Book
    
    public int getId() {
        return id;
    } // getId()
    
    public String getTitle() {
        return title;
    } // getTitle()
    
    public String getAuthor() {
        return author;
    } // getAuthor()
    
    public String getCategory() {
        return category;
    } // getCategory()
    
    public int[] getBorrowedBy() {
        return borrowedBy;
    } // getBorrowedBy()
    
    public int checkAvailability() {
        if (noOfCopiesAvailable > 0) {
            return noOfCopiesAvailable;
        } // if
        else {
            return 0;
        } // else
    } // checkAvailability()
    
    public void bookBorrowed(int m) {
        if (noOfCopiesAvailable != 0) {
            int index = -1;
            for (int i = 0; i < noOfCopies; i++) {
                if (borrowedBy[i] == -1) {
                    index = i;
                } // if
            } // for
            borrowedBy[index] = m;
            noOfCopiesAvailable--;
        } // if
    } // setBorrowed()
    
    public boolean bookReturned(int m) {
        if (noOfCopiesAvailable < noOfCopies) { 
            boolean found = false;
            int index = -1;
            for (int i = 0; i < noOfCopies; i++) {
                if (borrowedBy[i] == m) {
                    found = true;
                    index = i;
                } // if
            } // for
    
            if (!found) { 
       	        return false;
            } // if
            
            noOfCopiesAvailable++;
            borrowedBy[index] = -1;
            
    		this.message = "" + noOfCopiesAvailable + " copies available!";
    		this.changed = true;
    		notifyObservers();
            return true;
        } // if
        else {
            return false;
        } // else
       
    } // bookReturned()
    
    public int getNoOfCopies() {
        return noOfCopies;
    } // getNoOfCopies()
    
    public int getNoOfCopiesAvailable() {
        return noOfCopiesAvailable;
    } // getNoOfCopiesAvailable()
    
    public String toString() {
        String str = "ID:" + id + ", Title:" + title + ", Author:" + author + ", Category:" + category + ", Number of Copies:" + noOfCopies + ", Availability:" + noOfCopiesAvailable;
        return str;
    } // toString();
} // Book