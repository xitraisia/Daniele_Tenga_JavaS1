package Capstone.DanieleTengaU1Capstone.controller;

import Capstone.DanieleTengaU1Capstone.exception.NotFoundException;
import Capstone.DanieleTengaU1Capstone.model.Consoles;
import Capstone.DanieleTengaU1Capstone.service.GameStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Console;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class ConsolesController {
    //create  post
    //retrieve  get
    //update put
    //delete delete
    //retrieve by manufacturer

    @Autowired
    GameStoreService gameStoreService;

    @RequestMapping(value = "/console", method = RequestMethod.POST)
    @PostMapping("/console")
    @ResponseStatus(HttpStatus.CREATED)
    public Consoles createConsole(@RequestBody @Valid Consoles console){
        return gameStoreService.saveConsoles(console);
    }

    @RequestMapping(value = "/console", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Consoles> getAllConsole() {
        return gameStoreService.getAllConsoles();
    }

    @RequestMapping(value = "/console/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Consoles getConsole(@PathVariable int id) {
       Consoles consoles = gameStoreService.getConsolebyId(id);
        if (consoles == null)
            throw new NotFoundException("Console could not be retrieved for id " + id);
        return consoles;
    }

    @RequestMapping(value = "/console/{id}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateConsole(@PathVariable int id, @RequestBody Consoles consoles){
        gameStoreService.updateConsole(consoles);
    }

    @RequestMapping(value = "/console/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {
        gameStoreService.removeConsole(id);
    }

    @RequestMapping(value = "/console/m/{manufacturerId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Consoles> getConsoleByManufacturer(@PathVariable String manufacturerId) {
        return gameStoreService.getConsoleByManufacturer(manufacturerId);
    }
}
