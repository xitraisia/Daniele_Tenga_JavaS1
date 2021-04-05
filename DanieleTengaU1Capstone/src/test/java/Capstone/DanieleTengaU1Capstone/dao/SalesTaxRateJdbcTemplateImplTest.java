package Capstone.DanieleTengaU1Capstone.dao;

import Capstone.DanieleTengaU1Capstone.model.ProcessingFee;
import Capstone.DanieleTengaU1Capstone.model.SalesTaxRate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SalesTaxRateJdbcTemplateImplTest {

    @Autowired
    SalesTaxRateDao salesTaxRateDao;

    private SalesTaxRate salesTaxRate;

    @Before
    public void setUp() throws Exception {
        setUpTestObjects();
    }
    public void setUpTestObjects() {
        salesTaxRate = new SalesTaxRate();

        salesTaxRate.setRate(new BigDecimal("10.00"));
        salesTaxRate.setState("Alabama");
    }
    @Test
    public void shouldAddSalesTax() {
        salesTaxRate = salesTaxRateDao.getSalesTaxRate(salesTaxRate.getState());
    }
}