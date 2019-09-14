import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private String name;
	private List<Path> paths;
	
	public Node(String name) {
		this.name = name;
		paths = new ArrayList<Path>();
	}
	
	public Node(String name, Path path) {
		this.name = name;
		paths = new ArrayList<Path>();
		paths.add(path);
	}
	
	public String getName () {
		return name;
	}
	
	public List<Path> getPaths () {
		return paths;
	}
	
	public void addPath (Path path) {
		paths.add(path);
	}

}
