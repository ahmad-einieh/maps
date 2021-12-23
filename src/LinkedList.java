
public class LinkedList<T> implements List<T> {
    private Node<T> head, current;


    public LinkedList() {
        super();
        head = current = null;
    }

    public LinkedList(Node<T> e) {
        super();
        current = head = e;
    }

    @Override
    public boolean empty() {

        return head == null;
    }

    @Override
    public boolean full() {
        return false;
    }

    @Override
    public void findFirst() {
        current = head;
    }

    @Override
    public void findNext() {
        current = current.next;
    }

    @Override
    public boolean last() {
        return current.next == null;
    }

    @Override
    public T retrieve() {
        return current.data;
    }

    @Override
    public void update(T e) {
        current.data = e;
    }

    @Override
    public void insert(T e) {
        Node<T> temp;
        if (empty()) current = head = new Node<>(e);
        else {
            temp = current.next;
            current.next = new Node<>(e);
            current = current.next;
            current.next = temp;
        }
    }

    @Override
    public void remove() {
        if (current == head) head = head.next;
        else {
            Node<T> temp = head;
            while (temp.next != current) temp = temp.next;
            temp.next = current.next;
        }
        if (current.next == null) current = head;
        else current = current.next;

    }
}
