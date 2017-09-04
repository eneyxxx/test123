package test.tree.main;

import test.tree.main.core.TKnot;

public class Main {

	
	public static void main(String[] args) {
		
		TLogger.info("start.");
		
		TKnot tree = TestData.createTestTree();
		
		Executor executor = new Executor(tree, 3);
		executor.run();
		
		TLogger.info("finished.");
	}
	
	
	
}
