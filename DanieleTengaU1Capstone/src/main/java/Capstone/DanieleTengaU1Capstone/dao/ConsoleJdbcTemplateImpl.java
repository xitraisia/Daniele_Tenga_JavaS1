package Capstone.DanieleTengaU1Capstone.dao;

import Capstone.DanieleTengaU1Capstone.model.Consoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ConsoleJdbcTemplateImpl implements ConsolesDao{
    //create
    //retrieve
    //update
    //delete
    //retrieve by manufacturer
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_CONSOLE_SQL =
            // private int console_id;
            //    private String model;
            //    private String manufacturer;
            //    private String memory_amount;
            //    private String processor;
            //    private BigDecimal price;
            //    private int quantity;
            "insert into console (model, manufacturer, memory_amount, processor, price, quantity) values (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_CONSOLE_SQL =
            "select * from console where console_id = ?";

    private static final String SELECT_ALL_CONSOLES_SQL =
            "select * from console";

    private static final String UPDATE_CONSOLE_SQL =
            "update console set model = ?, manufacturer = ?, memory_amount = ?, processor = ?, price = ?, quantity = ? where console_id = ?";

    private static final String DELETE_CONSOLE =
            "delete from console where console_id = ?";
    private static final String SELECT_CONSOLE_BY_MANUFACTURER_SQL =
            "select * from console where manufacturer = ?";

    @Autowired
    public ConsoleJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    @Transactional
    public Consoles addConsole(Consoles consoles) {
        // private int console_id;
        //    private String model;
        //    private String manufacturer;
        //    private String memory_amount;
        //    private String processor;
        //    private BigDecimal price;
        //    private int quantity;
        jdbcTemplate.update(
                INSERT_CONSOLE_SQL,
                consoles.getModel(),
                consoles.getManufacturer(),
                consoles.getMemory_amount(),
                consoles.getProcessor(),
                consoles.getPrice(),
                consoles.getQuantity());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        consoles.setConsole_id(id);

        return consoles;
    }

    @Override
    public Consoles getConsole(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_CONSOLE_SQL, this::mapRowToConsole, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this album id, return null
            return null;
        }
    }

    @Override
    public List<Consoles> getAllConsoles() {
        return jdbcTemplate.query(SELECT_ALL_CONSOLES_SQL, this::mapRowToConsole);
    }

    @Override
    public void updateConsole(Consoles consoles) {
        jdbcTemplate.update(
                UPDATE_CONSOLE_SQL,
                consoles.getModel(),
                consoles.getManufacturer(),
                consoles.getMemory_amount(),
                consoles.getProcessor(),
                consoles.getPrice(),
                consoles.getQuantity(),
                consoles.getConsole_id());
    }

    @Override
    public void deleteConsole(int id) {
        jdbcTemplate.update(DELETE_CONSOLE, id);
    }

    @Override
    public List<Consoles> getConsoleByManufacturer(String manufacturerId) {
        return jdbcTemplate.query(SELECT_CONSOLE_BY_MANUFACTURER_SQL, this::mapRowToConsole,manufacturerId);
    }

    private Consoles mapRowToConsole(ResultSet rs, int rowNum) throws SQLException {
        Consoles consoles = new Consoles();
        consoles.setConsole_id(rs.getInt("console_id"));
        consoles.setModel(rs.getString("model"));
        consoles.setManufacturer(rs.getString("manufacturer"));
        consoles.setMemory_amount(rs.getString("memory_amount"));
        consoles.setProcessor(rs.getString("processor"));
        consoles.setPrice(rs.getBigDecimal("price"));
        consoles.setQuantity(rs.getInt("quantity"));

        return consoles;
    }

}
