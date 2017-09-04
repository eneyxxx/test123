package test.tree.main;

import java.util.ArrayList;
import java.util.List;

import test.tree.main.core.TKnot;
import test.tree.main.core.TLeaf;

public class TestData {


	public static TKnot createTestTree() {
		
		TLeaf l3 = new TLeaf("b1", 1);
		
		TLeaf l2 = new TLeaf("b3", 3);
		l2.setNext(l3);
		
		TLeaf l1 = new TLeaf("b4", 4);
		l1.setNext(l2);
		
		TLeaf head = new TLeaf("b2", 2);
		head.setNext(l1);
		
		
		
		
		List<TKnot> children = new ArrayList<>();
		
		children.add(new TKnot("a1", new ArrayList<>(), null));
		children.add(new TKnot("a2", new ArrayList<>(), null));
		children.add(new TKnot("a3", new ArrayList<>(), null));
		
		TKnot knotTree0 = new TKnot("knotTree0", children, head);
		
		
		
		return knotTree0;
	}
}
