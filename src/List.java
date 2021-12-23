public interface List<T> {

	boolean empty();

	boolean full();

	void findFirst();

	void findNext();

	boolean last();

	T retrieve();

	void update(T e);

	void insert(T e);

	void remove();
}
