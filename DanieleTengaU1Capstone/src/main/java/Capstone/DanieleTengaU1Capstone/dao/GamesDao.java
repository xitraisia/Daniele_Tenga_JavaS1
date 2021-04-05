package Capstone.DanieleTengaU1Capstone.dao;

import Capstone.DanieleTengaU1Capstone.model.Consoles;
import Capstone.DanieleTengaU1Capstone.model.Games;

import java.util.List;

public interface GamesDao {
    //create
    //retrieve
    //update
    //delete
    //retrieve games by studio
    //retrieve by esrb rating
    //retrieve by title

    Games addGames(Games games);
    Games getGame(int id);
    List<Games> getAllGame();
    void updateGame(Games games);
    void deleteConsole(int id);
    List<Games> getGamesByStudio(String studioId);
    List<Games> getGamesByEsrb(String esrbId);
    List<Games> getGamesByTitle(String titleId);

}
