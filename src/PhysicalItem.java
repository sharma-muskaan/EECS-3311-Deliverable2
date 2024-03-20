import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.print.DocFlavor.STRING;


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
	    Calendar takeOut = Calendar.getInstance();
	    // Add one month to the current date
	    takeOut.add(Calendar.MONTH, 1);
	    this.dueDate = takeOut.getTime();
	    System.out.println("Enjoy! Due Date: " + this.dueDate);
	    
		//TODO
		//Note - this implementation will involve cloning a copy of the book, and indicating that it is its own item.
	

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