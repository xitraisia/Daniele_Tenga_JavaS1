package Capstone.DanieleTengaU1Capstone.controller;

import Capstone.DanieleTengaU1Capstone.exception.NotFoundException;
import Capstone.DanieleTengaU1Capstone.model.Games;
import Capstone.DanieleTengaU1Capstone.model.Tshirt;
import Capstone.DanieleTengaU1Capstone.service.GameStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class TshirtController {
    //create
    //retrieve
    //update
    //delete
    //retrieve t-shirts by color
    //retrieve t-shirts by size

    @Autowired
    GameStoreService gameStoreService;

    @RequestMapping(value = "/tshirt", method = RequestMethod.POST)
    @PostMapping("/tshirt")
    @ResponseStatus(HttpStatus.CREATED)
    public Tshirt createTshirt(@RequestBody @Valid Tshirt tshirt){
        return gameStoreService.saveTshirt(tshirt);
    }

    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Tshirt getTshirt(@PathVariable int id) {
        Tshirt tshirt = gameStoreService.getTshirtbyId(id);
        if (tshirt == null)
            throw new NotFoundException("game could not be retrieved for id " + id);
        return tshirt;
    }

    @RequestMapping(value = "/tshirt/{id}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateTshirt(@PathVariable int id, @RequestBody Tshirt tshirt){
        gameStoreService.updateTshirt(tshirt);
    }

    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTshirt(@PathVariable int id) {
        gameStoreService.removeTshirt(id);
    }

    @RequestMapping(value = "/tshirt/color/{color}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> getTshirtByColor(@PathVariable String colorId) {
        return gameStoreService.getTshirtByColor(colorId);
    }

    @RequestMapping(value = "/tshirt/size/{size}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Tshirt> getTshirtBySize(@PathVariable String sizeId) {
        return gameStoreService.getTshirtBySize(sizeId);
    }
}
