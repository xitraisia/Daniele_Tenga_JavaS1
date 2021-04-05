package Capstone.DanieleTengaU1Capstone.dao;

import Capstone.DanieleTengaU1Capstone.model.Games;
import Capstone.DanieleTengaU1Capstone.model.ProcessingFee;
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
public class ProcessingFeeJdbcTemplateImplTest {

    @Autowired
    ProcessingFeeDao processingFeeDao;

    private ProcessingFee processingFee;

    @Before
    public void setUp() throws Exception {
        setUpTestObjects();
    }
    public void setUpTestObjects() {
        processingFee = new ProcessingFee();

        processingFee.setFee(new BigDecimal("10.00"));
        processingFee.setProduct_type("marbles");
    }
    @Test
    public void shouldAddProcessing() {
        processingFee = processingFeeDao.getProcessingFee(processingFee.getProduct_type());
    }
}