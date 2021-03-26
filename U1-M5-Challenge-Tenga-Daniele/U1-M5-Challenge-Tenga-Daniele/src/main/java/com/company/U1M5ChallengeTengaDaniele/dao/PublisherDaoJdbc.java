package com.company.U1M5ChallengeTengaDaniele.dao;

import com.company.U1M5ChallengeTengaDaniele.model.Book;
import com.company.U1M5ChallengeTengaDaniele.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PublisherDaoJdbc implements PublisherDao{
//    Publisher createPublisher(Publisher publisher);
//    List<Publisher> readAll();
//    Publisher readPublisher(int id);
//    void updatePublisher(Publisher updatePublisher);
//    void deletePublisher(int publisher);

    private static final String INSERT_PUBLISHER_SQL =
            "insert into publisher (name, street, city, state, postal_code, phone, email) values (?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_PUBLISHER_SQL =
            "select * from publisher where publisher_id = ?";

    private static final String SELECT_ALL_PUBLISHER_SQL =
            "select * from publisher";

    private static final String DELETE_PUBLISHER_SQL =
            "delete from publisher where publisher_id = ?";

    private static final String UPDATE_PUBLISHER_SQL =
            "update publisher set name = ?, street = ?, city = ?, state = ?, postal_code = ?, phone = ?, email = ? where publisher_id = ?";


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PublisherDaoJdbc(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Publisher createPublisher(Publisher publisher) {

        jdbcTemplate.update(INSERT_PUBLISHER_SQL,

                publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),
                publisher.getPostal_code(),
                publisher.getPhone(),
                publisher.getEmail());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        publisher.setPublisher_id(id);

        return publisher;
    }

    @Override
    public List<Publisher> readAll() {
        return jdbcTemplate.query(SELECT_ALL_PUBLISHER_SQL, this::mapRowToPublisher);
    }

    @Override
    public Publisher readPublisher(int id) {
        try {

            return jdbcTemplate.queryForObject(SELECT_PUBLISHER_SQL, this::mapRowToPublisher, id);

        } catch (EmptyResultDataAccessException e) {
            // if nothing is returned just catch the exception and return null
            System.out.println("no publisher found with id " + id);
            return null;
        }
    }

    @Override
    public void updatePublisher(Publisher updatePublisher) {
        jdbcTemplate.update(UPDATE_PUBLISHER_SQL,
                updatePublisher.getName(),
                updatePublisher.getStreet(),
                updatePublisher.getCity(),
                updatePublisher.getState(),
                updatePublisher.getPostal_code(),
                updatePublisher.getPhone(),
                updatePublisher.getEmail(),
                updatePublisher.getPublisher_id());
    }

    @Override
    public void deletePublisher(int publisher) {
        jdbcTemplate.update(DELETE_PUBLISHER_SQL, publisher);
    }


    private Publisher mapRowToPublisher(ResultSet rs, int rowNum) throws SQLException {
        Publisher publisher = new Publisher();
        publisher.setCity(rs.getString("city"));
        publisher.setName(rs.getString("name"));
        publisher.setPhone(rs.getString("phone"));
        publisher.setState(rs.getString("state"));
        publisher.setEmail(rs.getString("email"));
        publisher.setPostal_code(rs.getString("postal_code"));
        publisher.setPublisher_id(rs.getInt("publisher_id"));
        publisher.setStreet(rs.getString("street"));

        return publisher;
    }
}
