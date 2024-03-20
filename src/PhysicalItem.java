import java.util.Calendar;
import java.util.Date;


// NOTE - should be an interface, however trying to make it an interface does not seem possible
// when inhereting from an abstract class
public abstract class PhysicalItem extends Item {
	
	public int copyNumber;
	public Date dueDate;
	public String itemID;
	public String libLocation;
	public boolean rentalEnabled;
	// if price == null, then not for sale
	public double price;
	
	public PhysicalItem(String itemType, String name, String author, String edition, String publisherName, String itemID, String libLocation, int copyNumber, Date dueDate, boolean rentalEnabled, double price) {
		super(itemType, name, author, edition, publisherName);
		this.itemID = itemID;
		this.libLocation = libLocation;
		this.copyNumber = copyNumber;
		this.dueDate = dueDate;
		this.rentalEnabled = rentalEnabled;
		this.price = price;
	}
	
	public void enable() {
		rentalEnabled = true;
	}
	
	public void disable() {
		rentalEnabled = false;
	}
	
	public void rentCopy() {
		if (rentalEnabled == false) {
			System.out.println("Rentals are currently disabled for this item.");
		}
		
		else {

		    // Get current date
		    Calendar calendar = Calendar.getInstance();
		    // Add one month to the current date
		    calendar.add(Calendar.MONTH, 1);
		    dueDate = calendar.getTime();
		    
		    //Insert some procedure here that creates a clone / prototype of the item, sets the clone copyNumber to null, -1, or some other odd value, and adds to user's itemList.
		    //Changing copyNumber of user's cloned item may not be necessary and might make returning physItems easier.
		    
		    copyNumber -= 1;
		    
		    System.out.println("Enjoy! Due Date: " + dueDate);
		    
			//TODO
			//Note - this implementation will involve cloning a copy of the book, and indicating that it is its own item.
		}
	}
	
	public void returnCopy(int copyNumber) {
		//TODO
		//Note - this implementation will involve "merging" the copy that the user took out back with the one in the database.
		//This can probably be done by checking the database to find a physItem that has identical fields, excluding copyNumber.
		//
		
		copyNumber += 1;
		
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

	public boolean isRentalEnabled() {
		return rentalEnabled;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}