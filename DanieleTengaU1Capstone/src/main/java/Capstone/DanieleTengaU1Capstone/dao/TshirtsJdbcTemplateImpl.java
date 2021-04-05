package Capstone.DanieleTengaU1Capstone.dao;

import Capstone.DanieleTengaU1Capstone.model.Games;
import Capstone.DanieleTengaU1Capstone.model.Tshirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TshirtsJdbcTemplateImpl implements TshirtsDao{

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_T_SHIRT_SQL =
//private int tshirt_Id;
//    private String size;
//    private String color;
//    private String description;
//    private BigDecimal price;
//    private int quantity;

            "insert into t_shirt (size, color, description, price, quantity) values (?, ?, ?, ?, ?)";

    private static final String SELECT_T_SHIRT_SQL =
            "select * from t_shirt where t_shirt_id = ?";

    private static final String SELECT_ALL_T_SHIRT_SQL =
            "select * from t_shirt";

    private static final String UPDATE_T_SHIRT_SQL =
            "update t_shirt set size = ?, color = ?, description = ?, price = ?, quantity = ? where t_shirt_id = ?";

    private static final String DELETE_T_SHIRT =
            "delete from t_shirt where t_shirt_id = ?";

    private static final String SELECT_T_SHIRT_BY_COLOR_SQL =
            "select * from t_shirt where color = ?";

    private static final String SELECT_T_SHIRT_BY_SIZE_SQL =
            "select * from t_shirt where size = ?";



    @Autowired
    public TshirtsJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    @Transactional
    public Tshirt addTshirt(Tshirt tshirt) {

        jdbcTemplate.update(
                INSERT_T_SHIRT_SQL,
                tshirt.getSize(),
                tshirt.getColor(),
                tshirt.getDescription(),
                tshirt.getPrice(),
                tshirt.getQuantity());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        tshirt.setTshirt_Id(id);

        return tshirt;
    }

    @Override
    public Tshirt getTshirt(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_T_SHIRT_SQL, this::mapRowToTshirt, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this album id, return null
            return null;
        }
    }

    @Override
    public List<Tshirt> getAllTshirts() {
        return jdbcTemplate.query(SELECT_ALL_T_SHIRT_SQL, this::mapRowToTshirt);
    }

    @Override
    public void updateTshirt(Tshirt tshirt) {

        jdbcTemplate.update(
                UPDATE_T_SHIRT_SQL,
                tshirt.getSize(),
                tshirt.getColor(),
                tshirt.getDescription(),
                tshirt.getPrice(),
                tshirt.getQuantity(),
                tshirt.getTshirt_Id());
    }

    @Override
    public void deleteTshirt(int id) {
        jdbcTemplate.update(DELETE_T_SHIRT, id);
    }

    @Override
    public List<Tshirt> getTshirtBycolor(String colorId) {
        return jdbcTemplate.query(SELECT_T_SHIRT_BY_COLOR_SQL, this::mapRowToTshirt,colorId);
    }

    @Override
    public List<Tshirt> getTshirtBySize(String sizeId) {
        return jdbcTemplate.query(SELECT_T_SHIRT_BY_SIZE_SQL, this::mapRowToTshirt,sizeId);
    }

    private Tshirt mapRowToTshirt(ResultSet rs, int rowNum) throws SQLException {

        Tshirt tshirt = new Tshirt();
        tshirt.setTshirt_Id(rs.getInt("t_shirt_id"));
        tshirt.setSize(rs.getString("size"));
        tshirt.setColor(rs.getString("color"));
        tshirt.setDescription(rs.getString("description"));
        tshirt.setPrice(rs.getBigDecimal("price"));
        tshirt.setQuantity(rs.getInt("quantity"));

        return tshirt;
    }
}
