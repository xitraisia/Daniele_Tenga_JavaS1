package Capstone.DanieleTengaU1Capstone.dao;

import Capstone.DanieleTengaU1Capstone.model.SalesTaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SalesTaxRateJdbcTemplateImpl implements SalesTaxRateDao {

    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_SALES_TAX_RATE_SQL =
            "select * from sales_tax_rate where state = ?";

    @Autowired
    public SalesTaxRateJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    @Transactional
    public SalesTaxRate getSalesTaxRate(String id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_SALES_TAX_RATE_SQL, this::mapRowToTaxes, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this album id, return null
            return null;
        }
    }

    private SalesTaxRate mapRowToTaxes(ResultSet rs, int rowNum) throws SQLException {
        SalesTaxRate salesRate = new SalesTaxRate();
        salesRate.setRate(rs.getBigDecimal("rate"));
        salesRate.setState(rs.getString("state"));

        return salesRate;
    }

}
