
public class BST<K extends Comparable<K>, T> implements Map<K, T> {

    BSTNode<K, T> ROOT, CURRENT;

    public BST() {
        ROOT = CURRENT = null;
    }

    @Override
    public boolean empty() {
        return ROOT == null;
    }

    @Override
    public boolean full() {
        return false;
    }

    @Override
    public T retrieve() {
        return CURRENT.data;
    }

    @Override
    public void update(T e) {
        CURRENT.data = e;

    }

    @Override
    public Pair<Boolean, Integer> find(K key) {
        Pair<Boolean, Integer> pa = new Pair<>(false, 0);
        int count = 0;
        BSTNode<K, T> p = ROOT, q = ROOT;
        if (empty()) {
            count++;
            return new Pair<>(false, count);
        } else {
            while (p != null) {
                q = p;
                count++;
                if (p.ID.compareTo(key) == 0) {
                    CURRENT = p;
                    pa.first = true;
                    break;
                } else if (p.ID.compareTo(key) < 0)
                    p = p.right;
                else
                    p = p.left;
            }
            pa.second = count;
        }
        CURRENT = q;
        return pa;
    }

    @Override
    public Pair<Boolean, Integer> insert(K key, T data) {
        BSTNode<K, T> p, q = CURRENT;
        int count = 0;
        Pair<Boolean, Integer> pa = find(key);
        if (pa.first) {
            CURRENT = q;
            return new Pair<>(false, pa.second);
        }
        p = new BSTNode<>(key, data);
        if (empty()) {
            ROOT = CURRENT = p;
            return new Pair<>(true, count);
        } else {
            if (key.compareTo(CURRENT.ID) < 0)
                CURRENT.left = p;
            else
                CURRENT.right = p;
            CURRENT = p;
            return new Pair<>(true, pa.second);
        }
    }

    @Override
    public Pair<Boolean, Integer> remove(K key) {
        int count = 0;
        K tempKey = key;
        BSTNode<K, T> p = ROOT;
        BSTNode<K, T> q = null;
        while (p != null) {
            if (key.compareTo(p.ID) < 0) {
                q = p;
                p = p.left;
            } else if (key.compareTo(p.ID) > 0) {
                q = p;
                p = p.right;
            } else {
                count++;
                if (p.left != null && p.right != null) {
                    BSTNode<K, T> min = p.right;
                    q = p;
                    while (min.left != null) {
                        q = min;
                        min = min.left;
                    }
                    p.ID = min.ID;
                    p.data = min.data;
                    tempKey = min.ID;
                    p = min;
                }
                if (p.left != null) {
                    p = p.left;
                } else {
                    p = p.right;
                }
                if (q == null) {
                    ROOT = p;
                } else {
                    if (tempKey.compareTo(q.ID) < 0) {
                        q.left = p;
                    } else {
                        q.right = p;
                    }
                }
                CURRENT = ROOT;
                return new Pair<>(true, count);
            }
            count++;
        }
        return new Pair<>(false, count);
    }

    @Override
    public List<K> getAll() {
        List<K> ll = new LinkedList<>();
        recGetAll(ROOT, ll);
        return ll;
    }

    private void recGetAll(BSTNode<K, T> key, List<K> ll) {
        if (key != null) {
            recGetAll(key.left, ll);
            ll.insert(key.ID);
            recGetAll(key.right, ll);
        }
    }

}
