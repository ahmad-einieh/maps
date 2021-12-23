
public class TreeLocatorMap<K extends Comparable<K>> implements LocatorMap<K> {

    private final BST<K,Location> bst;
    private final TreeLocator<K> treeLocator;

    public TreeLocatorMap() {
        bst = new BST<>();
        treeLocator = new TreeLocator<K>();
    }

    @Override
    public Map<K, Location> getMap() {
        return bst;
    }

    @Override
    public Locator<K> getLocator() {
        return treeLocator;
    }

    @Override
    public Pair<Boolean, Integer> add(K k, Location loc) {
        Pair<Boolean, Integer> x = bst.insert(k, loc);
        boolean flage = Boolean.TRUE.equals(x.first);
        if (flage) {
            treeLocator.add(k, loc);
            return new Pair<>(true,x.second );
        }
        return new Pair<>(false, x.second);
    }

    @Override
    public Pair<Boolean, Integer> move(K k, Location loc) {
        Pair<Boolean, Integer> pair = bst.find(k);
        //Pair pair2 = getLoc(k);
        Location location = getLoc(k).first;
        if (Boolean.TRUE.equals(pair.first)) {
            bst.remove(k);
            bst.insert(k, loc);
            treeLocator.remove(k, location);
            treeLocator.add(k, loc);
            return new Pair<>(true, Integer.parseInt(pair.second.toString()));
        }
        return new Pair<>(false, Integer.parseInt(pair.second.toString()));
    }

    @Override
    public Pair<Location, Integer> getLoc(K k) {
        Pair<Location,Integer> pair = new Pair<>(null,0);
        if(bst.empty()) return pair;
        else{
            if(bst.find(k).first){
                pair.second = bst.find(k).second;
                pair.first = bst.retrieve();
                return pair;
            }else{
                pair.second = bst.find(k).second;
                return pair;
            }
        }
    }

    @Override
    public Pair<Boolean, Integer> remove(K k) {

        Pair<Boolean, Integer> pair = bst.remove(k);
        if (Boolean.TRUE.equals(pair.first)) {
            treeLocator.remove(k, getLoc(k).first);
            return new Pair<>(true, Integer.parseInt(pair.second.toString()));
        }
        return new Pair<>(false, Integer.parseInt(pair.second.toString()));
    }

    @Override
    public List<K> getAll() {
        return bst.getAll();
    }

    @Override
    public Pair<List<K>, Integer> getInRange(Location lowerLeft, Location upperRight) {
        int count = 0;
        List<K> ll = new LinkedList<>();
        count = recInRange(treeLocator.root, lowerLeft, upperRight, ll);
        if (count == 1) count++;
        return new Pair<>(ll, count);
    }

    private int recInRange(TreeLocatorNode<K> node, Location lL, Location uR, List<K> ll) {
        int count = 0;
        if (node != null) {
        	count++;
            if ((lL.x <= node.location.x && lL.y <= node.location.y) &&
                    (uR.x >= node.location.x && uR.y >= node.location.y)) {
                node.Letter.findFirst();
                if(!node.Letter.empty()){
                while (!node.Letter.last()) {
                    ll.insert(node.Letter.retrieve());
                    node.Letter.findNext();
                }
                ll.insert(node.Letter.retrieve());}
            }
            if (node.location.x < lL.x) {
                if (node.location.y < lL.y) {
                    count += recInRange(node.child3, lL, uR, ll);
                } else if (node.location.y > uR.y) {
                    count += recInRange(node.child4, lL, uR, ll);
                } else {
                    count += recInRange(node.child3, lL, uR, ll);
                    if (node.location.y != lL.y) {
                        count += recInRange(node.child4, lL, uR, ll);
                    }
                }
            } else if (node.location.x > uR.x) {
                if (node.location.y < lL.y) {
                    count += recInRange(node.child2, lL, uR, ll);
                } else if (node.location.y > uR.y) {
                    count += recInRange(node.child1, lL, uR, ll);
                } else {
                    count += recInRange(node.child1, lL, uR, ll);
                    if (node.location.y != uR.y) {
                        count += recInRange(node.child2, lL, uR, ll);
                    }
                }
            } else if (node.location.x == uR.x) {
                if (node.location.y < lL.y) {
                    count += recInRange(node.child2, lL, uR, ll);
                } else if (node.location.y > uR.y) {
                    count += recInRange(node.child1, lL, uR, ll);
                    count += recInRange(node.child4, lL, uR, ll);
                } else {
                    count += recInRange(node.child1, lL, uR, ll);
                    if (node.location.y != uR.y) {
                        count += recInRange(node.child2, lL, uR, ll);
                    }
                    if (node.location.y != lL.y) {
                        count += recInRange(node.child4, lL, uR, ll);
                    }
                }

            } else if (node.location.x == lL.x) {
                if (node.location.y < lL.y) {
                    count += recInRange(node.child2, lL, uR, ll);
                    count += recInRange(node.child3, lL, uR, ll);
                } else if (node.location.y > uR.y) {
                    count += recInRange(node.child4, lL, uR, ll);
                } else {
                    if (node.location.y != uR.y) {
                        count += recInRange(node.child2, lL, uR, ll);
                    }
                    count += recInRange(node.child3, lL, uR, ll);
                    if (node.location.y != lL.y) {
                        count += recInRange(node.child4, lL, uR, ll);
                    }
                }
            } else {
                if (node.location.y > uR.y) {
                    count += recInRange(node.child1, lL, uR, ll);
                    count += recInRange(node.child4, lL, uR, ll);
                } else if (node.location.y < lL.y) {
                    count += recInRange(node.child2, lL, uR, ll);
                    count += recInRange(node.child3, lL, uR, ll);
                } else {
                    count += recInRange(node.child1, lL, uR, ll);
                    if (node.location.y != uR.y) {
                        count += recInRange(node.child2, lL, uR, ll);
                    }
                    count += recInRange(node.child3, lL, uR, ll);
                    if (node.location.y != lL.y) {
                        count += recInRange(node.child4, lL, uR, ll);
                    }
                }
            }
        }
        return count;
    }

}
