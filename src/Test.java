import model.MyGraph;

public class Test {

	private static final int size = 6;
	
	public static void execute() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			MyGraph graph = GraphGenerator.generate(size);

			BruteForce bruteForce = new BruteForce("1", ""+size, graph);
			bruteForce.getLowerJumps();
		}
		long end = System.currentTimeMillis();
		System.out.println("Tempo total: " + (end-start) + " ms");
	}

}
