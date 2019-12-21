import java.util.Scanner;

import model.MyGraph;

public class Main {

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int mode;
		
		do {
			System.out.println("\n0 executar Test.java | 1 executar grafo do arquivo | 2 executar com grafo randomico");
			mode = scanner.nextInt();
			
			switch (mode) {
			case 0:
				Test.execute();
				break;
			case 1:
				readGraph();
				break;
			case 2:
				randonGraph();
				break;					
			}
		} while (0 <= mode && mode <=2);
		
	}
	
	private static void readGraph() {
		MyGraph graph = GraphReader.read(GraphReader.GRAPH_0);
		BruteForce bruteForce = new BruteForce("1", "8", graph);
		showResults(graph, bruteForce);
	}
	
	private static void randonGraph() {
		MyGraph graph = GraphGenerator.generate(15);
		BruteForce bruteForce = new BruteForce("1", "8", graph);
		showResults(graph, bruteForce);
	}
	
	private static void showResults(MyGraph graph, BruteForce bruteForce) {
		System.out.println("Menos pulos: " + bruteForce.getLowerJumps());
		System.out.println("Menor distancia: " + bruteForce.getLowerDistance());
		System.out.println("Menor tempo: " + bruteForce.getLowerTime());
		System.out.println("Ate 10 de distancia: " + bruteForce.toMaxDistance(10));
		System.out.println("Ate 10 de tempo: " + bruteForce.toMaxTime(10));
		System.out.println("Acessar https://dreampuf.github.io/GraphvizOnline");
		System.out.println("E colar abaixo(tambem disponivel em res/generatedGraph.txt)");
		System.out.println(graph.drawGraph());
	}

}
