import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class LargestCity {
    public static void main(String[] args) {

    City newYork = new City("New York",8654321); //city variable
    City losAngeles = new City("Los Angeles", 4563218);
    City chicago = new City("Chicago", 2716520);
    City denver = new City("Denver",704621);
    City desMoines = new City("Des Moines", 217521);
    City atlanta = new City("Atlanta",486213);


        Map<String, City> cityMap = new HashMap<>();

        cityMap.put("New York",newYork);
        cityMap.put("California", losAngeles);
        cityMap.put("Chicago", chicago);
        cityMap.put("Colorado", denver);
        cityMap.put("Iowa", desMoines);
        cityMap.put("Georgia", atlanta);

        System.out.println(cityMap.get("New York"));
        System.out.println(cityMap.get("California"));
        System.out.println(cityMap.get("Chicago"));
        System.out.println(cityMap.get("Colorado"));
        System.out.println(cityMap.get("Iowa"));
        System.out.println(cityMap.get("Georgia"));


    }
    //Gotta re-watch class video. You missed something. Not understanding
//    public Map<String,City> filterByPopulation(Map<String,City> populationFilter, int population){
//        Map<String, City> newMap = new HashMap<>();
//
//        Set<String> keys = populationFilter.keySet();
//        for (String key: keys){
//            City city = populationFilter.get(key);
//            if (city.getPopulation() > population){
//                newMap.put(key,city);
//            }
//        }return newMap;
//    }
//}
