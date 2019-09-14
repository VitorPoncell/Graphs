import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphGenerator {
	
	public static final String GRAPH_0 = "/res/graph0.txt";

	private List<Node> nodes;

	public GraphGenerator() {
	}

	public void genGraph(String filePath) {
		nodes = new ArrayList<Node>();
		for (String line : readLines(filePath)) {
			parseLine(line);
		}
	}

	public void parseLine(String line) {
		String[] values = line.split(";");
		boolean node1PathAdded = false;
		boolean node2PathAdded = false;

		if (values.length == 4) {
			for (Node node : nodes) {
				if (node.getName().equals(values[0])) {
					node.addPath(new Path(values[1], values[2], values[3]));
					node1PathAdded = true;
				}
				if (node.getName().equals(values[3])) {
					node.addPath(new Path(values[1], values[2], values[0]));
					node2PathAdded = true;
				}
			}
			if (!node1PathAdded) {
				nodes.add(new Node(values[0], new Path(values[1], values[2], values[3])));
			}
			if (!node2PathAdded) {
				nodes.add(new Node(values[3], new Path(values[1], values[2], values[0])));
			}
		} else {
			System.out.println("Error parssing line: " + line);
		}

	}

	public void printGraph() {
		for (Node node : nodes) {
			System.out.println("Name: " + node.getName());
			for (Path path : node.getPaths()) {
				System.out.println(path.toString());
			}
			System.out.println("\n==========================================\n");
		}
	}

	private List<String> readLines(String filePath) {
		try {
			return Files.readAllLines(Paths.get(System.getProperty("user.dir") + filePath), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
				
		}
	}

}
