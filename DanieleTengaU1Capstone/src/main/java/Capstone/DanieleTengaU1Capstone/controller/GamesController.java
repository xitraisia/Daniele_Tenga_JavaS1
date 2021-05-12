package Capstone.DanieleTengaU1Capstone.controller;

import Capstone.DanieleTengaU1Capstone.exception.NotFoundException;
import Capstone.DanieleTengaU1Capstone.model.Consoles;
import Capstone.DanieleTengaU1Capstone.model.Games;
import Capstone.DanieleTengaU1Capstone.service.GameStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GamesController {
    //create
    //retrieve
    //update
    //delete
    //retrieve games by studio
    //retrieve by esrb rating
    //retrieve by title

    @Autowired
    GameStoreService gameStoreService;

    @RequestMapping(value = "/game", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Games createGame(@RequestBody @Valid Games games){
        return gameStoreService.saveGames(games);
    }

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGameAllGames() {
        return gameStoreService.getAllGames();
    }

    @RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Games getGame(@PathVariable int id) {
        Games games = gameStoreService.getGamebyId(id);
        if (games == null)
            throw new NotFoundException("game could not be retrieved for id " + id);
        return games;
    }
    @RequestMapping(value = "/game/{id}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateGame(@PathVariable int id, @RequestBody Games games){
        gameStoreService.updateGames(games);
    }

    @RequestMapping(value = "/game/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int id) {
        gameStoreService.removeGame(id);
    }

    @RequestMapping(value = "/game/studio/{studioId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGameByStudio(@PathVariable String studioId) {
        return gameStoreService.getGameByStudio(studioId);
    }

    @RequestMapping(value = "/game/esrb/{esrbId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGameByEsrb(@PathVariable String esrbId) {
        return gameStoreService.getGameByEsrb(esrbId);
    }

    @RequestMapping(value = "/game/title/{titleId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Games> getGameByTitle(@PathVariable String titleId) {
        return gameStoreService.getGameByTitle(titleId);
    }
}
