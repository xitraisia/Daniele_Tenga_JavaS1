package Capstone.DanieleTengaU1Capstone.dao;

import Capstone.DanieleTengaU1Capstone.model.Consoles;
import Capstone.DanieleTengaU1Capstone.model.Games;
import Capstone.DanieleTengaU1Capstone.model.Tshirt;
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
public class TshirtsJdbcTemplateImplTest {
//create
    //retrieve
    //update
    //delete
    //retrieve tshirts by color
    //retrieve by size

    @Autowired
    TshirtsDao tshirtsDao;

    private Tshirt tshirt;

    @Before
    public void setUp() throws Exception {
        clearDatabase();
        setUpTestObjects();
    }
    public void clearDatabase() {
        List<Tshirt> tshirts = tshirtsDao.getAllTshirts();
        for (Tshirt it : tshirts) {
            tshirtsDao.deleteTshirt(it.getTshirt_Id());
        }

    }
    public void setUpTestObjects() {
        tshirt = new Tshirt();

        tshirt.setQuantity(10);
        tshirt.setPrice(new BigDecimal("10.00"));
        tshirt.setColor("blue");
        tshirt.setDescription("blah blah blah");
        tshirt.setColor("Orange");
        tshirt.setSize("large");

    }
    @Test
    public void shouldAddAndGetTshirt() {

        tshirt = tshirtsDao.addTshirt(tshirt);

        Tshirt tshirt1 = tshirtsDao.getTshirt(tshirt.getTshirt_Id());
        assertEquals(tshirt1,tshirt);
    }
    @Test
    public void shouldDeleteTshirt() {

        tshirt = tshirtsDao.addTshirt(tshirt);

        tshirtsDao.deleteTshirt(tshirt.getTshirt_Id());
        Tshirt tshirt1 = tshirtsDao.getTshirt(tshirt.getTshirt_Id());
        assertNull(tshirt1);
    }
    @Test
    public void shouldUpdateTshirt() {

        tshirt = tshirtsDao.addTshirt(tshirt);

        tshirt.setQuantity(10);
        tshirt.setPrice(new BigDecimal("10.00"));
        tshirt.setSize("large");
        tshirt.setDescription("blah blah blah");
        tshirt.setColor("amber");

        tshirtsDao.updateTshirt(tshirt);

        Tshirt tshirt1 = tshirtsDao.getTshirt(tshirt.getTshirt_Id());
        assertEquals(tshirt,tshirt1);
    }
    @Test
    public void shouldGetAllTshirt() {

        tshirt = tshirtsDao.addTshirt(tshirt);

        Tshirt tshirt2 = new Tshirt();

        tshirt2.setQuantity(10);
        tshirt2.setPrice(new BigDecimal("10.00"));
        tshirt2.setSize("large");
        tshirt2.setDescription("blah blah blah");
        tshirt2.setColor("amber");

        tshirt2 = tshirtsDao.addTshirt(tshirt2);

        List<Tshirt> tList = tshirtsDao.getAllTshirts();
        assertEquals(2, tList.size());
    }

    @Test
    public void shouldGetTshirtByColor() {

        tshirt = tshirtsDao.addTshirt(tshirt);


        List<Tshirt> tList = tshirtsDao.getTshirtBycolor("peach");
        assertEquals(0,tList.size());

        List<Tshirt> sList = tshirtsDao.getTshirtBycolor("blue");
        assertEquals(0,sList.size());
    }
    @Test
    public void shouldGetTshirtBySize() {

        tshirt = tshirtsDao.addTshirt(tshirt);

        List<Tshirt> tList = tshirtsDao.getTshirtBySize("large");//your object which was declared above has to have this size.
        assertEquals(1,tList.size());

        List<Tshirt> sList = tshirtsDao.getTshirtBySize("medium");//your object which was declared above has to have this size, if not then we are expecting a zero.
        assertEquals(0,sList.size());

    }
}