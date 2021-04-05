package Capstone.DanieleTengaU1Capstone.dao;

import Capstone.DanieleTengaU1Capstone.model.Games;
import Capstone.DanieleTengaU1Capstone.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class InvoiceJdbcTemplateImpl implements InvoiceDao{
    //create
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_INVOICE_SQL =

            "insert into invoice (name, street, city, state, zipcode, item_type,item_id, unit_price, quantity, subtotal, tax, processing_fee, total) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    @Autowired
    public InvoiceJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Invoice addInvoice(Invoice invoice) {
        jdbcTemplate.update(
                INSERT_INVOICE_SQL,
                invoice.getName(),
                invoice.getStreet(),
                invoice.getCity(),
                invoice.getState(),
                invoice.getZipcode(),
                invoice.getItem_type(),
                invoice.getItem_id(),
                invoice.getUnit_price(),
                invoice.getQuantity(),
                invoice.getSubtotal(),
                invoice.getTax(),
                invoice.getProcessing_fee(),
                invoice.getTotal());


        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        invoice.setInvoice_id(id);

        return invoice;
    }
    private Invoice mapRowToInvoice(ResultSet rs, int rowNum) throws SQLException {

        Invoice invoice = new Invoice();
        invoice.setInvoice_id(rs.getInt("invoice_id"));
        invoice.setStreet(rs.getString("street"));
        invoice.setCity(rs.getString("city"));
        invoice.setState(rs.getString("state"));
        invoice.setZipcode(rs.getString("zipcode"));
        invoice.setItem_type(rs.getString("item_type"));
        invoice.setItem_id(rs.getInt("item_id"));
        invoice.setUnit_price(rs.getBigDecimal("unit_price"));
        invoice.setQuantity(rs.getInt("quantity"));
        invoice.setSubtotal(rs.getBigDecimal("subtotal"));
        invoice.setTax(rs.getBigDecimal("tax"));
        invoice.setProcessing_fee(rs.getBigDecimal("processing_fee"));
        invoice.setTotal(rs.getBigDecimal("total"));

        return invoice;
    }
}
