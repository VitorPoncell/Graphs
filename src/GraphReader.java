import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import model.MyGraph;
import model.Node;
import model.Path;

public class GraphReader {
	
	public static final String GRAPH_0 = "/res/graph0.txt";

	private static MyGraph graph;

	public static MyGraph read(String filePath) {
		graph = new MyGraph();
		for (String line : readLines(filePath)) {
			parseLine(line);
		}
		return graph;
	}

	private static void parseLine(String line) {
		String[] values = line.split(";");
		boolean node1PathAdded = false;
		boolean node2PathAdded = false;

		if (values.length == 4) {
			for (Node node : graph.list()) {
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
				graph.add(new Node(values[0], new Path(values[1], values[2], values[3])));
			}
			if (!node2PathAdded) {
				graph.add(new Node(values[3], new Path(values[1], values[2], values[0])));
			}
		} else {
			System.out.println("Error parssing line: " + line);
		}

	}

	private static List<String> readLines(String filePath) {
		try {
			return Files.readAllLines(Paths.get(System.getProperty("user.dir") + filePath), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

}
