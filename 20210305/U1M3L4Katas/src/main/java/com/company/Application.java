package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {

        System.out.println("Current saved animals file:");
        try {
            Pets.readPetsFromFile(); //I am being warned about an exception that is found in the pets file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //i have to catch or throw an exception to remove these red lines??? In this case it was a File not found exception

        int petIndex = Pets.choosePet();

        String chosenPet = Pets.retrievePet(petIndex);

        Pets.writePetToFile(chosenPet); //adding throw io exception in this code fixed this line

        System.out.println("New saved animals file:");
        Pets.readPetsFromFile(); //and this line... i am still not clear on this because whgat just happened??

    }
}
