package com.company.U1M5ChallengeTengaDaniele.dao;

import com.company.U1M5ChallengeTengaDaniele.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDaoJdbc implements BookDao{
//    Book createBook(Book book);
//    List<Book> readAll();
//    Book readBook(int id);
//    void updateBook(Book updateBook);
//    void deleteBook(int book);
//    List<Book> getBookByAuthor(int author);

private static final String INSERT_BOOK_SQL =
//private int book_id;
//    private String isbn;
//    private String publish_date;
//    private int author_id;
//    private String title;
//    private int publisher_id;
//    private double price;
        "insert into book (isbn, publish_date, author_id, title, publisher_id, price) values (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_BOOK_SQL =
            "select * from book where book_id = ?";

    private static final String SELECT_ALL_BOOK_SQL =
            "select * from book";

    private static final String DELETE_BOOK_SQL =
            "delete from book where book_id = ?";

    private static final String UPDATE_BOOK_SQL =
            "update book set isbn = ?, publish_date = ?, author_id = ?, title = ?, publisher_id = ?, price = ? where book_id = ?";

    private static final String SELECT_BOOK_BY_AUTHOR_SQL =
            "select * from book where author_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDaoJdbc(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Book createBook(Book book) {
        jdbcTemplate.update(INSERT_BOOK_SQL,

                book.getIsbn(),
                book.getPublish_date(),
                book.getAuthor_id(),
                book.getTitle(),
                book.getPublisher_id(),
                book.getPrice());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        book.setBook_id(id);

        return book;
    }

    @Override
    public List<Book> readAll() {
        return jdbcTemplate.query(SELECT_ALL_BOOK_SQL, this::mapRowToBook);
    }

    @Override
    public Book readBook(int id) {
        try {

            return jdbcTemplate.queryForObject(SELECT_BOOK_SQL, this::mapRowToBook, id);

        } catch (EmptyResultDataAccessException e) {
            // if nothing is returned just catch the exception and return null
            return null;
        }
    }

    @Override
    public void updateBook(Book updateBook) {
        jdbcTemplate.update(UPDATE_BOOK_SQL,

                updateBook.getIsbn(),
                updateBook.getPublish_date(),
                updateBook.getAuthor_id(),
                updateBook.getTitle(),
                updateBook.getPublisher_id(),
                updateBook.getPrice(),
                updateBook.getBook_id());
    }

    @Override
    public void deleteBook(int book) {
        jdbcTemplate.update(DELETE_BOOK_SQL, book);
    }

    @Override
    public List<Book> getBookByAuthor(int author) {
        return jdbcTemplate.query(SELECT_BOOK_BY_AUTHOR_SQL, this::mapRowToBook, author);
    }

    private Book mapRowToBook(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setAuthor_id(rs.getInt("author_id"));
        book.setBook_id(rs.getInt("book_id"));
        book.setTitle(rs.getString("title"));
        book.setIsbn(rs.getString("isbn"));
        book.setPrice(rs.getDouble("price"));
        book.setPublish_date(rs.getDate("publish_date").toLocalDate());
        book.setPublisher_id(rs.getInt("publisher_id"));

        return book;
    }
}
