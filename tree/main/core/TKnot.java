package test.tree.main.core;

import java.util.List;

public class TKnot {
	
	private String name;
	
	private List<TKnot> children;
	
	private TLeaf leafs;

	public TKnot(String name, List<TKnot> children, TLeaf leafs) {
		this.name = name;
		this.leafs = leafs;
		this.children = children;
	}
	
	public List<TKnot> getChildren() {
		return children;
	}

	public TLeaf getLeafs() {
		return leafs;
	}
	
	public void addKnot(TKnot knot) {
		children.add(knot);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLeafs(TLeaf leafs) {
		this.leafs = leafs;
	}
	
}
