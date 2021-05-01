package Capstone.DanieleTengaU1Capstone.service;

import Capstone.DanieleTengaU1Capstone.dao.*;
import Capstone.DanieleTengaU1Capstone.model.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class GameStoreServiceTest {

    ConsolesDao consolesDao;
    GamesDao gamesDao;
    InvoiceDao invoiceDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;
    TshirtsDao tshirtsDao;
    GameStoreService gameStoreService;

    @Before
    public void setUp() throws Exception {

        setUpConsoleDaoMock();
        setUpGameDaoMock();
        setUpProcessingFeeDaoMock();
        setUpSalesTaxRateDaoMock();
        setUpTshirtsDaoMock();

        gameStoreService = new GameStoreService(consolesDao,gamesDao,invoiceDao,processingFeeDao,salesTaxRateDao,tshirtsDao);
    }
    private void setUpConsoleDaoMock() {

        consolesDao = mock(ConsoleJdbcTemplateImpl.class);

        Consoles console = new Consoles();

        console.setConsole_id(1);
        console.setPrice(new BigDecimal("2.00"));
        console.setQuantity(3);
        console.setManufacturer("coaco");
        console.setModel("croati");
        console.setProcessor("processing");
        console.setMemory_amount("12.wr1");

        Consoles console2 = new Consoles();

        console2.setPrice(new BigDecimal("2.00"));
        console2.setQuantity(3);
        console2.setManufacturer("coaco");
        console2.setModel("croati");
        console2.setProcessor("processing");
        console2.setMemory_amount("12.wr1");

        List<Consoles> consolesList = new ArrayList<>();
        consolesList.add(console);

        doReturn(console).when(consolesDao).addConsole(console2);
        doReturn(console).when(consolesDao).getConsole(1);
        doReturn(consolesList).when(consolesDao).getAllConsoles();
    }
    private void setUpGameDaoMock() {

        gamesDao = mock(GamesJdbcTemplateImpl.class);

        Games games = new Games();

        games.setGame_id(2);
        games.setPrice(new BigDecimal("2.00"));
        games.setQuantity(3);
        games.setStudio("coaco");
        games.setDescription("blah blah blah");
        games.setTitle("adalin");
        games.setEsrb_rating("12.wr1");

        Games games2 = new Games();

        games2.setPrice(new BigDecimal("2.00"));
        games2.setQuantity(3);
        games2.setStudio("coaco");
        games2.setDescription("blah blah blah");
        games2.setTitle("adalin");
        games2.setEsrb_rating("12.wr1");

        List<Games> gamesList = new ArrayList<>();
        gamesList.add(games);

        doReturn(games).when(gamesDao).addGames(games2);
        doReturn(games).when(gamesDao).getGame(2);
        doReturn(gamesList).when(gamesDao).getAllGame();
        doReturn(gamesList).when(gamesDao).getGamesByStudio("coaco");
        doReturn(gamesList).when(gamesDao).getGamesByTitle("adalin");
        doReturn(gamesList).when(gamesDao).getGamesByEsrb("12.wr1");
    }

    private void setUpProcessingFeeDaoMock() {

        processingFeeDao = mock(ProcessingFeeJdbcTemplateImpl.class);

        ProcessingFee processingFee = new ProcessingFee();

        processingFee.setFee(new BigDecimal("2.00"));
        processingFee.setProduct_type("tshirt");

        ProcessingFee processingFee2 = new ProcessingFee();

        processingFee2.setFee(new BigDecimal("2.00"));
        processingFee2.setProduct_type("tshirt");

        List<ProcessingFee> processingFeeList = new ArrayList<>();
        processingFeeList.add(processingFee);

        doReturn(processingFee).when(processingFeeDao).getProcessingFee("tshirt");
    }
    private void setUpSalesTaxRateDaoMock() {

        salesTaxRateDao = mock(SalesTaxRateJdbcTemplateImpl.class);

        SalesTaxRate salesTaxRate = new SalesTaxRate();

        salesTaxRate.setRate(new BigDecimal("12.00"));
        salesTaxRate.setState("ga");

        SalesTaxRate salesTaxRate2 = new SalesTaxRate();

        salesTaxRate2.setRate(new BigDecimal("12.00"));
        salesTaxRate2.setState("ga");

        List<SalesTaxRate> salesTaxRateList = new ArrayList<>();
        salesTaxRateList.add(salesTaxRate);

        doReturn(salesTaxRate).when(salesTaxRateDao).getSalesTaxRate("ga");
    }
    private void setUpTshirtsDaoMock() {

        tshirtsDao = mock(TshirtsJdbcTemplateImpl.class);

        Tshirt tshirt = new Tshirt();

        tshirt.setTshirt_Id(1);
        tshirt.setPrice(new BigDecimal("2.00"));
        tshirt.setQuantity(3);
        tshirt.setColor("blue");
        tshirt.setDescription("blah blah blah");
        tshirt.setSize("medium");

        Tshirt tshirt2 = new Tshirt();

        tshirt2.setPrice(new BigDecimal("2.00"));
        tshirt2.setQuantity(3);
        tshirt2.setColor("blue");
        tshirt2.setDescription("blah blah blah");
        tshirt2.setSize("medium");

        List<Tshirt> tshirtList = new ArrayList<>();
        tshirtList.add(tshirt);

        doReturn(tshirt).when(tshirtsDao).addTshirt(tshirt);
        doReturn(tshirt).when(tshirtsDao).getTshirt(1);
        doReturn(tshirtList).when(tshirtsDao).getAllTshirts();
    }
    @Test
    public void shouldSaveAndFindConsole() {
        Consoles console = new Consoles();

        console.setPrice(new BigDecimal("2.00"));
        console.setQuantity(3);
        console.setManufacturer("coaco");
        console.setModel("croati");
        console.setProcessor("processing");
        console.setMemory_amount("12.wr1");
        console.setConsole_id(1);
        gameStoreService.saveConsoles(console);

        Consoles fromService  = gameStoreService.getConsolebyId(1);
        assertEquals(console,fromService);
    }

    @Test
    public void shouldSaveAndFindGame() {

        Games games = new Games();

        games.setGame_id(2);
        games.setPrice(new BigDecimal("2.00"));
        games.setQuantity(3);
        games.setStudio("coaco");
        games.setDescription("blah blah blah");
        games.setTitle("adalin");
        games.setEsrb_rating("12.wr1");
        gameStoreService.saveGames(games);

        Games games2 = gameStoreService.getGamebyId(2);
        assertEquals(games,games2);
    }

    @Test
    public void shouldSaveTshirtAndFindTshirt() {
        Tshirt tshirt = new Tshirt();

        tshirt.setTshirt_Id(1);
        tshirt.setSize("medium");
        tshirt.setColor("blue");
        tshirt.setPrice(new BigDecimal("2.00"));
        tshirt.setQuantity(3);
        tshirt.setDescription("blah blah blah");
        gameStoreService.saveTshirt(tshirt);

        Tshirt fromService  = gameStoreService.getTshirtbyId(1);
        assertEquals(tshirt,fromService);
    }

}