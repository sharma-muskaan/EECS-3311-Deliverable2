import java.util.Date;

public class Book extends PhysicalItem {
	public Book(String name, String author, String edition, String issue, String publisherName, String itemID,
			String libLocation, int copyNumber, Date dueDate) {
		super(name, author, edition, issue, publisherName, itemID, libLocation, copyNumber, dueDate);
	}
}
