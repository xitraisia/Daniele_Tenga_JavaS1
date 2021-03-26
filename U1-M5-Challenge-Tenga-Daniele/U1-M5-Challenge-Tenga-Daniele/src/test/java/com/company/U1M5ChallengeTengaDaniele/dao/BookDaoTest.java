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

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoTest {

    @Autowired
    protected AuthorDao AuthorDao;
    @Autowired
    protected BookDao BookDao;
    @Autowired
    protected PublisherDao PublisherDao;

    @Before
    public void setUp() throws Exception {
        // clean out the test db
        List<Book> bList = BookDao.readAll();

        bList.stream()
                .forEach(book -> BookDao.deleteBook(book.getBook_id()));

        List<Author> aList = AuthorDao.readAll();

        aList.stream()
                .forEach(author -> AuthorDao.deleteAuthor(author.getAuthor_id()));

        List<Publisher> pList = PublisherDao.readAll();

        pList.stream()
                .forEach(publisher -> PublisherDao.deletePublisher(publisher.getPublisher_id()));
    }

        @After
        public void tearDown() throws Exception {
        }
        @Test
        public void addGetDeleteBook() {
//so the ids auto increment so there is no need to set id.
            //you cant have a book without an author so the author auto increments and the author id is added to the book

            Publisher publisher = new Publisher();
            publisher.setName("PERC");
            publisher.setStreet("Broad St");
            publisher.setCity("Savannah");
            publisher.setState("GA");
            publisher.setPostal_code("31401");
            publisher.setPhone("912-555-5555");
            publisher.setEmail("totallyrealemail@perc.com");
            publisher.setPublisher_id(publisher.getPublisher_id());

            publisher = PublisherDao.createPublisher(publisher);

            Publisher publisher2 = PublisherDao.readPublisher(publisher.getPublisher_id());

            assertEquals(publisher, publisher2);

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


            author = AuthorDao.createAuthor(author);

            Author author2 = AuthorDao.readAuthor(author.getAuthor_id());

            assertEquals(author, author2);

            Book book = new Book();
            book.setPublisher_id(publisher.getPublisher_id());
            book.setPrice(22.2);
            book.setBook_id(book.getBook_id());
            book.setIsbn("GArg98");
            book.setTitle("Crayola");
            book.setAuthor_id(author.getAuthor_id());
            book.setPublish_date(LocalDate.of(1983,12,13));

            book = BookDao.createBook(book);

            Book book2 = BookDao.readBook(book.getBook_id());

            assertEquals(book, book2);

            BookDao.deleteBook(book.getBook_id());

            book2 = BookDao.readBook(book.getBook_id());

            assertNull(book2);
        }
        @Test
        public void getAllBooks() {

            //I need authordao and publisher doa because we will be creating a publisher and author

            Publisher publisher = new Publisher();
            publisher.setName("PERC");
            publisher.setStreet("Broad St");
            publisher.setCity("Savannah");
            publisher.setState("GA");
            publisher.setPostal_code("31401");
            publisher.setPhone("912-555-5555");
            publisher.setEmail("totallyrealemail@perc.com");
            publisher.setPublisher_id(publisher.getPublisher_id());

            publisher = PublisherDao.createPublisher(publisher);

            Publisher publisher2 = PublisherDao.readPublisher(publisher.getPublisher_id());

            assertEquals(publisher, publisher2);

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


            author = AuthorDao.createAuthor(author);

            Author author2 = AuthorDao.readAuthor(author.getAuthor_id());

            assertEquals(author, author2);


            Book book = new Book();
            book.setPublisher_id(publisher.getPublisher_id());
            book.setPrice(22.2);
            book.setIsbn("GArg98");
            book.setTitle("Crayola");
            book.setAuthor_id(author.getAuthor_id());
            book.setPublish_date(LocalDate.of(1980,12,13) );

            BookDao.createBook(book);

            book = new Book();
            book.setPublisher_id(publisher.getPublisher_id());
            book.setPrice(22.2);
            book.setIsbn("GArg98");
            book.setTitle("Crayola");
            book.setAuthor_id(author.getAuthor_id());
            book.setPublish_date(LocalDate.of(1983,12,13));

            BookDao.createBook(book);

            List<Book> bookList = BookDao.readAll();

            assertEquals(bookList.size(), 2);
        }

        @Test
        public void readBookByAuthor() {

            Publisher publisher = new Publisher();
            publisher.setName("PERC");
            publisher.setStreet("Broad St");
            publisher.setCity("Savannah");
            publisher.setState("GA");
            publisher.setPostal_code("31401");
            publisher.setPhone("912-555-5555");
            publisher.setEmail("totallyrealemail@perc.com");
            publisher.setPublisher_id(publisher.getPublisher_id());

            publisher = PublisherDao.createPublisher(publisher);

            Publisher publisher2 = new Publisher();
            publisher2.setName("PERC");
            publisher2.setStreet("Broad St");
            publisher2.setCity("Savannah");
            publisher2.setState("GA");
            publisher2.setPostal_code("31401");
            publisher2.setPhone("912-555-5555");
            publisher2.setEmail("totallyrealemail@perc.com");
            publisher2.setPublisher_id(publisher.getPublisher_id());

            publisher2 = PublisherDao.createPublisher(publisher);

            Publisher publisher3 = new Publisher();
            publisher3.setName("PERC");
            publisher3.setStreet("Broad St");
            publisher3.setCity("Savannah");
            publisher3.setState("GA");
            publisher3.setPostal_code("31401");
            publisher3.setPhone("912-555-5555");
            publisher3.setEmail("totallyrealemail@perc.com");
            publisher3.setPublisher_id(publisher.getPublisher_id());

            publisher3 = PublisherDao.createPublisher(publisher);

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

            author = AuthorDao.createAuthor(author);

            Author author2 = new Author();
            author2.setFirst_name("Savannah");
            author2.setLast_name("LLC");
            author2.setStreet("Liberty St");
            author2.setCity("Savannah");
            author2.setState("GA");
            author2.setPostal_code("31401");
            author2.setPhone("912-555-0001");
            author2.setEmail("alsolegitemail@scr.com");
            author2.setStreet("6000 mc.alister dr");

            author2 = AuthorDao.createAuthor(author2);

            Author author3 = new Author();
            author3.setFirst_name("New Kids on the block");
            author3.setLast_name("LLC");
            author3.setStreet("Broughton St");
            author3.setCity("Savannah");
            author3.setState("GA");
            author3.setPostal_code("31401");
            author3.setPhone("912-555-1122");
            author3.setEmail("bbunchofhits@nkotb.com");
            author3.setStreet("8000 mc.alister dr");


            author3 = AuthorDao.createAuthor(author3);

            Book book = new Book();
            book.setPublisher_id(publisher.getPublisher_id());
            book.setPrice(22.2);
            book.setIsbn("GArg98");
            book.setTitle("Crayola");
            book.setAuthor_id(author.getAuthor_id());
            book.setPublish_date(LocalDate.of(1983,12,13));

            book = BookDao.createBook(book);

            Book book2 = new Book();
            book2.setPublisher_id(publisher2.getPublisher_id());
            book2.setPrice(20.2);
            book2.setIsbn("BOBN67");
            book2.setTitle("Brayola");
            book2.setAuthor_id(author2.getAuthor_id());
            book2.setPublish_date(LocalDate.of(1983,12,13));

            book2 = BookDao.createBook(book2);

            Book book3 = new Book();
            book3.setPublisher_id(publisher3.getPublisher_id());
            book3.setPrice(19.2);
            book3.setIsbn("TART89");
            book3.setTitle("Crayola");
            book3.setAuthor_id(author.getAuthor_id());
            book3.setPublish_date(LocalDate.of(1983,12,13));

            book3 = BookDao.createBook(book3);


            List<Book> cList = BookDao.getBookByAuthor(author.getAuthor_id());
            assertEquals(2, cList.size());

            List<Book> cList2 = BookDao.getBookByAuthor(author2.getAuthor_id());
            assertEquals(1, cList2.size());

            List<Book> cList3 = BookDao.getBookByAuthor(author3.getAuthor_id());
            assertEquals(0, cList3.size());

        }
        @Test
        public void updateBook() {

            Publisher publisher = new Publisher();
            publisher.setName("PERC");
            publisher.setStreet("Broad St");
            publisher.setCity("Savannah");
            publisher.setState("GA");
            publisher.setPostal_code("31401");
            publisher.setPhone("912-555-5555");
            publisher.setEmail("totallyrealemail@perc.com");
            publisher.setPublisher_id(publisher.getPublisher_id());

            publisher = PublisherDao.createPublisher(publisher);

            Publisher publisher2 = PublisherDao.readPublisher(publisher.getPublisher_id());

            assertEquals(publisher, publisher2);

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


            author = AuthorDao.createAuthor(author);

            Author author2 = AuthorDao.readAuthor(author.getAuthor_id());

            assertEquals(author, author2);

            Book book = new Book();
            book.setPublisher_id(publisher.getPublisher_id());
            book.setPrice(22.2);
            book.setBook_id(book.getBook_id());
            book.setIsbn("GArg98");
            book.setTitle("Crayola");
            book.setAuthor_id(author.getAuthor_id());
            book.setPublish_date(LocalDate.of(1983,12,13));

            book = BookDao.createBook(book);

            book.setTitle("UPDATED");
            book.setPublisher_id(book.getPublisher_id());
            book.setBook_id(book.getBook_id());

            BookDao.updateBook(book);

            Book book2 = BookDao.readBook(book.getBook_id());

            assertEquals(book2, book);
        }
}