package Capstone.DanieleTengaU1Capstone.dao;

import Capstone.DanieleTengaU1Capstone.model.Consoles;
import Capstone.DanieleTengaU1Capstone.model.Games;
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
public class GamesJdbcTemplateImplTest {
    //create
    //retrieve
    //update
    //delete
    //retrieve games by studio
    //retrieve by esrb rating
    //retrieve by title

    @Autowired
    GamesDao gamesDao;

    private Games games;

    @Before
    public void setUp() throws Exception {
        clearDatabase();
        setUpTestObjects();
    }
    public void clearDatabase() {
        List<Games> games = gamesDao.getAllGame();
        for (Games it : games) {
            gamesDao.deleteConsole(it.getGame_id());
        }

    }
    public void setUpTestObjects() {
        games = new Games();

        games.setQuantity(10);
        games.setPrice(new BigDecimal("10.00"));
        games.setStudio("cocoli");
        games.setDescription("blah blah blah");
        games.setTitle("Optimus");
        games.setEsrb_rating("R");
        games.setGame_id(games.getGame_id());

    }
    @Test
    public void shouldAddAndGetGames() {
        games = gamesDao.addGames(games);

        Games games1 = gamesDao.getGame(games.getGame_id());
        assertEquals(games1,games);
    }
    @Test
    public void shouldDeleteGames() {
        games = gamesDao.addGames(games);

        gamesDao.deleteConsole(games.getGame_id());
        Games games1 = gamesDao.getGame(games.getGame_id());
        assertNull(games1);
    }
    @Test
    public void shouldUpdateGame() {

        games = gamesDao.addGames(games);

        games.setQuantity(10);
        games.setPrice(new BigDecimal("10.00"));
        games.setStudio("cocoli");
        games.setDescription("blah blah blah");
        games.setTitle("Optimus");
        games.setEsrb_rating("R");

        gamesDao.updateGame(games);

        Games games1 = gamesDao.getGame(games.getGame_id());
        assertEquals(games1,games);
    }
    @Test
    public void shouldGetAllGames() {

        games = gamesDao.addGames(games);

        games.setQuantity(10);
        games.setPrice(new BigDecimal("10.00"));
        games.setStudio("cocoli");
        games.setDescription("blah blah blah");
        games.setTitle("Optimus");
        games.setEsrb_rating("R");

        List<Games> gList = gamesDao.getAllGame();
        assertEquals(1, gList.size());
    }

    @Test
    public void shouldGetGameByStudio() {

        games = gamesDao.addGames(games);

        Games games2 = new Games();

        games2.setQuantity(10);
        games2.setPrice(new BigDecimal("10.00"));
        games2.setStudio(games.getStudio());
        games2.setDescription("blah blah blah");
        games2.setTitle("Optimus");
        games2.setEsrb_rating("R");

        games2 = gamesDao.addGames(games2);

        List<Games> gList = gamesDao.getGamesByStudio("Cladinstine");
        assertEquals(1,gList.size());
    }
    @Test
    public void shouldGetGameByEsrbRating() {

        games = gamesDao.addGames(games);

        Games games2 = new Games();

        games2.setQuantity(10);
        games2.setPrice(new BigDecimal("10.00"));
        games2.setStudio("cladestine");
        games2.setDescription("blah blah blah");
        games2.setTitle("Optimus");
        games2.setEsrb_rating(games.getEsrb_rating());

        games2 = gamesDao.addGames(games2);

        List<Games> gList = gamesDao.getGamesByEsrb("R");
        assertEquals(2,gList.size());
    }
    @Test
    public void shouldGetGameByTitle() {

        games = gamesDao.addGames(games);

        Games games2 = new Games();

        games2.setQuantity(10);
        games2.setPrice(new BigDecimal("10.00"));
        games2.setStudio(games.getStudio());
        games2.setDescription("blah blah blah");
        games2.setTitle(games2.getTitle());
        games2.setEsrb_rating("R");

        games2 = gamesDao.addGames(games2);

        List<Games> gList = gamesDao.getGamesByTitle("Optimus");
        assertEquals(1,gList.size());
    }
}