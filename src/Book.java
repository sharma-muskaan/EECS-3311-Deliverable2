import java.util.Date;

public class Book extends PhysicalItem implements PhysItemPrototype {
	
	public Book(Book book) {
		super(book);
	}
	
	public Book(String itemType, String name, String author, String edition, String publisherName, String itemID,
			String libLocation, int copyNumber, Date dueDate, boolean rentalEnabled, double price) {
		super(itemType, name, author, edition, publisherName, itemID, libLocation, copyNumber, dueDate, rentalEnabled, price);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Book clone() {
		return new Book(this);
	}
}
