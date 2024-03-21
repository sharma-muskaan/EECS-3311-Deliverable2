import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.print.DocFlavor.STRING;


// NOTE - should be an interface, however trying to make it an interface does not seem possible
// when inhereting from an abstract class
public class PhysicalItem implements Item, PhysItemPrototype {
	
	public String itemType;
	public String name;
	public String author;
	public String edition;
	public String publisherName;
	public int copyNumber;
	public Date dueDate;
	public String itemID;
	public String libLocation;
	public boolean rentalEnabled;
	// if price == null, then not for sale
	public double price;
	private static LibraryDatabase database;
	
	
	
	public PhysicalItem(PhysicalItem physicalItem) throws Exception {
		this.itemType = physicalItem.itemType;
		this.name = physicalItem.name;
		this.author = physicalItem.author;
		this.edition = physicalItem.edition;
		this.publisherName = physicalItem.publisherName;
		this.itemID = physicalItem.itemID;
		this.libLocation = physicalItem.libLocation;
		this.copyNumber = physicalItem.copyNumber;
		this.dueDate = physicalItem.dueDate;
		this.rentalEnabled = physicalItem.rentalEnabled;
		this.price = physicalItem.price;
		database = LibraryDatabase.getInstance();
	}
	
	public PhysicalItem(String itemType, String name, String author, String edition, String publisherName, String itemID, String libLocation, int copyNumber, Date dueDate, boolean rentalEnabled, double price) throws Exception {
		this.itemType = itemType;
		this.name = name;
		this.author = author;
		this.edition = edition;
		this.publisherName = publisherName;
		this.itemID = itemID;
		this.libLocation = libLocation;
		this.copyNumber = copyNumber;
		this.dueDate = dueDate;
		this.rentalEnabled = rentalEnabled;
		this.price = price;
		database = LibraryDatabase.getInstance();
	}
	
	public void enable() {
		rentalEnabled = true;
	}
	
	public void disable() {
		rentalEnabled = false;
	}
	
	public void rentCopy(Account user) throws Exception {
		
		if (rentalEnabled == false) {
			System.out.println("Rentals are currently disabled for this item.");
		}
		
		else if (user.getItemsBorrowed() > 10) {
			System.out.println("You are not allowed to take more than 10 items out at a time.");
		}
		
		else {
			PhysicalItem rentedCopy = (PhysicalItem) this.clone();
			rentedCopy.setCopyNumber(1);
			
		    // Get current date
		    Calendar calendar = Calendar.getInstance();
		    // Add one month to the current date
		    calendar.add(Calendar.MONTH, 1);
		    rentedCopy.dueDate = calendar.getTime();
		    user.getPhysicalItemList().add(rentedCopy);
		    
		    String[] emailSplitter = user.getEmail().split("@", 2);
			String splitEmail = database.path + emailSplitter[0] + "_physItem_data.csv";
		    database.updatePhysItems(user.getPhysicalItemList(), splitEmail);
		    
		    copyNumber -= 1;
		    
		    String databasePath = database.path + "physItem_database.csv";
		    database.updatePhysItems(database.physItemsDB, databasePath);
		    
		    //Insert some procedure here that creates a clone / prototype of the item, sets the clone copyNumber to null, -1, or some other odd value, and adds to user's itemList.
		    //Changing copyNumber of user's cloned item may not be necessary and might make returning physItems easier.
		    
		    System.out.println("Enjoy! Due Date: " + dueDate);
		    
			//TODO
			//Note - this implementation will involve cloning a copy of the book, and indicating that it is its own item.
		}
	}

	public String warning(Date due){
		
		Date curr = new Date();

		long timeDiff = dueDate.getTime() - curr.getTime(); // gets the time in miliseconds
		long timeDiffHrs = timeDiff/(60*60*1000); // converts to hours
		long timeDiffDays = timeDiff/(24*60*60*1000); // converts to days

		String output = "";

		if ( timeDiffHrs > 0 && timeDiffHrs < 24) {  // checks if there is less than 24 hours left on the due date
			output = String.format("The book: %s is due in %d hours", this.name, timeDiffHrs);
		}
		else if(timeDiffHrs < 0 ){  // checks if the book is past the due date
			output = String.format("The book: %s is OVERDUE PLEASE RETURN IT", this.name);
		}
	
		else if(timeDiffDays == 1){ // checks if there is 1 day before the due date make it "Day" instead of days
			output = String.format("%d Day till %s is due for return", timeDiffDays, this.name);
		}
		else  {  // makes it "days" if more than one day
			output = String.format("%d Days till %s is due for return", timeDiffDays, this.name);
			
		}
		return output;
		
		
	}
	
	
	public void returnCopy(Account user) throws Exception {
		//TODO
		//Note - this implementation will involve "merging" the copy that the user took out back with the database.
		
		PhysicalItem returnedCopy = this;
		
		for (PhysicalItem p : database.physItemsDB) {
			if (p.getItemID().equals(returnedCopy.getItemID())) {
				p.setCopyNumber(p.getCopyNumber() + 1);
				user.getPhysicalItemList().remove(returnedCopy);
				
				String[] emailSplitter = user.getEmail().split("@", 2);
				String splitEmail = database.path + emailSplitter[0] + "_physItem_data.csv";
			    database.updatePhysItems(user.getPhysicalItemList(), splitEmail);
			    
			    String databasePath = database.path + "physItem_database.csv";
			    database.updatePhysItems(database.physItemsDB, databasePath);
				
				break;
			}
		}
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
	
	@Override
	public PhysItemPrototype clone() throws Exception {
		return new PhysicalItem(this);
	}
}