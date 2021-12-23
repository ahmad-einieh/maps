
public class Node<T> {
	public T data;
	public Node<T> next;
	public Node() {
		super();
		this.data = null;	
		this.next = null;
	}
	public Node(T data) {
		super();
		this.data = data;	
		this.next = null;
	}
}
