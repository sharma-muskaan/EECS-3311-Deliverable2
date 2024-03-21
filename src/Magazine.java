import java.util.Date;

public class Magazine extends PhysicalItem implements PhysItemPrototype {

	public Magazine(Magazine magazine) throws Exception {
		super(magazine);
	}
	
	public Magazine(String itemType, String name, String author, String edition, String publisherName, String itemID,
			String libLocation, int copyNumber, Date dueDate, boolean rentalEnabled, double price) throws Exception {
		super(itemType, name, author, edition, publisherName, itemID, libLocation, copyNumber, dueDate, rentalEnabled, price);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Magazine clone() throws Exception {
		return new Magazine(this);
	}
}
