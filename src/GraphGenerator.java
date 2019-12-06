import model.MyGraph;
import model.Node;
import model.Path;

public class GraphGenerator {
		
	public static MyGraph generate(int size) {
		MyGraph graph = new MyGraph();
		for (int i = 0; i < size; i++) {
			Node node = new Node("" + (i+1));
			if (!graph.contains(node.getName())) {
				graph.add(node);
			}else {
				node = graph.node(node.getName());
			}
			int conections = (int) Math.floor(Math.random()*size/2) + 1	;
			for (int j = 0; j < conections;j++) {
				String to = "" + (int)(Math.floor(Math.random()*size)+1) ;
				if (node.getName().equals(to)) {
					continue;
				}
				if (!graph.contains(to)) {
					graph.add(new Node(to));
				}
				String distance = (int)Math.floor((Math.random()*10 + 1)) + "";
				String time = (int)Math.floor((Math.random()*10 + 1)) + "";
				Path path = new Path(distance, time, to);
				if (!node.hasPathTo(path.getTo())) {
					node.addPath(path);
					graph.node(to).addPath(new Path(distance, time, node.getName()));
				}
			}
		}
		return graph;
	}

}
