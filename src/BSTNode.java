
public class BSTNode<K, T> {
	public K ID;
	public T data;
	public BSTNode<K, T>  left,right;

	public BSTNode(K iD, T data) {
		super();
		ID = iD;
		this.data = data;
		left = right = null;
	}
}
