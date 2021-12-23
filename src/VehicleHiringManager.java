public class VehicleHiringManager {

    private LocatorMap<String> treeLocatorMap;

    public VehicleHiringManager() {
        treeLocatorMap = new TreeLocatorMap<>();
    }

    // Returns the locator map.
    public LocatorMap<String> getLocatorMap() {
        return treeLocatorMap;
    }

    // Sets the locator map.
    public void setLocatorMap(LocatorMap<String> locatorMap) {
        treeLocatorMap = locatorMap;
    }

    // Inserts the vehicle id at location loc if it does not exist and returns true.
    // If id already exists, the method returns false.
    public boolean addVehicle(String id, Location loc) {
        Pair<Boolean, Integer> pair = treeLocatorMap.add(id, loc);
        return pair.first;
    }

    // Moves the vehicle id to location loc if id exists and returns true. If id not
    // exist, the method returns false.
    public boolean moveVehicle(String id, Location loc) {
        Pair<Boolean, Integer> pair = treeLocatorMap.move(id, loc);
        return Boolean.TRUE.equals(pair.first);
    }

    // Removes the vehicle id if it exists and returns true. If 	id does not exist,
    // the method returns false.
    public boolean removeVehicle(String id) {
        Pair<Boolean, Integer> pair = treeLocatorMap.remove(id);
        return Boolean.TRUE.equals(pair.first);
    }

    // Returns the location of vehicle id if it exists, null otherwise.
    public Location getVehicleLoc(String id) {
        Pair<Location, Integer> pair = treeLocatorMap.getLoc(id);
        return pair.first;
    }

    // Returns all vehicles located within a square of side 2*r centered at loc
    // (inclusive of the boundaries).
    public List<String> getVehiclesInRange(Location loc, int r) {
        return treeLocatorMap.getInRange(new Location(loc.x - r, loc.y - r), new Location(loc.x +r, loc.y + r)).first;
    }
}
