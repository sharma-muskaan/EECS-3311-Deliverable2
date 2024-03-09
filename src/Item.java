
abstract class Item {

	public String name;
	public String author;
	public String edition;
	public String issue;
	public String publisherName;
	public String itemID;
	public String libLocation;
	
	public Item(String name, String author, String edition, String issue,
			String publisherName, String itemID, String libLocation) {
		
		this.name = name;
		this.author = author;
		this.edition = edition;
		this.issue = issue;
		this.publisherName = publisherName;
		this.itemID = itemID;
		this.libLocation = libLocation;
		
	}
	
	public abstract String getName();

	public abstract void setName(String name); 

	public abstract String getAuthor();

	public abstract void setAuthor(String author);

	public abstract String getEdition();

	public abstract void setEdition(String edition);

	public abstract String getIssue();

	public abstract void setIssue(String issue);

	public abstract String getPublisherName();

	public abstract void setPublisherName(String publisherName);

	public abstract String getItemID();

	public abstract void setItemID(String itemID);

	public abstract String getLibLocation();

	public abstract void setLibLocation(String libLocation);
	
}
