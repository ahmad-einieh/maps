public class TreeLocMapTest {
    public static void main(String[] args) {
        TreeLocatorMap<String> vhm = new TreeLocatorMap<String>();
        System.out.println("-----------add-----------");
        System.out.println(vhm.add("F", new Location(4, 7)).toString());
        System.out.println(vhm.add("V", new Location(5, 7)).toString());
        System.out.println(vhm.add("K", new Location(6, 1)).toString());
        System.out.println(vhm.add("D", new Location(4, 3)).toString());
        System.out.println(vhm.add("O", new Location(4, 8)).toString());
        System.out.println(vhm.add("U", new Location(8, 4)).toString());
        System.out.println(vhm.add("V", new Location(8, 2)).toString());
        System.out.println(vhm.add("Y", new Location(2, 2)).toString());
        System.out.println(vhm.add("S", new Location(6, 1)).toString());
        System.out.println(vhm.add("B", new Location(6, 3)).toString());
        System.out.println("------------getall1----------");
        print(vhm.getAll());
        print2(new Pair(vhm.getLocator().getAll(), 0));
        System.out.println("----------getloc------------");
        System.out.println(vhm.getLoc("E").toString());
        System.out.println(vhm.getLoc("S").toString());
        System.out.println(vhm.getLoc("F").toString());
        System.out.println("------------move----------");
        System.out.println(vhm.move("B", new Location(6, 10)).toString());
        System.out.println("------------getall2----------");
        print(vhm.getAll());
        print2(new Pair(vhm.getLocator().getAll(), 0));
        System.out.println("-----------inrange-----------");
        print(vhm.getInRange(new Location(3, 3), (new Location(7, 7))).first);
        print(vhm.getInRange(new Location(2, 2), (new Location(4, 4))).first);
        print(vhm.getInRange(new Location(-10, -10), (new Location(10, 10))).first);
        System.out.println("----------------------");

    }
    private static <T> void print(List<T> l) {
        if (l == null) {
            System.out.println("[null]");
            return;
        }
        if (l.empty()) {
            System.out.println("[empty]");
            return;
        }
        l.findFirst();
        while (!l.last()) {
            System.out.print(l.retrieve() + ", ");
            l.findNext();
        }
        System.out.println(l.retrieve());
    }
    
	private static <T> void print2(Pair<List<Pair<Location, List<T>>>, Integer> p) {
		List<Pair<Location, List<T>>> l = p.first;
		if (l == null) {
			System.out.print(p.second + ": ");
			System.out.println("[null]");
			return;
		}
		if (l.empty()) {
			System.out.print(p.second + ": ");
			System.out.println("[empty]");
			return;
		}
		System.out.print(p.second + ": ");
		l.findFirst();
		while (!l.last()) {
			System.out.print(l.retrieve().first + " ");
			print(l.retrieve().second);
			l.findNext();
		}
		System.out.print(l.retrieve().first);
		print(l.retrieve().second);
		System.out.println();
	}
}