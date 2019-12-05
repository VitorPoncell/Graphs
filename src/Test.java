import model.MyGraph;

public class Test {

	private static final int size = 16;
	private static int interactions = 0;
	
	public static void execute() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			MyGraph graph = GraphGenerator.generate(size);

			BruteForce bruteForce = new BruteForce("1", ""+size, graph);
			bruteForce.getLowerJumps();
			interactions += bruteForce.interactions;
			System.out.println(bruteForce.interactions);
		}
		long end = System.currentTimeMillis();
		System.out.println("Media: " + interactions/100);
		System.out.println("Tempo: " + (end-start));
	}

}
