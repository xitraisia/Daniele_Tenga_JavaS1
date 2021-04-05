package Capstone.DanieleTengaU1Capstone.dao;

import Capstone.DanieleTengaU1Capstone.model.Games;
import Capstone.DanieleTengaU1Capstone.model.Tshirt;

import java.util.List;

public interface TshirtsDao {
    //create
    //retrieve
    //update
    //delete
    //retrieve tshirts by color
    //retrieve by size

    Tshirt addTshirt(Tshirt tshirt);
    Tshirt getTshirt(int id);
    List<Tshirt> getAllTshirts();
    void updateTshirt(Tshirt tshirt);
    void deleteTshirt(int id);
    List<Tshirt> getTshirtBycolor(String colorId);
    List<Tshirt> getTshirtBySize(String sizeId);


}
