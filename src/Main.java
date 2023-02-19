import java.util.Formatter;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Integer> cities = new HashMap<>();
        HashMap<Integer,String> reversedCities = new HashMap<>();
        Graph graph = ReadFile.buildGraph(cities);

        for (String key : cities.keySet()){
            reversedCities.put(cities.get(key), key);
        }

        String source = "San Rafael";
        int[] distance =graph.dijkstra(cities.get(source));
        Formatter fmt = new Formatter();
        fmt.format("%8s %18s %20s\n", "Source", "Node", "Distance");
        for (int i = 0; i< distance.length;i++){
            fmt.format("%s %17s %14s\n", source,reversedCities.get(i),distance[i]);
        }
        System.out.println(fmt);


    }
}

