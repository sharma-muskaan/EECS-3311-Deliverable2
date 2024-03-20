import java.util.ArrayList;

public class LibraryManager {
	protected String email;
	protected String password;
	protected static String path;
	private static LibraryDatabase database;
	protected static ArrayList<DigitalItem> digItemsDB;
	protected static ArrayList<PhysicalItem> physItemsDB;
	
	public LibraryManager(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	// Visitor Pattern could be utilized so LibraryManager visits Add class (implements a VisitorInterface)
	public void addDigitalItem(DigitalItem digItem) throws Exception {
		//Insert update to csv database file.
		digItemsDB.add(digItem);
		database.updateDigItems(digItemsDB, path);
	}

	public void addPhysicalItem(PhysicalItem physItem) throws Exception {
		//Insert update to csv database file.
		physItemsDB.add(physItem);
		database.updatePhysItems(physItemsDB, path);
	}
	
	public void enablePhysItem(PhysicalItem physItem) {
		//Insert update to csv database file.
		physItem.disable();
	}
	
	public void disablePhysItem(PhysicalItem physItem) {
		//Insert update to csv database file.
		physItem.enable();
	}
}
