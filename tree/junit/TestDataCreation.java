package test.tree.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import test.tree.main.Executor;
import test.tree.main.TestData;
import test.tree.main.core.TKnot;
import test.tree.main.core.TLeaf;

public class TestDataCreation {

	private TKnot tree;
	private Executor executor;
	
	@Before
	public void before() {
		tree = TestData.createTestTree();
		executor = new Executor(tree, 3);
	} 

	@Test
	public void testGetListSize() {
		assertEquals(executor.getListSize(tree.getLeafs()), 4);
		
		for (TKnot node : tree.getChildren()) {
			assertEquals(executor.getListSize(node.getLeafs()), 0);
		}
	}
	
	@Test
	public void sort() {
		executor.sortLeafs(tree);
		
		TLeaf res = tree.getLeafs();
		
		assertEquals(res.getWeight(), 1);
		res = res.getNext();

		assertEquals(res.getWeight(), 2);
		res = res.getNext();
		
		assertEquals(res.getWeight(), 3);
		res = res.getNext();
		
		assertEquals(res.getWeight(), 4);
		res = res.getNext();
	}
	
	@Test
	public void cut() {
		executor.sortLeafs(tree);
		
		executor.cutLeafs(tree);

		TLeaf res = tree.getLeafs();

		assertEquals(res.getWeight(), 1);
		res = res.getNext();

		assertEquals(res.getWeight(), 2);
		res = res.getNext();
		
	}
}
