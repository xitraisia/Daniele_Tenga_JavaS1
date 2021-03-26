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
public class AuthorDaoTest {

    @Autowired
    protected AuthorDao authorDao;
    @Autowired
    protected BookDao bookDao;
    @Autowired
    protected PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {
        // clean out the test db
        List<Book> bList = bookDao.readAll();

        bList.stream()
                .forEach(book -> bookDao.deleteBook(book.getBook_id()));
        List<Author> aList = authorDao.readAll();

        aList.stream()
                .forEach(author -> authorDao.deleteAuthor(author.getAuthor_id()));


        List<Publisher> pList = publisherDao.readAll();

        pList.stream()
                .forEach(publisher -> publisherDao.deletePublisher(publisher.getPublisher_id()));
    }

        @After
        public void tearDown() throws Exception {
        }

        @Test
        public void createGetDeleteAuthor() {

            Author author = new Author();
            author.setFirst_name("PERC");
            author.setLast_name("ESSET");
            author.setStreet("Broad St");
            author.setCity("Savannah");
            author.setState("GA");
            author.setPostal_code("31401");
            author.setPhone("912-555-5555");
            author.setEmail("totallyrealemail@perc.com");
            author.setAuthor_id(author.getAuthor_id());
            author.setStreet("3000 mc.alister dr");


            author = authorDao.createAuthor(author);

            Author author2 = authorDao.readAuthor(author.getAuthor_id());

            assertEquals(author, author2);

            authorDao.deleteAuthor(author.getAuthor_id());

            author2 = authorDao.readAuthor(author.getAuthor_id());

            assertNull(author2);
        }
    @Test
    public void getAllAuthors() {

        Author author = new Author();
        author.setFirst_name("PERC");
        author.setLast_name("ESSET");
        author.setStreet("Broad St");
        author.setCity("Savannah");
        author.setState("GA");
        author.setPostal_code("31401");
        author.setPhone("912-555-5555");
        author.setEmail("totallyrealemail@perc.com");
        author.setAuthor_id(author.getAuthor_id());
        author.setStreet("3000 mc.alister dr");


        authorDao.createAuthor(author);

        author = new Author();
        author.setFirst_name("PERC");
        author.setLast_name("ESSET");
        author.setStreet("Broad St");
        author.setCity("Savannah");
        author.setState("GA");
        author.setPostal_code("31401");
        author.setPhone("912-555-5555");
        author.setEmail("totallyrealemail@perc.com");
        author.setAuthor_id(author.getAuthor_id());
        author.setStreet("3000 mc.alister dr");

        authorDao.createAuthor(author);

        List<Author> authorList = authorDao.readAll();

        assertEquals(authorList.size(), 2);
    }

        @Test
        public void updateAuthor() {

            Author author = new Author();
            author.setFirst_name("PERC");
            author.setLast_name("ESSET");
            author.setStreet("Broad St");
            author.setCity("Savannah");
            author.setState("GA");
            author.setPostal_code("31401");
            author.setPhone("912-555-5555");
            author.setEmail("totallyrealemail@perc.com");
            author.setStreet("3000 mc.alister dr");

            author = authorDao.createAuthor(author);

            //id here
            author.setAuthor_id(author.getAuthor_id());
            author.setFirst_name("UPDATED");
            author.setStreet("NEW STREET");
            author.setCity("ST LOUIS");
            author.setState("MO");

            authorDao.updateAuthor(author);

            Author author2 = authorDao.readAuthor(author.getAuthor_id());

            assertEquals(author, author2);
        }

}
