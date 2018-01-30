package com.borrow;
import libraryms.Book;
import libraryms.Member;

public class StateReturn implements State {
	@Override
	public void doAction(Member m, Book b) {
		//System.out.println("No of copies available:" +  b.getNoOfCopiesAvailable());
		//System.out.println("Sorry the book is not available to borrow!");
		//System.out.println("Book " + b.getTitle() + " can be returned now!");
		// Try to Return book.
		boolean returnStatusBook = b.bookReturned(m.getId());
        boolean returnStatusMember = m.returnsBook(b.getId()); 
        if (returnStatusBook && returnStatusMember) {
            System.out.println("This book has been returned successfully!");
        } // if
        else {
            System.out.println("Sorry this book hasn't been returned successfully!");
            //System.out.println("book: " + returnStatusBook);
            //System.out.println("Member: " + returnStatusMember);
        } // else
	} // doAction()
} // StateReturn