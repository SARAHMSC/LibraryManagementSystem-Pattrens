package com.borrow;
import libraryms.Book;
import libraryms.BookBorrowingStrategyContext;
import libraryms.Member;
import libraryms.PostgraduateBookBorrowing;
import libraryms.UndergraduateBookBorrowing;

public class StateBorrow implements State {
	@Override
	public void doAction(Member m, Book b) {
		//System.out.println("Book " + b.getTitle() + " can be borrowed now, it goes through futher availablitiy checks!");
		BookBorrowingStrategyContext context = new BookBorrowingStrategyContext();

		// Try to borrow a book
		if (m.getType() == "UG") {
			context.setBookBorrowingStrategy(new UndergraduateBookBorrowing());
			context.checkBookBorrowingStrategy(m, b);
		} // if
		else {
			context.setBookBorrowingStrategy(new PostgraduateBookBorrowing());
			context.checkBookBorrowingStrategy(m, b);
		} // else
	}
     // doAction()
} // StateBorrow