package Capstone.DanieleTengaU1Capstone.dao;

import Capstone.DanieleTengaU1Capstone.model.Consoles;

import java.util.List;

public interface ConsolesDao {
    //create
    //retrieve
    //update
    //delete

    Consoles addConsole(Consoles consoles);
    Consoles getConsole(int id);
    List<Consoles> getAllConsoles();
    void updateConsole(Consoles consoles);
    void deleteConsole(int id);
    List<Consoles> getConsoleByManufacturer(String manufacturerId);


}
