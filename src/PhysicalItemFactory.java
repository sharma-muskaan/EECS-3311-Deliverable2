
public class PhysicalItemFactory {
	
	public PhysicalItem getPhysicalItem(String physicalItemType, String name, String author, String edition, String issue, String publisherName, String itemID,
			String libLocation, int copyNumber) {
		
		if(physicalItemType.equals("Book")) {
			PhysicalItem book = new Book(name, author, edition, issue, publisherName, itemID, libLocation, copyNumber); //placeholder object
			return book;
		}
		
		else if(physicalItemType.equals("CD")) {
			PhysicalItem CD = new CD(name, author, edition, issue, publisherName, itemID, libLocation, copyNumber); //placeholder object
			return CD;
		}
		
		else if(physicalItemType.equals("Magazine")) {
			PhysicalItem magazine = new CD(name, author, edition, issue, publisherName, itemID, libLocation, copyNumber); //placeholder object
			return magazine;
		}
		
		else return null;

	}

}
