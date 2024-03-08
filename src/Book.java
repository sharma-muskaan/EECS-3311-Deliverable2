
public class Book {


	public String name;
	public String author;
	public String edition;
	public String issue;
	public String publisherName;
	public String itemID;
	public String libLocation;
	
	public Book(String name, String author, String edition, String issue,
			String publisherName, String itemID, String libLocation) {
		
		this.name = name;
		this.author = author;
		this.edition = edition;
		this.issue = issue;
		this.publisherName = publisherName;
		this.itemID = itemID;
		this.libLocation = libLocation;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getPublisherName() {
		return publisherName;
	}

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
	
}
