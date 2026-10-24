# Maps and Vehicle Locations

A Java data-structures project that associates vehicle IDs with two-dimensional locations and supports location lookup, movement, removal, and rectangular range searches.

Despite the repository name, this is not a web map or a mapping-service integration. It uses in-memory tree and linked-list structures.

## Components

- `BST`: a comparable-key map implementation.
- `TreeLocator`: a spatial tree for locations and associated values.
- `TreeLocatorMap`: combines key lookup with location lookup.
- `VehicleHiringManager`: operations for adding, moving, removing, and locating vehicles.
- Supporting `List`, `LinkedList`, `Pair`, and `Location` types.

`getVehiclesInRange` searches an inclusive square centered on the requested location, not a circular distance radius.

## Compile and run

With a Java JDK installed, from the repository directory:

```bash
javac -d out src/*.java
java -cp out Main
```

No external libraries, database, or API keys are required. [`Main.java`](src/Main.java) runs built-in vehicle and locator examples and prints results to the console; there is no interactive UI.

Additional console exercise classes include `TreeLocMapTest`, `TreeLocaterTest`, and `someTest`. These are study/test drivers, not evidence of comprehensive automated coverage.

See [`VehicleHiringManager.java`](src/VehicleHiringManager.java) for the small application-facing API and [`LocatorMap.java`](src/LocatorMap.java) for its underlying interface.
