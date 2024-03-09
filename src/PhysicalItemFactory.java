
public class PhysicalItemFactory {
	
	public PhysicalItem getPhysicalItem(String physicalItemType, String name, String author, String edition, String issue, String publisherName, String itemID,
			String libLocation, int copyNumber) {
		
		if(physicalItemType.equals("Book")) {
			PhysicalItem physicalItem = new Book(name, author, edition, issue, publisherName, itemID, libLocation, copyNumber); //placeholder object
			return physicalItem;
		}
		
		else return null;
		
	}

}
