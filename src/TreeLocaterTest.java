
public class TreeLocaterTest {
	public static void main(String[] args) {
		TreeLocator<String> b1 = new TreeLocator<String>();
		System.out.println("******Add*****");
		System.out.println(b1.add("F", new Location(4, 7)));
		System.out.println(b1.add("F", new Location(4, 7)));
		System.out.println(b1.add("F", new Location(4, 7)));
		System.out.println(b1.add("V", new Location(5, 7)));
		System.out.println(b1.add("K", new Location(6, 1)));
		System.out.println(b1.add("D", new Location(4, 3)));
		System.out.println(b1.add("O", new Location(4, 8)));
		System.out.println(b1.add("U", new Location(8, 4)));
		System.out.println(b1.add("V", new Location(8, 2)));
		System.out.println(b1.add("Y", new Location(2, 2)));
		System.out.println(b1.add("S", new Location(6, 1)));
		System.out.println(b1.add("B", new Location(6, 3)));
		System.out.println(b1.add("F", new Location(1, 2)));
		System.out.println(b1.add("V", new Location(2, 3)));
		System.out.println(b1.add("K", new Location(3, 2)));
		System.out.println(b1.add("D", new Location(2, 1)));
		System.out.println(b1.add("O", new Location(3, 8)));
		System.out.println(b1.add("U", new Location(4, 9)));
		System.out.println(b1.add("V", new Location(5, 8)));
		System.out.println(b1.add("Y", new Location(6, 7)));
		System.out.println(b1.add("S", new Location(4, 0)));
		System.out.println(b1.add("B", new Location(4, 3)));
		System.out.println(b1.add("S", new Location(8, 4)));
		System.out.println(b1.add("B", new Location(6, 0)));
		System.out.println("******Get*****");
		print(b1.get(new Location(6, 3)).first);
		print(b1.get(new Location(6, 1)).first);
		print(b1.get(new Location(6, 3)).first);
		print(b1.get(new Location(6, 1)).first);
		print(b1.get(new Location(9, 9)).first);
		print(b1.get(new Location(6, 3)).first);
		System.out.println("******Remove*****");
		System.out.println(b1.remove("B", new Location(6, 3)));
		System.out.println(b1.remove("K", new Location(6, 1)));
		System.out.println(b1.remove("F", new Location(4, 7)));
		System.out.println(b1.remove("F", new Location(4, 7)));
		System.out.println(b1.remove("B", new Location(6, 3)));
		System.out.println(b1.remove("S", new Location(6, 1)));
		System.out.println(b1.remove("K", new Location(9, 9)));
		System.out.println(b1.remove("C", new Location(6, 3)));
		System.out.println("******Get*****");
		print(b1.get(new Location(6, 3)).first);
		print(b1.get(new Location(6, 1)).first);
		print(b1.get(new Location(6, 3)).first);
		print(b1.get(new Location(6, 1)).first);
		print(b1.get(new Location(9, 9)).first);
		print(b1.get(new Location(6, 3)).first);
		System.out.println("******inRange*****");
		Pair<List<Pair<Location, List<String>>>, Integer> pair = b1.inRange(new Location(4, 4), new Location(6, 6));
		print2(pair);
		System.out.println("******inRange*****");
		pair = b1.inRange(new Location(0, 0), new Location(2, 2));
		print2(pair);
		System.out.println("******inRange*****");
		pair = b1.inRange(new Location(0, 0), new Location(10, 10));
		print2(pair);

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
