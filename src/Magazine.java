import java.util.Date;

public class Magazine extends PhysicalItem implements PhysItemPrototype {

	public Magazine(Magazine magazine) {
		super(magazine);
	}
	
	public Magazine(String itemType, String name, String author, String edition, String publisherName, String itemID,
			String libLocation, int copyNumber, Date dueDate, boolean rentalEnabled, double price) {
		super(itemType, name, author, edition, publisherName, itemID, libLocation, copyNumber, dueDate, rentalEnabled, price);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Magazine clone() {
		return new Magazine(this);
	}
}
