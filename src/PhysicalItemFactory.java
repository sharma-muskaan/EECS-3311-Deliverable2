import java.util.Date;

public class PhysicalItemFactory {
	
	public static PhysicalItem getPhysicalItem(String itemType, String name, String author, String edition, String publisherName, String itemID,
			String libLocation, int copyNumber, Date dueDate) {
		
		if(itemType.equals("Book")) {
			PhysicalItem book = new Book(itemType, name, author, edition, publisherName, itemID, libLocation, copyNumber, dueDate); //placeholder object
			return book;
		}
		
		else if(itemType.equals("CD")) {
			PhysicalItem CD = new CD(itemType, name, author, edition, publisherName, itemID, libLocation, copyNumber, dueDate); //placeholder object
			return CD;
		}
		
		else if(itemType.equals("Magazine")) {
			PhysicalItem magazine = new CD(itemType, name, author, edition, publisherName, itemID, libLocation, copyNumber, dueDate); //placeholder object
			return magazine;
		}
		
		else return null;

	}

}