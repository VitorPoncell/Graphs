import model.MyGraph;

public class Test {

	private static final int size = 18;
	
	public static void execute() {
		long time = 0;
		for (int i = 0; i < 100; i++) {
			MyGraph graph = GraphGenerator.generate(size);

			BruteForce bruteForce = new BruteForce("1", ""+size, graph);
			long start = System.currentTimeMillis();
			bruteForce.getLowerJumps();
			long end = System.currentTimeMillis();
			time += end - start;
		}
		System.out.println("Tempo total: " + (time) + " ms");
	}

}
