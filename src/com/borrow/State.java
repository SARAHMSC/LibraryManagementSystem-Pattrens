package com.borrow;
import libraryms.Book;
import libraryms.Member;

public interface State {
 	   public void doAction(Member m, Book b);
} // State
