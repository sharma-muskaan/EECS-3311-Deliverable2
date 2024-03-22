import java.util.Date;

public class PhysicalItemFactory {
	
	public static PhysicalItem getPhysicalItem(String itemType, String name, String author, String edition, String publisherName, String itemID,
			String libLocation, int copyNumber, Date dueDate, boolean rentalEnabled, double price) throws Exception {
		
		if(itemType.equals("Book")) {
			PhysicalItem book = new Book(itemType, name, author, edition, publisherName, itemID, libLocation, copyNumber, dueDate, rentalEnabled, price);
			return book;
		}
		
		else if(itemType.equals("CD")) {
			PhysicalItem CD = new CD(itemType, name, author, edition, publisherName, itemID, libLocation, copyNumber, dueDate, rentalEnabled, price);
			return CD;
		}
		
		else if(itemType.equals("Magazine")) {
			PhysicalItem magazine = new CD(itemType, name, author, edition, publisherName, itemID, libLocation, copyNumber, dueDate, rentalEnabled, price);
			return magazine;
		}
		
		else if(itemType.equals("DVD")) {
			PhysicalItem DVD = new DVD(itemType, name, author, edition, publisherName, itemID, libLocation, copyNumber, dueDate, rentalEnabled, price);
			return DVD;
		}
		
		else return null;

	}

}