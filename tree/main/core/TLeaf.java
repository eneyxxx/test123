package test.tree.main.core;

public class TLeaf {

	private String name;
	private int weight;
	private TLeaf next;
	
	public TLeaf(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public TLeaf getNext() {
		return next;
	}

	public void setNext(TLeaf next) {
		this.next = next;
	}
	
}
