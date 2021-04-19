package Capstone.DanieleTengaU1Capstone.dao;

import Capstone.DanieleTengaU1Capstone.model.Consoles;
import Capstone.DanieleTengaU1Capstone.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Capstone.DanieleTengaU1Capstone.model.Dog;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DogDaoJdbcTemplateImpl implements DogDao{

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_DOG_SQL =
            "insert into dog (name, kennelNum) values (?, ?)";


    private static final String UPDATE_DOG_SQL =
            "update dog set name = ?, kennelNum = ? where id = ?";

    private static final String DELETE_DOG =
            "delete from dog where id = ?";

    @Autowired
    public DogDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public void updateDog(Dog dog) {
        jdbcTemplate.update(
                UPDATE_DOG_SQL,
                dog.getName(),
                dog.getKennelNum(),
                dog.getId());
    }

    @Override
    public void deleteDog(int id) {
        jdbcTemplate.update(DELETE_DOG, id);
    }
}
