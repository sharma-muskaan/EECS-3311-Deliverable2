import java.util.Date;


// NOTE - should be an interface, however trying to make it an interface does not seem possible
// when inhereting from an abstract class
public abstract class PhysicalItem extends Item {
	
	int copyNumber = 20;
	Date dueDate = null;
	
	public PhysicalItem(String name, String author, String edition, String issue, String publisherName, String itemID,
			String libLocation, int copyNumber) {
		super(name, author, edition, issue, publisherName, itemID, libLocation);
		this.copyNumber = copyNumber;
	}
	
	public abstract int getCopyNumber();
	
	public abstract void rentCopy(int copyNumber);
	
	public abstract void returnCopy(int copyNumber);

}