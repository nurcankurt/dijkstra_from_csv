public class Node implements Comparable<Node> {

    private int from;
    private int to;
    private int dist;

    public Node(int from, int to, int dist) {
        this.from = from;
        this.to = to;
        this.dist = dist;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        if (this.dist < o.dist)
            return -1;
        if (this.dist > o.dist)
            return 1;
        return 0;

    }
}