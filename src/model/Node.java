package model;

public class Node {
	
	private String name;
	private PathList paths;
	
	public Node(String name) {
		this.name = name;
		paths = new PathList();
	}
	
	public Node(String name, Path path) {
		this.name = name;
		paths = new PathList();
		paths.add(path);
	}
	
	public String getName () {
		return name;
	}
	
	public PathList getPaths () {
		return paths;
	}
	
	public void addPath (Path path) {
		paths.add(path);
	}
	
	public boolean hasPathTo(String nodeName) {
		for (Path path: paths.getPaths()) {
			if (nodeName.equals(path.getTo())) {
				return true;
			}
		}
		return false;
	}

}
