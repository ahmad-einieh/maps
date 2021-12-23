public class someTest {
    public static void main(String[] args) {

       /* BST<Integer, String > n=new BST<Integer, String>();
        Pair<Boolean, Integer> p;
        p=n.insert(65, "a");
        System.out.println(p.first +","+p.second);
        p=n.insert(91, "a");
        System.out.println(p.first +","+p.second);
        p=n.insert(31, "a");
        System.out.println(p.first +","+p.second);
        p=n.insert(14, "a");
        System.out.println(p.first +","+p.second);
        p=n.insert(33, "a");
        System.out.println(p.first +","+p.second);
        p=n.insert(0, "a");
        System.out.println(p.first +","+p.second);
        p=n.insert(53, "a");
        System.out.println(p.first +","+p.second);
        p=n.insert(93, "a");
        System.out.println(p.first +","+p.second);
        p=n.insert(73, "a");
        System.out.println(p.first +","+p.second);
        p=n.insert(71, "a");
        System.out.println(p.first +","+p.second);
        p=n.insert(69, "a");
        System.out.println(p.first +","+p.second);*/
        TreeLocator<String> tl = new TreeLocator<>();
        tl.add("R", new Location(4, 7));
        tl.add("T", new Location(4, 7));
        tl.add("R", new Location(4, 7));
        tl.add("T",new Location(4,7));
        tl.add("V",new Location(4,7));
        tl.add("R",new Location(1,4));
        tl.add("R", new Location(4, 7));

        System.out.println(tl.remove("R", new Location(4, 7)));
        System.out.println(tl.remove("K", new Location(1, 4)));
        System.out.println(tl.remove("R", new Location(1, 4)));
        System.out.println(tl.remove("T", new Location(1, 4)));
        System.out.println(tl.remove("T", new Location(1, 4)));
        System.out.println(tl.remove("T", new Location(4, 7)));
        System.out.println(tl.remove("T", new Location(4, 7)));

        //System.out.println(tl.remove("R",new Location(4,7)));
        List<String> x = tl.get(new Location(4, 7)).first;
        if (!x.empty()) {
            x.findFirst();
            while (!x.last()) {
                System.out.println(x.retrieve());
                x.findNext();
            }
            System.out.println(x.retrieve());
        }


    }
}
