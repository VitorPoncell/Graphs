import java.util.ArrayList;
import java.util.List;

public class DijkstraNode extends Node {

    private Integer distance = Integer.MAX_VALUE;
    private List<Node> shortestPath;

    public DijkstraNode(String name) {
        this.name = name;
        paths = new ArrayList<Path>();
        shortestPath = new ArrayList<>();
    }

    public void setDistance(int value) {
        distance = value;
    }

    public int getDistance() {
        return distance;
    }

    public void setShortestPath(List<Node> value) {
        shortestPath = value;
    }

    public List<Node> getShortestPath() {
        return shortestPath != null? new ArrayList<>() : shortestPath;
    }

}
