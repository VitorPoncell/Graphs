package model;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.io.DOTExporter;
import org.jgrapht.io.ExportException;
import org.jgrapht.io.GraphExporter;

public class MyGraph {
	
	private List<Node> graph;
	
	public MyGraph() {
		graph = new ArrayList<Node>();
	}
	
	public void add(Node node) {
		graph.add(node);
	}
	
	public List<Node> list(){
		return graph;
	}
	
	public void print() {
		for (Node node : graph) {
			System.out.println("Name: " + node.getName());
			for (Path path : node.getPaths().getPaths()) {
				System.out.println(path.toString());
			}
			System.out.println("\n==========================================\n");
		}
	}
	
	public void printMatrix() {
		String[][] matrix = createMatrix();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (j == 0) System.out.print("|");
				if (i == j) {
					System.out.print("**|");
				} else {
					System.out.print(String.format("%02d", Integer.valueOf(matrix[i][j])) + "|");

				}
			}
			System.out.println();
		}
		
	}
	
	public void drawGraph() {
		StringBuffer graphViz = new StringBuffer();
		graphViz.append("copy line below to: https://dreampuf.github.io/GraphvizOnline\n");
		graphViz.append("strict digraph G {");
		for (Node node : graph) {
			graphViz.append(node.getName()+";");
		}
		
		for (Node node : graph) {
			for (Path path : node.getPaths().getPaths()) {
				graphViz.append(node.getName() + " -> " + path.getTo() + " [label=\"d:" + path.getDistance() + " t:" + path.getTime()+"\"];");
			}
		}
		graphViz.append("}");
		try {
			FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir") + "/res/generatedGraph.txt");
			outputStream.write(graphViz.toString().getBytes());
			outputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String[][] createMatrix(){
		int size = graph.size();
		String[][] matrix = new String[size+1][size+1];
		for (int i = 0;i<size;i++) {
			matrix[0][i+1] = graph.get(i).getName();
			matrix[i+1][0] = graph.get(i).getName();
		}
		
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				matrix[i][j] = graph.get(i-1).hasPathTo(graph.get(j-1).getName()) ? "1" : "0";
			}
		}
		
		return matrix;
	}
	
	public Node node(String name) {
		for (Node node : graph) {
			if (node.getName().equals(name)) return node;
		}
		return null;
	}
	
	public boolean contains(String nodeName) {
		for (Node node : graph) {
			if(node.getName().equals(nodeName)) return true;
		}
		return false;
	}
}
