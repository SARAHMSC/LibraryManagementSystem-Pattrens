package libraryms;

/**
 * 
 * @author seemaanwer
 */
// Help from http://www.journaldev.com/1739/observer-design-pattern-in-java
// (3/04/2017) for observer pattern understanding.
public class Member implements Observer {
 
    private int id;
    private int noOfBooksIssued = 0;
    private int[] booksIssued;
    private String name;
    private String type;
	private Subject bookRequest;
	
	@Override
	public void update() {
		if (bookRequest == null) {
		   System.out.println(name + ": No new message!");
		} // if
		else {
		    String msg = (String) bookRequest.getUpdate(this);
		    if (msg == null) {
		        System.out.println(name + ": No new message!");
		    } // if
		    else {
		        System.out.println(name +": Consuming message: "+ msg);
		    } // else
		} // else
	} // update()

	@Override
	// Alerts member when given book is available.
	public void setSubject(Subject sub) {
		if ((sub == null) || (bookRequest == null)) {
           this.bookRequest = sub;
		} // if
		else {
			System.out.println("You are already subscribed to a book!");
		} // else
	} // setSubject()
	
	public Subject getSubject() {
        return this.bookRequest;
	} // getSubject()
	
    Member (int memberId, String memberName, String memberType) {
        id = memberId;
        name = memberName;
        booksIssued = null;
        noOfBooksIssued = 0;
        type = memberType;
        bookRequest = null;
    } // Member
    
    public int getId() {
        return id;
    } // getId()
    
    public String getName() {
        return name;
    } // getName()
    
    public int getNoOfBooksIssued() {
        return noOfBooksIssued;
    } // getNoOfBooksIssued()
    
    public int[] getBooksIssued() {
        return booksIssued;
    } // getBooksIssued()
    
    public String getType() {
        return type;
    } // getType()
    
    public void borrowsBook(int b) {
        noOfBooksIssued++;
        int[] newList = new int[noOfBooksIssued];
        for (int i = 0; i < noOfBooksIssued - 1; i++) {
            newList[i] = booksIssued[i];
        } // for
        newList[noOfBooksIssued - 1] = b;
        booksIssued = newList;
    } // bookBorrowed()
    
    public boolean returnsBook(int b) {
        int[] newList;
        if (noOfBooksIssued != 0) {
        	boolean returnBook = false;
            for (int i = 0; i < booksIssued.length; i++) {
                if (booksIssued[i] == b) {
                    //System.out.println("A");
                    returnBook = true;
                } // if
            } // for
            
            if (!returnBook) { 
                 //System.out.println("B");
            	 return false;
            } // if
            
            noOfBooksIssued--;
            newList = new int[noOfBooksIssued];
            int bookCounter = -1;
            int noOfTimes = 0;
            for (int i = 0; i < booksIssued.length; i++) {
                if ((noOfTimes == 0) && (booksIssued[i] == b)) {
                    //System.out.println("J");
                    noOfTimes++;
                } // if
                else if ((noOfTimes > 0) && (booksIssued[i] == b)) {
                    //System.out.println("Z");
                    bookCounter++;
                    newList[bookCounter] = booksIssued[i];
                } // if
                else if (booksIssued[i] != b) {
                    //System.out.println("C");
                    bookCounter++;
                    newList[bookCounter] = booksIssued[i];
                } // if
            } // for
            //System.out.println("E");
            booksIssued = newList;
            return true;
        } // if
        else {
            //System.out.println("D");
            return false;
        } // else
    } // bookReturned()
    
    public String toString() {
        String str = "ID:" + id + ", Name:" + name + ",Type:" + type + ", Number of books issued:" + noOfBooksIssued;
        return str;
    } // toString();
} // Member