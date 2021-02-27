# 1.2.7 Katas

## Katas

## Introduction

In these katas, you will work with interfaces and their properties as well as getters and setters by building a vehicle simulation.

## Requirements for all Katas

- Add the code necessary to the `starter-code` project `U1M2L7Katas`.

- All classes should part of the `com.company` package.

- All interfaces should be part of the `com.company.interfaces` package.

- All classes should have a no-args, or the default constructor.

- You can test by uncommenting the code in `AllKatasTest` and running it.

## Kata 1: Vehicle

1. Create a `Vehicle` interface. It should define the following methods:

      - `void drive` which takes in an integer argument representing `miles`.

      - `void displayMilesTraveled` which takes in no arguments.

2.  Create a `Car` class. It should implement `Vehicle` and have the following properties and associated getters/setters:

      - String `make`

      - String `model`

      - int `milesTraveled`

3. Create a `Sedan` class. It should extend `Car` and have the following properties and associated getters/setters:

      - int `numDoors`
      
      - boolean `poweredWindows`

4.  Create an `Accord` class. It should extend `Sedan` and have the following properties and associated getters/setters:

      - String `year`

      - Engine `engine`

      - Transmission `transmission`

---

© 2021 Trilogy Education Services, a 2U, Inc. brand. All Rights Reserved.
