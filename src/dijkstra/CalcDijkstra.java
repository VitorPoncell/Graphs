import java.util.ArrayList;
import java.util.List;

public class CalcDijkstra {

    private List<Node> visitedNodes;
    private List<Node> unvisitedNodes;

    public CalcDijkstra(Node source) {
        source.setDistance(0);
        visitedNodes = new ArrayList<>();
        unvisitedNodes = new ArrayList<>();
        unvisitedNodes.add(source);
    }

    public String getShortestPathTo(String name) {
        if (visitedNodes.size() == 0) {
            calculate();
        }
        return visitedNodes.get(name);
    }
    
    private void calculate() {
        while (unvisitedNodes.size() != 0) {
            Node curretNode = getShortestDistanceNode();
            unvisitedNodes.remove(curretNode);
            for (Path path : curretNode.getPaths()) {
                if (!visitedNodes.contains(path)) {
                    calculateShortestDistance();
                    unvisitedNodes.add(path);
                }
            }
            visitedNodes.add(curretNode);
        }
    }

    private Node getShortestDistanceNode() {
        Node shortestDistanceNode;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : unvisitedNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                shortestDistanceNode = node;
            }
        }
        return shortestDistanceNode;
    }

    private void calculateShortestDistance(Node node, int cost, Node source) {
        int sourceCost = source.getDistance();
        if (sourceCost + cost < node.getDistance()) {
            node.setDistance(sourceCost + cost);
            List<Node> shortestPath = source.getShortestPath();
            shortestPath.add(source);
            node.setShortestPath(shortestPath);
        }
    }

}
