package lab9;

import java.util.List;

public class MinimaxAlgo {
	public void execute(Node node) {
		int v = minValue(node);
		System.out.println(v);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		if (node.isTerminal()) {
			return node.getData().get(0);
		} else {
			List<Node> children = node.getSuccessors();
			int v = Integer.MIN_VALUE;
			for (Node child : children) {
				v = Math.max(v, minValue(child));

			}
			return v;
		}
	}

	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v
	public int minValue(Node node) {
		if (node.isTerminal()) {
			return node.getData().get(0);
		} else {
			List<Node> children = node.getSuccessors();
			int v = Integer.MAX_VALUE;
			for (Node child : children) {
				v = Math.min(v, maxValue(child));

			}
			return v;
		}
	}

	public Node findBestMove(Node node) {
		int bestv = Integer.MAX_VALUE;
		Node bestMove = null;
		for (Node child : node.getSuccessors()) {
			execute(child);
			int v = minValue(child);
			if (v < bestv) {
				bestv = v;
				bestMove = child;
			}
		}
		return bestMove;

	}
}