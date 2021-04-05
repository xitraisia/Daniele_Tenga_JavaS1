package Capstone.DanieleTengaU1Capstone.controller;

import Capstone.DanieleTengaU1Capstone.model.Consoles;
import Capstone.DanieleTengaU1Capstone.model.Games;
import Capstone.DanieleTengaU1Capstone.model.Tshirt;
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
@WebMvcTest(ConsolesController.class)
public class TshirtControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameStoreService gameStoreService;

    private ObjectMapper mapper = new ObjectMapper();


    @Before
    public void setUp() {

    }

    @Test
    public void getTshirtByIdShouldReturnTshirtWithIdJson() throws Exception {
        Tshirt inputTshirt = new Tshirt();

        inputTshirt.setPrice(new BigDecimal("2.00"));
        inputTshirt.setQuantity(3);
        inputTshirt.setColor("blue");
        inputTshirt.setSize("medium");
        inputTshirt.setDescription("processing");

        Tshirt outputTshirt = new Tshirt();

        outputTshirt.setPrice(new BigDecimal("2.00"));
        outputTshirt.setQuantity(3);
        outputTshirt.setColor("blue");
        outputTshirt.setSize("medium");
        outputTshirt.setDescription("processing");

        String outputJson = mapper.writeValueAsString(outputTshirt);

        when(gameStoreService.getTshirtbyId(inputTshirt.getTshirt_Id())).thenReturn(outputTshirt);

        this.mockMvc.perform(get("/tshirt/" + outputTshirt.getTshirt_Id()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getTshirtThatDoesNotExistReturns404() throws Exception {

        int idForConsoleThatDoesNotExist = 100;

        when(gameStoreService.getTshirtbyId(idForConsoleThatDoesNotExist)).thenReturn(null);

        this.mockMvc.perform(get("/tshirt/" + idForConsoleThatDoesNotExist))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void createTshirtShouldReturnCreatedTshirt() throws Exception {

        Tshirt inputTshirt = new Tshirt();

        inputTshirt.setPrice(new BigDecimal("2.00"));
        inputTshirt.setQuantity(3);
        inputTshirt.setColor("blue");
        inputTshirt.setSize("medium");
        inputTshirt.setDescription("processing");

        //Object to JSON in String
        String inputJson = mapper.writeValueAsString(inputTshirt);

        Tshirt outputTshirt = new Tshirt();

        outputTshirt.setPrice(new BigDecimal("2.00"));
        outputTshirt.setQuantity(3);
        outputTshirt.setColor("blue");
        outputTshirt.setSize("medium");
        outputTshirt.setDescription("processing");

        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(outputTshirt);

        when(gameStoreService.saveTshirt(inputTshirt)).thenReturn(outputTshirt);

        this.mockMvc.perform(post("/tshirt")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getTshirtShouldReturnTshirtByColor() throws Exception {

        Tshirt inputTshirt = new Tshirt();

        inputTshirt.setPrice(new BigDecimal("2.00"));
        inputTshirt.setQuantity(3);
        inputTshirt.setColor("blue");
        inputTshirt.setSize("medium");
        inputTshirt.setDescription("processing");

        Tshirt outputTshirt = new Tshirt();

        outputTshirt.setPrice(new BigDecimal("2.00"));
        outputTshirt.setQuantity(3);
        outputTshirt.setColor("blue");
        outputTshirt.setSize("medium");
        outputTshirt.setDescription("processing");

        List<Tshirt> tshirtList = new ArrayList<>();
        tshirtList.add(inputTshirt);
        tshirtList.add(outputTshirt);

        String outputJson = mapper.writeValueAsString(outputTshirt);

        when(gameStoreService.getTshirtByColor(inputTshirt.getColor())).thenReturn(tshirtList);

        this.mockMvc.perform(get("/tshirt/color/" + outputTshirt.getColor()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }
    @Test
    public void getTshirtShouldReturnTshirtBySize() throws Exception {

        Tshirt inputTshirt = new Tshirt();

        inputTshirt.setPrice(new BigDecimal("2.00"));
        inputTshirt.setQuantity(3);
        inputTshirt.setColor("blue");
        inputTshirt.setSize("medium");
        inputTshirt.setDescription("processing");

        Tshirt outputTshirt = new Tshirt();

        outputTshirt.setPrice(new BigDecimal("2.00"));
        outputTshirt.setQuantity(3);
        outputTshirt.setColor("blue");
        outputTshirt.setSize("medium");
        outputTshirt.setDescription("processing");

        List<Tshirt> tshirtList = new ArrayList<>();
        tshirtList.add(inputTshirt);
        tshirtList.add(outputTshirt);

        String outputJson = mapper.writeValueAsString(outputTshirt);

        when(gameStoreService.getTshirtBySize(inputTshirt.getSize())).thenReturn(tshirtList);

        this.mockMvc.perform(get("/tshirt/size/" + outputTshirt.getSize()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }


    @Test
    public void updateTshirtShouldReturnAnUpdatedTshirt() throws Exception {

        Tshirt inputTshirt = new Tshirt();

        inputTshirt.setPrice(new BigDecimal("2.00"));
        inputTshirt.setQuantity(3);
        inputTshirt.setColor("blue");
        inputTshirt.setSize("medium");
        inputTshirt.setDescription("processing");

        //these will be the same
        String inputJson = mapper.writeValueAsString(inputTshirt);
        String outputJson = mapper.writeValueAsString(inputTshirt);

        this.mockMvc.perform(put("/tshirt/" + inputTshirt.getTshirt_Id())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }


    @Test
    public void deleteTshirtIsOkNoContentReturned() throws Exception {

        //can't mock the call to delete. it returns void
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/tshirt/8"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}