package Capstone.DanieleTengaU1Capstone.dao;

import Capstone.DanieleTengaU1Capstone.model.Dog;

public interface DogDao {
    void deleteDog(int id);
    void updateDog(Dog dog);
}
