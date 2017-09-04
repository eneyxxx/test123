package test.tree.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import test.tree.main.Executor;
import test.tree.main.TestData;
import test.tree.main.core.TKnot;
import test.tree.main.core.TLeaf;

public class TestExecutor {

	private TKnot tree;
	private Executor executor;
	
	@Before
	public void before() {
		tree = TestData.createTestTree();
		executor = new Executor(tree, 3);
		executor.run();
	}

	@Test
	public void testExecutor() {
		
		TLeaf leafs = tree.getLeafs();
		assertEquals(leafs.getWeight(), 1);
		TLeaf next = leafs.getNext();
		assertEquals(next.getWeight(), 2);
		next = next.getNext();
		assertEquals(next, null);
		
		assertEquals(tree.getChildren().size(), 3);
		
		TKnot a1 = tree.getChildren().get(0);
		TLeaf leafsA1 = a1.getLeafs();
		assertEquals(leafsA1.getWeight(), 3);
		leafsA1 = leafsA1.getNext();
		assertEquals(leafsA1, null);

		
		TKnot a2 = tree.getChildren().get(1);
		TLeaf leafsA2 = a2.getLeafs();
		assertEquals(leafsA2, null);

		TKnot a3 = tree.getChildren().get(2);
		TLeaf leafsA3 = a3.getLeafs();
		assertEquals(leafsA3, null);
		
	}
}
