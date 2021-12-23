public class Main {

	public static void main(String[] args) {
		testVHM();
		System.out.println("**********************");
		testLocator();
	}

	private static void testVHM() {
		VehicleHiringManager vhm = new VehicleHiringManager();
		vhm.addVehicle("F", new Location(4, 7));
		vhm.addVehicle("V", new Location(5, 7));
		vhm.addVehicle("K", new Location(6, 1));
		vhm.addVehicle("D", new Location(4, 3));
		vhm.addVehicle("O", new Location(4, 8));
		vhm.addVehicle("U", new Location(8, 4));
		vhm.addVehicle("V", new Location(8, 2));
		vhm.addVehicle("Y", new Location(2, 2));
		vhm.addVehicle("S", new Location(6, 1));
		vhm.addVehicle("B", new Location(6, 3));

		System.out.println("----------------------");
		System.out.println(vhm.getVehicleLoc("E"));
		System.out.println(vhm.getVehicleLoc("S"));
		System.out.println(vhm.getVehicleLoc("F"));

		System.out.println("----------------------");
		print(vhm.getVehiclesInRange(new Location(5, 5), 2));
		print(vhm.getVehiclesInRange(new Location(3, 3), 1));
		print(vhm.getVehiclesInRange(new Location(0, 0), 10));

		System.out.println("----------------------");
		Map<String, Location> map = vhm.getLocatorMap().getMap();
		System.out.println(map.find("U"));
		System.out.println(map.find("K"));
		System.out.println(map.find("X"));

		System.out.println("----------------------");
		Locator<String> locator = vhm.getLocatorMap().getLocator();
		System.out.println(locator.get(new Location(3, 5)).second);
		System.out.println(locator.get(new Location(2, 6)).second);
		System.out.println(locator.get(new Location(8, 3)).second);
		System.out.println(locator.get(new Location(5, 1)).second);
		System.out.println(locator.get(new Location(4, 2)).second);
		System.out.println(locator.get(new Location(0, 0)).second);
		System.out.println(locator.inRange(new Location(2, 2), new Location(8, 8)).second);
		System.out.println(locator.inRange(new Location(4, 4), new Location(6, 6)).second);
		System.out.println(locator.inRange(new Location(0, 0), new Location(2, 3)).second);
	}

	private static void testLocator() {
		TreeLocator<String> locator = new TreeLocator<String>();
		locator.add("F", new Location(4, 7));
		locator.add("V", new Location(5, 7));
		locator.add("K", new Location(6, 1));
		locator.add("D", new Location(4, 3));
		locator.add("O", new Location(4, 8));
		locator.add("U", new Location(8, 4));
		locator.add("V", new Location(8, 2));
		locator.add("Y", new Location(2, 2));
		locator.add("S", new Location(6, 1));
		locator.add("B", new Location(6, 3));

		System.out.println(locator.get(new Location(3, 5)).second);
		System.out.println(locator.get(new Location(2, 6)).second);
		System.out.println(locator.get(new Location(8, 3)).second);
		System.out.println(locator.get(new Location(5, 1)).second);
		System.out.println(locator.get(new Location(4, 2)).second);
		System.out.println(locator.get(new Location(0, 0)).second);
		System.out.println(locator.inRange(new Location(2, 2), new Location(8, 8)).second);
		System.out.println(locator.inRange(new Location(4, 4), new Location(6, 6)).second);
		System.out.println(locator.inRange(new Location(0, 0), new Location(2, 3)).second);
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
}
