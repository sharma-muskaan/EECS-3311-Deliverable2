import java.util.Calendar;
import java.util.Date;


// NOTE - should be an interface, however trying to make it an interface does not seem possible
// when inhereting from an abstract class
public abstract class PhysicalItem extends Item {
	
	int copyNumber;
	Date dueDate;
	public String itemID;
	public String libLocation;
	
	public PhysicalItem(String itemType, String name, String author, String edition, String publisherName, String itemID, String libLocation, int copyNumber, Date dueDate) {
		super(itemType, name, author, edition, publisherName);
		this.itemID = itemID;
		this.libLocation = libLocation;
		this.copyNumber = copyNumber;
		this.dueDate = dueDate;
	}
	
	public void rentCopy(int copyNumber) {
	    // Get current date
	    Calendar calendar = Calendar.getInstance();
	    // Add one month to the current date
	    calendar.add(Calendar.MONTH, 1);
	    dueDate = calendar.getTime();
	    System.out.println("Enjoy! Due Date: " + dueDate);
	    
		//TODO
		//Note - this implementation will involve cloning a copy of the book, and indicating that it is its own item.
	}
	
	public void returnCopy(int copyNumber) {
		//TODO
		//Note - this implementation will involve "merging" the copy that the user took out back with the database.
	}
	
	@Override
	public String getItemType() {
		return itemType;
	}

	@Override
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getAuthor() {
		return author;
	}

	@Override
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String getEdition() {
		return edition;
	}

	@Override
	public void setEdition(String edition) {
		this.edition = edition;
	}

	@Override
	public String getPublisherName() {
		return publisherName;
	}

	@Override
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	
	public String getLibLocation() {
		return libLocation;
	}
	public void setLibLocation(String libLocation) {
		this.libLocation = libLocation;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public int getCopyNumber() {
		return copyNumber;
	}
	public void setCopyNumber(int copyNumber) {
		this.copyNumber = copyNumber;
	}
}