package com.company.U1M5ChallengeTengaDaniele.dao;

import com.company.U1M5ChallengeTengaDaniele.model.Author;
import com.company.U1M5ChallengeTengaDaniele.model.Publisher;

import java.util.List;

public interface PublisherDao {
    //create, read, read all, update, and
    // delete Books, Authors, and Publishers in the system.
    Publisher createPublisher(Publisher publisher);
    List<Publisher> readAll();
    Publisher readPublisher(int id);
    void updatePublisher(Publisher updatePublisher);
    void deletePublisher(int publisher);
}
