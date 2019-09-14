public class Path {
	
	private final String[] path = new String[3];
	
	public Path(String distance, String time, String to) {
		path[0] = distance;
		path[1] = time;
		path[2] = to;
	}
	
	public String[] getPath() {
		return path;
	}
	
	public String getTo() {
		return path[2];
	}
	
	public int getDistance() {
		return Integer.parseInt(path[0]);
	}
	
	public int getTime() {
		return Integer.parseInt(path[1]);
	}
	
	public String toString() {
		return "Distance: " + path[0] + " Time: " + path[1] + " To: " + path[2];
	}

}
