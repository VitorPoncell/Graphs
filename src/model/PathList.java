package model;
import java.util.ArrayList;
import java.util.List;

public class PathList {
	
	private List<Path> paths;
	
	public PathList () {
		paths = new ArrayList<Path>();
	}
	
	public void add (Path path) {
		paths.add(path);
	}
	
	public List<Path> getPaths(){
		return paths;
	}
	
	public Path path (String to) {
		for (Path path : paths) {
			if (path.getTo().equals(to)) {
				return path;
			}
		}
		return null;
	}

}
