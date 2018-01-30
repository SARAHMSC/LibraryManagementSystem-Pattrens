package libraryms;

/**
 * 
 * @author seemaanwer
 */
public class BookBorrowingStrategyContext {
    private BookBorrowingStrategy strategy;
    
    public void setBookBorrowingStrategy(BookBorrowingStrategy borrowingStrategy) {
        strategy = borrowingStrategy;
    } // setBookBorrowingStrategy()
    
    public BookBorrowingStrategy getBookBorrowingStrategy() {
        return strategy;
    } //  getBookBorrowingStrategy()
    
    public void checkBookBorrowingStrategy(Member m, Book b) {
        strategy.checkBookBorrowingStrategy(m, b);
    } // checkBookBorrowingStrategy
} // BookBorrowingStrategyContext