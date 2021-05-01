package Capstone.DanieleTengaU1Capstone.controller;

import Capstone.DanieleTengaU1Capstone.model.Consoles;
import Capstone.DanieleTengaU1Capstone.model.Games;
import Capstone.DanieleTengaU1Capstone.service.GameStoreService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GamesController.class)
public class GamesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DataSource dataSource;

    @MockBean
    private GameStoreService gameStoreService;

    private ObjectMapper mapper = new ObjectMapper();


    @Before
    public void setUp() {

    }

    @Test
    public void getGamesByIdShouldReturnGameWithIdJson() throws Exception {

        Games inputGame = new Games();

        inputGame.setTitle("brandi");
        inputGame.setEsrb_rating("R");
        inputGame.setDescription("blah blah blah");
        inputGame.setPrice(new BigDecimal("12.00"));
        inputGame.setStudio("studio");
        inputGame.setQuantity(3);

        Games outputGame = new Games();

        outputGame.setTitle("brandi");
        outputGame.setEsrb_rating("R");
        outputGame.setDescription("blah blah blah");
        outputGame.setPrice(new BigDecimal("12.00"));
        outputGame.setStudio("studio");
        outputGame.setQuantity(3);
        outputGame.setGame_id(1);

        String outputJson = mapper.writeValueAsString(outputGame);

        when(gameStoreService.getGamebyId(1)).thenReturn(outputGame);

        this.mockMvc.perform(get("/game/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getGameThatDoesNotExistReturns404() throws Exception {

        int idForConsoleThatDoesNotExist = 100;

        when(gameStoreService.getGamebyId(idForConsoleThatDoesNotExist)).thenReturn(null);

        this.mockMvc.perform(get("/game/" + idForConsoleThatDoesNotExist))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void createGameShouldReturnCreatedGame() throws Exception {

        Games inputGame = new Games();

        inputGame.setGame_id(1);
        inputGame.setTitle("brandi");
        inputGame.setEsrb_rating("R");
        inputGame.setDescription("blah blah blah");
        inputGame.setPrice(new BigDecimal("12.00"));
        inputGame.setStudio("studio");
        inputGame.setQuantity(3);

        //Object to JSON in String
        String inputJson = mapper.writeValueAsString(inputGame);

        Games outputGame = new Games();

        outputGame.setTitle("brandi");
        outputGame.setEsrb_rating("R");
        outputGame.setDescription("blah blah blah");
        outputGame.setPrice(new BigDecimal("12.00"));
        outputGame.setStudio("studio");
        outputGame.setQuantity(3);

        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(outputGame);
        System.out.println("---- input and output ----");
        System.out.println(inputGame);
        System.out.println("---");
        System.out.println(outputGame);
        System.out.println("---");
        System.out.println(inputJson);
        System.out.println("***");

        when(gameStoreService.saveGames(inputGame)).thenReturn(outputGame);

        this.mockMvc.perform(post("/game")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getGameShouldReturnGameByStudio() throws Exception {

        Games inputGame = new Games();

        inputGame.setGame_id(1);
        inputGame.setTitle("brandi");
        inputGame.setEsrb_rating("R");
        inputGame.setDescription("blah blah blah");
        inputGame.setPrice(new BigDecimal("12.00"));
        inputGame.setStudio("studio");
        inputGame.setQuantity(3);

        Games outputGame = new Games();

        outputGame.setTitle("brandi");
        outputGame.setEsrb_rating("R");
        outputGame.setDescription("blah blah blah");
        outputGame.setPrice(new BigDecimal("12.00"));
        outputGame.setStudio("studio");
        outputGame.setQuantity(3);

        List<Games> gamesList = new ArrayList<>();
        gamesList.add(inputGame);
        gamesList.add(outputGame);

        String outputJson = mapper.writeValueAsString(gamesList);

        when(gameStoreService.getGameByStudio(inputGame.getStudio())).thenReturn(gamesList);

        this.mockMvc.perform(get("/game/studio/" + outputGame.getStudio()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getGameShouldReturnGameByEsrb() throws Exception {

        Games inputGame = new Games();

        inputGame.setGame_id(1);
        inputGame.setTitle("brandi");
        inputGame.setEsrb_rating("R");
        inputGame.setDescription("blah blah blah");
        inputGame.setPrice(new BigDecimal("12.00"));
        inputGame.setStudio("studio");
        inputGame.setQuantity(3);

        Games outputGame = new Games();

        outputGame.setTitle("brandi");
        outputGame.setEsrb_rating("R");
        outputGame.setDescription("blah blah blah");
        outputGame.setPrice(new BigDecimal("12.00"));
        outputGame.setStudio("studio");
        outputGame.setQuantity(3);


        List<Games> gamesList = new ArrayList<>();
        gamesList.add(inputGame);
        gamesList.add(outputGame);

        String outputJson = mapper.writeValueAsString(gamesList);

        when(gameStoreService.getGameByEsrb(inputGame.getEsrb_rating())).thenReturn(gamesList);

        this.mockMvc.perform(get("/game/esrb/" + outputGame.getEsrb_rating()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getGameShouldReturnGameByTitle() throws Exception {

        Games inputGame = new Games();

        inputGame.setGame_id(1);
        inputGame.setTitle("brandi");
        inputGame.setEsrb_rating("R");
        inputGame.setDescription("blah blah blah");
        inputGame.setPrice(new BigDecimal("12.00"));
        inputGame.setStudio("studio");
        inputGame.setQuantity(3);

        Games outputGame = new Games();

        outputGame.setTitle("brandi");
        outputGame.setEsrb_rating("R");
        outputGame.setDescription("blah blah blah");
        outputGame.setPrice(new BigDecimal("12.00"));
        outputGame.setStudio("studio");
        outputGame.setQuantity(3);

        List<Games> gamesList = new ArrayList<>();
        gamesList.add(inputGame);
        gamesList.add(outputGame);

        String outputJson = mapper.writeValueAsString(gamesList);

        when(gameStoreService.getGameByTitle(inputGame.getTitle())).thenReturn(gamesList);

        this.mockMvc.perform(get("/game/title/" + outputGame.getTitle()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void updateGameShouldReturnAnUpdatedGame() throws Exception {

        Games inputGame = new Games();

        inputGame.setGame_id(1);
        inputGame.setTitle("brandi");
        inputGame.setEsrb_rating("R");
        inputGame.setDescription("blah blah blah");
        inputGame.setPrice(new BigDecimal("12.00"));
        inputGame.setStudio("studio");
        inputGame.setQuantity(3);

        //these will be the same
        String inputJson = mapper.writeValueAsString(inputGame);
        String outputJson = mapper.writeValueAsString(inputGame);

        this.mockMvc.perform(put("/game/" + inputGame.getGame_id())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }


    @Test
    public void deleteGameIsOkNoContentReturned() throws Exception {

        //can't mock the call to delete. it returns void
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/game/8"))
                .andDo(print()).andExpect(status().isNoContent())
                .andExpect(content().string(""));
    }

}