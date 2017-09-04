package test.tree.main;

import test.tree.main.core.TKnot;
import test.tree.main.core.TLeaf;

public class Executor {
	
	private int weight;
	private TKnot tree;
	
	public Executor(TKnot tree, int weight) {
		this.tree = tree;
		this.weight = weight;
	}

	public void run() {
		processKnot(tree);
		
		TLogger.info("=============== RESULT =======================");
		sysout(tree);
	}
	
	private void sysout(TKnot knot) {
		String out = knot.getName();
		int size = getListSize(knot.getLeafs());
		if (size > 0) {
			out += "(";
			TLeaf leaf = knot.getLeafs();
			for (int i = 0; i < size; i++) {
				out += leaf.getName() + "(" + leaf.getWeight() + ")";
				if (i < size - 1) {
					out += ", ";
				}
				leaf = leaf.getNext();
			}
			out += ")";
		}
		
		TLogger.info(out);

		for (TKnot child : knot.getChildren()) {
			sysout(child);
		}

	}
	
	public TLeaf processKnot(TKnot knot) {
		TLogger.info("Knot " + knot.getName());
		
		sortLeafs(knot);
		TLeaf cut = cutLeafs(knot);
		
		for (TKnot child : knot.getChildren()) {
			
			TLogger.info("  Children knot " + child.getName());
			
			if (child.getLeafs() == null) {
				child.setLeafs(cut);
			} else {
				child.getLeafs().setNext(cut);
			}
			cut = processKnot(child);
			
		}
		return cut;
	}

	public TLeaf cutLeafs(TKnot knot) {
		TLeaf leafs = knot.getLeafs();
		
		int size = getListSize(leafs);
		
		int sum = 0;
		TLeaf curr = leafs;
		TLeaf parent = null;
		for (int i = 0; i <= size; i++) {
			sum += curr.getWeight();  
			if (sum > weight) {
				if (parent != null) {
					parent.setNext(null);
				} else {
					knot.setLeafs(null);
				}
				
				
				return curr;
			}
			
			parent = curr;
			curr = curr.getNext();
		}
		return null;
	}
	
	public void sortLeafs(TKnot knot) {
		TLeaf head = knot.getLeafs();
		if (head == null) {
			return;
		}
		
		TLeaf sorted = null;
		
		int size = getListSize(head);
		
		TLogger.info("Size = " + size);
		
		for (int i = 0; i < size; i++) {
			TLeaf curr = head;
			TLeaf min = curr;
			TLeaf minParent = null;
			
			while (curr.getNext() != null) {
				
				if (curr.getNext().getWeight() < head.getWeight()) {
					min = curr.getNext();
					minParent = curr;
				}
				
				curr = curr.getNext();
			}

			if (minParent == null) {
				head = head.getNext();
			} else {
				minParent.setNext(min.getNext());
			}
			
			if (sorted == null) {
				sorted = min;
				
			} else {
				TLeaf first = sorted;
				while (first.getNext() != null) {
					first = first.getNext();
				}
				first.setNext(min);
			}
			min.setNext(null);
		}
		
		
		
		TLogger.info("**************** SORTED **********************");
		int sortedSize = getListSize(sorted);
		
		TLeaf l = sorted;
		for (int i = 0; i < sortedSize; i++) {
			TLogger.info("Name " + l.getName() + "(" + l.getWeight() +")");
			l = l.getNext();
		}
		TLogger.info("**************************************");
		
		knot.setLeafs(sorted);
	}
	
	public int getListSize(TLeaf head) {
		int size = 0;
		if (head == null) {
			return size;
		}
		while (head.getNext() != null) {
			head = head.getNext();
			size++;
		}
		size++;
		return size; 
	}
}
