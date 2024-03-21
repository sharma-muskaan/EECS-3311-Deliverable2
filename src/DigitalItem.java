public class DigitalItem implements Item {
	
	public String itemType;
	public String genre;
	public String name;
	public String author;
	public String edition;
	public String publisherName;
	public int copyNumber;
	
	public DigitalItem(DigitalItem digitalItem) {
		this.itemType = digitalItem.itemType;
		this.genre = digitalItem.genre;
		this.name = digitalItem.name;
		this.author = digitalItem.author;
		this.edition = digitalItem.edition;
		this.publisherName = digitalItem.publisherName;
	}

	public DigitalItem(String itemType, String genre, String name, String author, String edition, String publisherName) {
		this.itemType = itemType;
		this.genre = genre;
		this.name = name;
		this.author = author;
		this.edition = edition;
		this.publisherName = publisherName;
	}
	
	@Override
	public String getItemType() {
		return itemType;
	}

	@Override
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
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
}
