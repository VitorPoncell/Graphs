package model;
public class Result {
	
	public String path = "";
	public int distance = 0;
	public int time = 0;
	public int jumps = Integer.MAX_VALUE;
	
	public Result (String path, int distance, int time) {
		this.path = path;
		this.distance = distance;
		this.time = time;
		this.jumps = path.split("-").length-1;
	}
	
	public Result (String path, int distance, int time, int jumps) {
		this.path = path;
		this.distance = distance;
		this.time = time;
		this.jumps = jumps;
	}
	
	public void addNode(String name) {
		path += "-" + name;
		jumps++;
	}
	public String toString() {
		return "Path: " + path + " | Distance: " + distance + " | Time: " + time + " | Jumps: " + jumps;
	}
	
	public boolean contains(String nodeName) {
		return path.contains(nodeName);
	}

}
