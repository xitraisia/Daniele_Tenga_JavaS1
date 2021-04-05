package Capstone.DanieleTengaU1Capstone.dao;

import Capstone.DanieleTengaU1Capstone.model.Games;
import Capstone.DanieleTengaU1Capstone.model.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceJdbcTemplateImplTest {
//create

    @Autowired
    InvoiceDao invoiceDao;

    private Invoice invoice;

    @Before
    public void setUp() throws Exception {
        setUpTestObjects();
    }

    public void setUpTestObjects() {
        invoice = new Invoice();

        invoice.setTotal(new BigDecimal("10.00"));
        invoice.setProcessing_fee(new BigDecimal("12.00"));
        invoice.setUnit_price(new BigDecimal("13.00"));
        invoice.setTax(new BigDecimal(".05"));
        invoice.setSubtotal(new BigDecimal("5.00"));
        invoice.setQuantity(2);
        invoice.setZipcode("30311");
        invoice.setState("ga");
        invoice.setStreet("1540 catrina dr sw ");
        invoice.setItem_type("groak");
        invoice.setName("arty");
        invoice.setCity("bockly");
    }
    @Test
    public void shouldAddInvoice() {
        invoice = invoiceDao.addInvoice(invoice);

    }
}