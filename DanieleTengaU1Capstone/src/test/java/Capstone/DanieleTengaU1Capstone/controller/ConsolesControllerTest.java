package Capstone.DanieleTengaU1Capstone.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import Capstone.DanieleTengaU1Capstone.dao.ConsolesDao;
import Capstone.DanieleTengaU1Capstone.model.Consoles;
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
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ConsolesController.class)

public class ConsolesControllerTest {

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
    public void getConsoleByIdShouldReturnConsoleWithIdJson() throws Exception {
        Consoles inputConsole = new Consoles();

        inputConsole.setPrice(new BigDecimal("2.00"));
        inputConsole.setQuantity(3);
        inputConsole.setManufacturer("coaco");
        inputConsole.setModel("croati");
        inputConsole.setProcessor("processing");
        inputConsole.setMemory_amount("12.wr1");
        inputConsole.setConsole_id(2);

        Consoles outputConsole = new Consoles();

        outputConsole.setPrice(new BigDecimal("2.00"));
        outputConsole.setQuantity(3);
        outputConsole.setManufacturer("coaco");
        outputConsole.setModel("croati");
        outputConsole.setProcessor("processing");
        outputConsole.setMemory_amount("12.wr1");
        outputConsole.setConsole_id(2);

        String outputJson = mapper.writeValueAsString(outputConsole);

        when(gameStoreService.getConsolebyId(inputConsole.getConsole_id())).thenReturn(outputConsole);

        this.mockMvc.perform(get("/console/" + outputConsole.getConsole_id()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }


    @Test
    public void createConsoleShouldReturnCreatedConsole() throws Exception {

        Consoles inputConsole = new Consoles();

        inputConsole.setPrice(new BigDecimal("2.00"));
        inputConsole.setQuantity(3);
        inputConsole.setManufacturer("coaco");
        inputConsole.setModel("croati");
        inputConsole.setProcessor("processing");
        inputConsole.setMemory_amount("12.wr1");
        inputConsole.setConsole_id(2);

        //Object to JSON in String
        String inputJson = mapper.writeValueAsString(inputConsole);

        Consoles outputConsole = new Consoles();

        outputConsole.setPrice(new BigDecimal("2.00"));
        outputConsole.setQuantity(3);
        outputConsole.setManufacturer("coaco");
        outputConsole.setModel("croati");
        outputConsole.setProcessor("processing");
        outputConsole.setMemory_amount("12.wr1");
        outputConsole.setConsole_id(2);

        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(outputConsole);

        when(gameStoreService.saveConsoles(inputConsole)).thenReturn(outputConsole);

        this.mockMvc.perform(post("/console")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getConsoleShouldReturnConsoleByManufacturer() throws Exception {

        Consoles inputConsole = new Consoles();

        inputConsole.setPrice(new BigDecimal("2.00"));
        inputConsole.setQuantity(3);
        inputConsole.setManufacturer("coaco");
        inputConsole.setModel("croati");
        inputConsole.setProcessor("processing");
        inputConsole.setMemory_amount("12.wr1");
        inputConsole.setConsole_id(2);

        Consoles outputConsole = new Consoles();

        outputConsole.setPrice(new BigDecimal("2.00"));
        outputConsole.setQuantity(3);
        outputConsole.setManufacturer("coaco");
        outputConsole.setModel("croati");
        outputConsole.setProcessor("processing");
        outputConsole.setMemory_amount("12.wr1");
        outputConsole.setConsole_id(3);


        List<Consoles> consolesList = new ArrayList<>();
        consolesList.add(inputConsole);
        consolesList.add(outputConsole);

        String outputJson = mapper.writeValueAsString(consolesList);

        when(gameStoreService.getConsoleByManufacturer(inputConsole.getManufacturer())).thenReturn(consolesList);

        this.mockMvc.perform(get("/console/m/" + inputConsole.getManufacturer()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void updateConsoleShouldReturnAnUpdatedConsole() throws Exception {

        Consoles inputConsole = new Consoles();

        inputConsole.setPrice(new BigDecimal("2.00"));
        inputConsole.setQuantity(3);
        inputConsole.setManufacturer("coaco");
        inputConsole.setModel("croati");
        inputConsole.setProcessor("processing");
        inputConsole.setMemory_amount("12.wr1");
        inputConsole.setConsole_id(2);

        //these will be the same
        String inputJson = mapper.writeValueAsString(inputConsole);
        String outputJson = mapper.writeValueAsString(inputConsole);

        this.mockMvc.perform(put("/console/" + inputConsole.getConsole_id())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }


    @Test
    public void deleteConsoleIsOkNoContentReturned() throws Exception {

        //can't mock the call to delete. it returns void
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/console/8"))
                .andDo(print()).andExpect(status().isNoContent())
                .andExpect(content().string(""));
    }
}