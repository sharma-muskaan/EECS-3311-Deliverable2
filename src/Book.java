public class Book extends PhysicalItem {
	
	public Book(String name, String author, String edition, String issue,
			String publisherName, String itemID, String libLocation, int copyNumber) {
		super(name, author, edition, issue, publisherName, itemID, libLocation, copyNumber);
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
	public String getIssue() {
		return issue;
	}

	@Override
	public void setIssue(String issue) {
		this.issue = issue;
	}

	@Override
	public String getPublisherName() {
		return publisherName;
	}

	@Override
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	@Override
	public String getItemID() {
		return itemID;
	}

	@Override
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	@Override
	public String getLibLocation() {
		return libLocation;
	}

	@Override
	public void setLibLocation(String libLocation) {
		this.libLocation = libLocation;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getCopyNumber() {
		return copyNumber;
	}

	@Override
	public void rentCopy(int copyNumber) {
		this.copyNumber = copyNumber--;
	}

	@Override
	public void returnCopy(int copyNumber) {
		this.copyNumber = copyNumber++;
	}
}
