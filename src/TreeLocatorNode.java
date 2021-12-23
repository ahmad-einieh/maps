
public class TreeLocatorNode<T> {
	LinkedList<T> Letter;
	Location location;
	TreeLocatorNode<T> child1, child2, child3, child4;

	public TreeLocatorNode(Node<T> letter, Location location) {
		super();
		this.location = location;
		child1 = child2 = child3 = child4 = null;
		Letter = new LinkedList<>(letter);
	}
	public TreeLocatorNode(Location location) {
		super();
		this.location = location;
		child1 = child2 = child3 = child4 = null;
		Letter = new LinkedList<>();
	}


}
