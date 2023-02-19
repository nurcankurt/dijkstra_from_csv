import java.io.*;
import java.util.HashMap;

public class ReadFile {
    public static Graph buildGraph(HashMap<String, Integer> cities) {
        Graph g=null;

        File file = new File("cities.txt");
        FileReader fileReader;
        BufferedReader bufferedReader;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String strLine;
            int value = 0;
            while ((strLine = bufferedReader.readLine()) != null) {
                cities.put(strLine,value);
                value++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


       File file2 = new File("map.csv");
        try {
            fileReader = new FileReader(file2);
            bufferedReader = new BufferedReader(fileReader);
            String strLine;
            int vertices = cities.size();
            g = new Graph(vertices);
            while ((strLine = bufferedReader.readLine()) != null) {
                String[] edges = strLine.split(",");
                int from = cities.get(edges[0]);
                int to = cities.get(edges[1]);
                int weight = Integer.parseInt(edges[2]);
                g.addEdge(from, to,weight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return g;
    }
}
