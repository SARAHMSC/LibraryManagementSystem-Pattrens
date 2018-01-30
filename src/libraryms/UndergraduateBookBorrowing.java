package libraryms;

/**
 * 
 * @author seemaanwer
 */
public class UndergraduateBookBorrowing implements BookBorrowingStrategy {
    private int noOfBooksLimit = 2;
    
    @Override  
    public void checkBookBorrowingStrategy(Member m, Book b) {
      
        // if member hasn't reached the max limit.
        // if book is not of restricted type.
        if (m.getNoOfBooksIssued() < noOfBooksLimit) {
            // Can borrow.
            b.bookBorrowed(m.getId());
            m.borrowsBook(b.getId()); 
            System.out.println("The book has been successfully borrowed!");
        } // if
        else {
            System.out.println("Sorry you can't borrow this book as you have reached you max book limit!");
        } // else
    } // checkBookBorrowingStrategy()     
} // UndergraduateBookBorrowing