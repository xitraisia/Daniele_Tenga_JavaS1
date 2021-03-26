package com.company.U1M5ChallengeTengaDaniele.dao;

import com.company.U1M5ChallengeTengaDaniele.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AuthorDaoJdbc implements AuthorDao{
//Author createAuthor(Author author);
//    List<Author> readAll();
//    Author readAuthor(int id);
//    void updateAuthor(Author updateAuthor);
//    void deleteAuthor(int author);
private static final String INSERT_AUTHOR_SQL =
//        private int author_id; get this from the model
//    private String first_name;
//    private String last_name;
//    private String street;
//    private String city;
//    private String state;
//    private String postalCode;
//    private String phone;
//    private String email;
        "insert into author (first_name, last_name, street, city, state, postal_code, phone, email) values ( ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_AUTHOR_SQL =
            "select * from author where author_id = ?";

    private static final String SELECT_ALL_AUTHOR_SQL =
            "select * from author";

    private static final String DELETE_AUTHOR_SQL =
            "delete from author where author_id = ?";

    private static final String UPDATE_AUTHOR_SQL =
            "update author set first_name = ?, last_name = ?, street = ?, city = ?, state = ?, postal_code = ?, phone = ?, email = ? where author_id = ?";


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorDaoJdbc(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Author createAuthor(Author author) {

        jdbcTemplate.update(INSERT_AUTHOR_SQL,
                author.getFirst_name(),
                author.getLast_name(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getPostal_code(),
                author.getPhone(),
                author.getEmail());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        author.setAuthor_id(id);

        return author;
    }

    @Override
    public List<Author> readAll() {
        return jdbcTemplate.query(SELECT_ALL_AUTHOR_SQL, this::mapRowToAuthor);
    }

    @Override
    public Author readAuthor(int id) {
        try {

            return jdbcTemplate.queryForObject(SELECT_AUTHOR_SQL, this::mapRowToAuthor, id);

        } catch (EmptyResultDataAccessException e) {
            // if nothing is returned just catch the exception and return null
            return null;
        }
    }

    @Override
    public void updateAuthor(Author updateAuthor) {
        jdbcTemplate.update(UPDATE_AUTHOR_SQL,
                updateAuthor.getFirst_name(),
                updateAuthor.getLast_name(),
                updateAuthor.getStreet(),
                updateAuthor.getCity(),
                updateAuthor.getState(),
                updateAuthor.getPostal_code(),
                updateAuthor.getPhone(),
                updateAuthor.getEmail(),
                updateAuthor.getAuthor_id());
    }

    @Override
    public void deleteAuthor(int author) { //!!!!says I cannot delete or update a parent row, foreign key constraint
        jdbcTemplate.update(DELETE_AUTHOR_SQL, author);
    }

    // Helper methods
    private Author mapRowToAuthor(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        author.setAuthor_id(rs.getInt("author_id"));
        author.setFirst_name(rs.getString("first_name"));
        author.setLast_name(rs.getString("last_name"));
        author.setCity(rs.getString("city"));
        author.setEmail(rs.getString("email"));
        author.setPhone(rs.getString("phone"));
        author.setState(rs.getString("state"));
        author.setStreet(rs.getString("street"));
        author.setPostal_code(rs.getString("postal_code"));

        return author;
    }
}
