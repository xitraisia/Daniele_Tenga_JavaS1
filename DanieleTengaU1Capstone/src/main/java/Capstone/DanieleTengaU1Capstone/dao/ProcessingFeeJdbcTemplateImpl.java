package Capstone.DanieleTengaU1Capstone.dao;

import Capstone.DanieleTengaU1Capstone.model.ProcessingFee;
import Capstone.DanieleTengaU1Capstone.model.SalesTaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ProcessingFeeJdbcTemplateImpl implements ProcessingFeeDao{

    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_PROCESSING_FEE_SQL =
            "select * from processing_fee where product_type = ?";

    @Autowired
    public ProcessingFeeJdbcTemplateImpl (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    @Transactional
    public ProcessingFee getProcessingFee(String id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_PROCESSING_FEE_SQL, this::mapRowToFee, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this album id, return null
            return null;
        }
    }

    private ProcessingFee mapRowToFee(ResultSet rs, int rowNum) throws SQLException {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProduct_type(rs.getString("product_type"));
        processingFee.setFee(rs.getBigDecimal("fee"));

        return processingFee;
    }
}
