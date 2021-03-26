package com.company.U1M5ChallengeTengaDaniele.dao;

import com.company.U1M5ChallengeTengaDaniele.model.Author;

import java.util.List;

public interface AuthorDao {
    //create, read, read all, update, and
    // delete Books, Authors, and Publishers in the system.

    Author createAuthor(Author author);
    List<Author> readAll();
    Author readAuthor(int id);
    void updateAuthor(Author updateAuthor);
    void deleteAuthor(int author);
}
