import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph {

    int numberOfVertices;
    int numberOfEdges = 0;
    int[][] g;

    public Graph(int n) {
        if (n < 0)
            throw new IllegalArgumentException("number of vertices must be positive");
        g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = 0;
            }
        }
        numberOfVertices = n;

    }
    public Graph(int[][] graph, int i) {
        g  = graph.clone();
        numberOfVertices = i;
    }

    public void addEdge(int from, int to,int weight) {
        if (from < 0 && from > numberOfVertices)
            throw new IllegalArgumentException("number must be in valid range (from vertex):" + from);
        if (to < 0 && to > numberOfVertices)
            throw new IllegalArgumentException("number must be in valid range (to vertex):" + to);

        g[from][to] = weight;
        g[to][from] = weight;
        numberOfEdges++;
    }


    public boolean isEdge(int v, int w) {
        if (v < 0 && v > numberOfVertices)
            throw new IllegalArgumentException("number must be in valid range (v vertex):" + v);
        if (w < 0 && w > numberOfVertices)
            throw new IllegalArgumentException("number must be in valid range (w vertex):" + w);
        if (g[v][w] != 0)
            return true;
        return false;
    }

    public int getE() {
        return numberOfEdges;
    }

    public int getV() {
        return numberOfVertices;
    }

    public PriorityQueue<Node> adjacent(int v) {
        if (v < 0 && v > numberOfVertices)
            throw new IllegalArgumentException("number must be in valid range (v vertex):" + v);
        PriorityQueue<Node> adjacentList = new PriorityQueue<>();
        for (int i = 0; i < numberOfVertices; i++) {
            if (g[v][i] != 0){
                int distance = g[v][i];
                Node adj = new Node(v,i,distance);
                adjacentList.add(adj);
            }
        }

        return adjacentList;
    }

    public int[] dijkstra(int src) {
        PriorityQueue<Node> pqueue = new PriorityQueue<Node>();
        Set<Integer> visited = new HashSet<Integer>();
        int shortest_distance[] = new int[getV()];

        for (int i = 0; i < numberOfVertices; i++)
            shortest_distance[i] = Integer.MAX_VALUE;

        shortest_distance[src] = 0; //src to src
        visited.add(src);
        for (Node n : this.adjacent(src)) { //for started vertex
            pqueue.add(n);
        }
        while (visited.size() != numberOfVertices) {

            int u ;
            // u is removed from PriorityQueue and has min distance
            if(pqueue.peek().getFrom()==src ){
                int dist_src = pqueue.peek().getDist();
                u = pqueue.remove().getTo();
                shortest_distance[u]=dist_src;
            }else {
                u = pqueue.remove().getTo();
            }
            // add node to finalized list (visited)
            visited.add(u);

            int edgeDistance;
            int newDistance ;
            for (Node n : this.adjacent(u)) { //for started vertex
                if (!visited.contains(n.getTo())) {
                    edgeDistance = n.getDist();

                    newDistance = shortest_distance[u] + edgeDistance;

                    // compare distances
                    if (newDistance < shortest_distance[n.getTo()])
                        shortest_distance[n.getTo()] = newDistance;

                    // Add the current vertex to the PriorityQueue
                    pqueue.add(new Node(n.getFrom(),n.getTo(), shortest_distance[n.getTo()]));
                }
            }
        }

        return shortest_distance;





    }
}