package com.company.U1M5ChallengeTengaDaniele.dao;

import com.company.U1M5ChallengeTengaDaniele.model.Author;
import com.company.U1M5ChallengeTengaDaniele.model.Book;
import com.company.U1M5ChallengeTengaDaniele.model.Publisher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherDaoTest {
    @Autowired
    protected AuthorDao authorDao;
    @Autowired
    protected BookDao bookDao;
    @Autowired
    protected PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {
        // clean out the test db
        List<Author> aList = authorDao.readAll();

        aList.stream()
                .forEach(author -> authorDao.deleteAuthor(author.getAuthor_id()));

        List<Book> bList = bookDao.readAll();

        bList.stream()
                .forEach(book -> bookDao.deleteBook(book.getBook_id()));

        List<Publisher> pList = publisherDao.readAll();

        pList.stream()
                .forEach(publisher -> publisherDao.deletePublisher(publisher.getPublisher_id()));
    }

        @After
        public void tearDown() throws Exception {
        }
        @Test
        public void addGetDeletePublisher() {

            Publisher publisher = new Publisher();
            publisher.setName("PERC");
            publisher.setStreet("Broad St");
            publisher.setCity("Savannah");
            publisher.setState("GA");
            publisher.setPostal_code("31401");
            publisher.setPhone("912-555-5555");
            publisher.setEmail("totallyrealemail@perc.com");
            publisher.setPublisher_id(publisher.getPublisher_id());

            publisher = publisherDao.createPublisher(publisher);

            Publisher publisher2 = publisherDao.readPublisher(publisher.getPublisher_id());

            assertEquals(publisher, publisher2);

            publisherDao.deletePublisher(publisher.getPublisher_id());

            publisher2 = publisherDao.readPublisher(publisher.getPublisher_id());

            assertNull(publisher2);
        }
        @Test
        public void getAllRoasters() {

            Publisher publisher = new Publisher();
            publisher.setName("PERC");
            publisher.setStreet("Broad St");
            publisher.setCity("Savannah");
            publisher.setState("GA");
            publisher.setPostal_code("31401");
            publisher.setPhone("912-555-5555");
            publisher.setEmail("totallyrealemail@perc.com");
            publisher.setPublisher_id(publisher.getPublisher_id());

            publisherDao.createPublisher(publisher);

            publisher = new Publisher();
            publisher.setName("PERC");
            publisher.setStreet("Broad St");
            publisher.setCity("Savannah");
            publisher.setState("GA");
            publisher.setPostal_code("31401");
            publisher.setPhone("912-555-5555");
            publisher.setEmail("totallyrealemail@perc.com");
            publisher.setPublisher_id(publisher.getPublisher_id());

            publisherDao.createPublisher(publisher);

            List<Publisher> publisherList = publisherDao.readAll();

            assertEquals(publisherList.size(), 2);
        }
        @Test
        public void updateRoaster() {

            Publisher publisher = new Publisher();
            publisher.setName("PERC");
            publisher.setStreet("Broad St");
            publisher.setCity("Savannah");
            publisher.setState("GA");
            publisher.setPostal_code("31401");
            publisher.setPhone("912-555-5555");
            publisher.setEmail("totallyrealemail@perc.com");
            publisher.setPublisher_id(publisher.getPublisher_id());

            publisherDao.createPublisher(publisher);

            publisher.setName("UPDATED");
            publisher.setStreet("NEW STREET");
            publisher.setCity("ST LOUIS");
            publisher.setState("MO");

            publisherDao.updatePublisher(publisher);

            Publisher publisher2 = publisherDao.readPublisher(publisher.getPublisher_id());

            assertEquals(publisher2, publisher);
        }

}