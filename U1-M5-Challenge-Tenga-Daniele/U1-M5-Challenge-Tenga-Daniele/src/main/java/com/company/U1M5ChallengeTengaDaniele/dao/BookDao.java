package com.company.U1M5ChallengeTengaDaniele.dao;

import com.company.U1M5ChallengeTengaDaniele.model.Author;
import com.company.U1M5ChallengeTengaDaniele.model.Book;

import java.util.List;

public interface BookDao {
    //create, read, read all, update, and
    // delete Books, Authors, and Publishers in the system.
    //find Books by Author.
    Book createBook(Book book);
    List<Book> readAll();
    Book readBook(int id);
    void updateBook(Book updateBook);
    void deleteBook(int book);
    List<Book> getBookByAuthor(int author);
}
