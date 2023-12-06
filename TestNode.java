package lab9;

import java.util.Arrays;
import java.util.List;

public class TestNode {
	public static void main(String[] args) {
		Node node = new Node();
		Integer[] data = { 7 };
		node.addAll(Arrays.asList(data));
//		for (Node n : node.getSuccessors()) {
//			System.out.println(n);
//			System.out.println(n.getSuccessors());
//			
//			
	//	}
		MinimaxAlgo algo = new MinimaxAlgo();
//		algo.execute(node);
		algo.findBestMove(node);
	}
}