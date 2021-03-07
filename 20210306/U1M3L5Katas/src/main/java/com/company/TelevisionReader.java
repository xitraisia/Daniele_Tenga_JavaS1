package com.company;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TelevisionReader {

    public static void main(String[] args) {

        // CODE GOES HERE
        try { //put the code in a try {} to offset exception
            //we stored the csv in a list from our television class now object in the interface list
            List<Television>Tvs = FileIO.getTelevisions("televisions.csv");

            Tvs
                    .stream() //call our stream
                    .filter(tv -> tv.getScreenSize() > 60) //we then filter our list
                    .forEach(tv -> {
                        System.out.println("These are all the tvs with screens bigger than 60 inch " +tv.getBrand() +" " +tv.getModel());
                    });

            Map<String, List<Television>> groupedTvs = //we created a map to group tv brands
                    Tvs
                    .stream()        // for below with the T or t this is a random variable that we use to assign it to the tv so we can access certain functions
                    .collect(Collectors.groupingBy(T -> T.getBrand())); //this is a filter but for maps
                    for (String TvBrand : groupedTvs.keySet()) { //we did a condensed 4 loop that iterated through the brands
                        System.out.println("This is a Tv Brand: " + TvBrand);
                    }

                    //Average tv screen size
             //we created a map to group tv brands
                    double averageScreenSize = Tvs //taking this list and storing it in a new variable
                            .stream()
                            .mapToInt(t -> t.getScreenSize()) // turns every tv screen to an int
                            .average() //get the average
                            .getAsDouble();
                    System.out.println("This is the average of Tv screen size " + averageScreenSize);
            //We are finding the max number of tvs
                    int largestScreenSize = Tvs
                            .stream()
                            .mapToInt(tvs -> tvs.getScreenSize())
                            .max()
                            .getAsInt();
                    System.out.println("The largest tv screen is " + largestScreenSize);
        }catch (FileNotFoundException e){
            System.out.println("File not found. " + e.getMessage());
        }



        //I have to group everything by brand and tv and screensize;
        //buuttt I already created a list above. I have to look at this over the weekend.
    }
}
