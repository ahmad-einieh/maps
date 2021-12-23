
public class TreeLocator<T> implements Locator<T> {

    TreeLocatorNode<T> root;

    public TreeLocator() {
        root = null;
    }

    @Override
    public int add(T e, Location loc) {
        int count = 0;
        if (root == null) {
            root = new TreeLocatorNode<>(loc);
            root.Letter.insert(e);
            return count;
        }
        TreeLocatorNode<T> p = root;
        while (true) {
            if (p.location.x == loc.x && p.location.y == loc.y) {
                p.Letter.insert(e);
                count++;
                return count;
            } else {
                if (loc.x < p.location.x && loc.y <= p.location.y) {
                    if (p.child1 == null) {
                        p.child1 = new TreeLocatorNode<>(loc);
                        p.child1.Letter.insert(e);
                        count++;
                        return count;
                    } else {
                        p = p.child1;
                        count++;
                    }
                }
                if (loc.x <= p.location.x && loc.y > p.location.y) {
                    if (p.child2 == null) {
                        p.child2 = new TreeLocatorNode<>(loc);
                        p.child2.Letter.insert(e);
                        count++;
                        return count;
                    } else {
                        p = p.child2;
                        count++;
                    }
                }
                if (loc.x > p.location.x && loc.y >= p.location.y) {
                    if (p.child3 == null) {
                        p.child3 = new TreeLocatorNode<>(loc);
                        p.child3.Letter.insert(e);
                        count++;
                        return count;
                    } else {
                        p = p.child3;
                        count++;
                    }
                }
                if (loc.x >= p.location.x && loc.y < p.location.y) {
                    if (p.child4 == null) {
                        p.child4 = new TreeLocatorNode<>(loc);
                        p.child4.Letter.insert(e);
                        count++;
                        return count;
                    } else {
                        p = p.child4;
                        count++;
                    }
                }
            }
        }
    }

    @Override
    public Pair<List<T>, Integer> get(Location loc) {
        List<T> list = new LinkedList<>();
        int count = 0;
        TreeLocatorNode<T> p = root;
        while (true) {
            if (p.location.x == loc.x && p.location.y == loc.y) {
                count++;
                return new Pair<>((List<T>)p.Letter, count);
            } else {
                count++;
                if (loc.x < p.location.x && loc.y <= p.location.y) {
                    if (p.child1 == null) return new Pair<>(list, count);
                    p = p.child1;
                } else if (loc.x <= p.location.x && loc.y > p.location.y) {
                    if (p.child2 == null) return new Pair<>(list, count);
                    p = p.child2;
                } else if (loc.x > p.location.x && loc.y >= p.location.y) {
                    if (p.child3 == null) return new Pair<>(list, count);
                    p = p.child3;
                } else {
                    if (p.child4 == null) return new Pair<>(list, count);
                    p = p.child4;
                }
            }

        }
    }

    @Override
    public Pair<Boolean, Integer> remove(T e, Location loc) {
        int count = 0;
        boolean f = false;
        TreeLocatorNode<T> p = root;
        if (root == null) return new Pair<>(false, count);
        while (true) {
            count++;
            if (p.location.x == loc.x && p.location.y == loc.y) {
                if (p.Letter.empty()) return new Pair<>(false, count);
                p.Letter.findFirst();
                    while (!p.Letter.last()) {
                        if (p.Letter.retrieve().equals(e)) {
                        	f = true;
                            p.Letter.remove();}
                        else
                            p.Letter.findNext();
                    }
                    if (p.Letter.retrieve().equals(e)) {
                    	f = true;
                        p.Letter.remove();}
                return new Pair<>(f, count);
            } else {
                if (loc.x < p.location.x && loc.y <= p.location.y) {
                    if (p.child1 == null) return new Pair<>(false, count);
                    p = p.child1;
                } else if (loc.x <= p.location.x && loc.y > p.location.y) {
                    if (p.child2 == null) return new Pair<>(false, count);
                    p = p.child2;
                } else if (loc.x > p.location.x && loc.y >= p.location.y) {
                    if (p.child3 == null) return new Pair<>(false, count);
                    p = p.child3;
                } else {
                    if (p.child4 == null) return new Pair<>(false, count);
                    p = p.child4;
                }
            }
        }
    }

    @Override
    public List<Pair<Location, List<T>>> getAll() {
        List<Pair<Location, List<T>>> ll = new LinkedList<>();
        recgetAll(root, ll);
        return ll;
    }

    private void recgetAll(TreeLocatorNode<T> node, List<Pair<Location, List<T>>> ll) {
        if (node != null) {
            ll.insert(new Pair<>(node.location,(List<T>) node.Letter));
            recgetAll(node.child1, ll);
            recgetAll(node.child2, ll);
            recgetAll(node.child3, ll);
            recgetAll(node.child4, ll);
        }
    }

    @Override
    public Pair<List<Pair<Location, List<T>>>, Integer> inRange(Location lowerLeft, Location upperRight) {
        int count =0 ;
        List<Pair<Location, List<T>>> ll = new LinkedList<>();
        count = recInRange(root, lowerLeft, upperRight, ll);
        return new Pair<>(ll, count);
    }
    private int recInRange(TreeLocatorNode<T> node, Location lL, Location uR, List<Pair<Location,List<T>>> ll) {
        int count = 0;
        if (node != null) {
            count++;
            if ((lL.x <= node.location.x && lL.y <= node.location.y) &&
                    (uR.x >= node.location.x && uR.y >= node.location.y)) {
                Pair<Location, List<T>> pair = new Pair<Location, List<T>>(node.location, node.Letter);
                ll.insert(pair);
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
