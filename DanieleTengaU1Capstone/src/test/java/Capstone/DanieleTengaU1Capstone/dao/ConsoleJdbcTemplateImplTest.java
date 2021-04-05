package Capstone.DanieleTengaU1Capstone.dao;

import Capstone.DanieleTengaU1Capstone.model.Consoles;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Console;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleJdbcTemplateImplTest {

    @Autowired
    ConsolesDao consolesDao;

    private Consoles console;

    @Before
    public void setUp() throws Exception {
        clearDatabase();
        setUpTestObjects();
    }
    public void clearDatabase() {
        List<Consoles> console = consolesDao.getAllConsoles();
        for (Consoles it : console) {
            consolesDao.deleteConsole(it.getConsole_id());
        }

    }

    public void setUpTestObjects() {
        console = new Consoles();

        console.setQuantity(10);
        console.setPrice(new BigDecimal(10.00));
        console.setManufacturer("brandais");
        console.setProcessor("processing");
        console.setModel("bubble");
        console.setMemory_amount("10.00");

        console = consolesDao.addConsole(console);

    }
    //create
    //retrieve
    //update
    //delete
    //retrieve by manufacturer
    @Test
    public void shouldAddAndGetConsole() {
        console = consolesDao.addConsole(console);

        Consoles consoles = consolesDao.getConsole(console.getConsole_id());
        assertEquals(console,console);
    }

    @Test
    public void shouldDeleteConsole() {
        console = consolesDao.addConsole(console);

        consolesDao.deleteConsole(console.getConsole_id());
        Consoles consoles = consolesDao.getConsole(console.getConsole_id());
        assertNull(consoles);
    }


    @Test
    public void shouldUpdateConsole() {

        console = consolesDao.addConsole(console);

        console.setQuantity(10);
        console.setManufacturer("brandais");
        console.setProcessor("processing");
        console.setModel("bubble");
        console.setPrice(new BigDecimal("12.00"));
        console.setMemory_amount("10.00");

        consolesDao.updateConsole(console);

        Consoles consoles = consolesDao.getConsole(console.getConsole_id());
        assertEquals(consoles,console);
    }

    @Test
    public void shouldGetAllConsole() {

        console = consolesDao.addConsole(console);

        console = new Consoles();
        console.setQuantity(10);
        console.setPrice(new BigDecimal(10.0));
        console.setManufacturer("brandais");
        console.setProcessor("processing");
        console.setModel("bubble");
        console.setMemory_amount("10.00");

        List<Consoles> cList = consolesDao.getAllConsoles();
        assertEquals(2, cList.size());
    }

    @Test
    public void shouldGetConsoleByManufacturer() {

        console = consolesDao.addConsole(console);

        Consoles console2 = new Consoles();

        console2.setQuantity(10);
        console2.setPrice(new BigDecimal(10.0));
        console2.setManufacturer("braisen");
        console2.setProcessor("processing");
        console2.setModel("bubble");
        console2.setMemory_amount("10.00");

        console2 = consolesDao.addConsole(console2);

        List<Consoles> cList = consolesDao.getConsoleByManufacturer("braisen");
        assertEquals(1,cList.size());
    }

}