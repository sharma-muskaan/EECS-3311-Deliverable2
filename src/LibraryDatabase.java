import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class LibraryDatabase {
	private static LibraryDatabase database;
	private ArrayList<Account> users;
	protected ArrayList<DigitalItem> digItemsDB;
	protected ArrayList<PhysicalItem> physItemsDB;
	protected String path;
    
    private LibraryDatabase() throws Exception {
		users = new ArrayList<Account>();
		digItemsDB = new ArrayList<DigitalItem>();
		physItemsDB = new ArrayList<PhysicalItem>();
		path = "src/csv/";
    }
    
    public static LibraryDatabase getInstance() throws Exception {
    	if (database == null) {
    		database = new LibraryDatabase();
    	}
		return database;
    }
	
	public void loadAccounts() throws Exception{
		String filePath = path + "account_data.csv";
		CsvReader reader = new CsvReader(filePath);
		reader.readHeaders();
		
		while(reader.readRecord()){
			//email,password,accType,itemsBorrowed,overdueItems,accountLocked
			String email = reader.get("email");
			String password = reader.get("password");
			String accType = reader.get("accType");
			int itemsBorrowed = Integer.parseInt(reader.get("itemsBorrowed"));
			int overdueItems = Integer.parseInt(reader.get("overdueItems"));
			boolean accountLocked = Boolean.parseBoolean(reader.get("accountLocked"));
			accountGenerator(email, password, accType, itemsBorrowed, overdueItems, accountLocked);
		}
	}
	
	public void loadDigItems(ArrayList<DigitalItem> digItemList, String email) throws Exception{
		
		String filePath = path;
		
		if (email == null) {
			filePath += "digItem_database.csv";
		}
		
		else {
			filePath += email + "_digItem_data.csv";
		}
		
		CsvReader reader = new CsvReader(filePath);
		reader.readHeaders();
		
		while(reader.readRecord()){
			
			String itemType = reader.get("itemType");
			String genre = reader.get("genre");
			String name = reader.get("name");
			String author = reader.get("author");
			String edition = reader.get("edition");
			String publisherName = reader.get("publisherName");
			DigitalItem newDigItem = new DigitalItem(itemType, genre, name, author, edition, publisherName);
			digItemList.add(newDigItem);
		}
	}
	

	public void loadPhysItems(ArrayList<PhysicalItem> physItemList, String email) throws Exception{
		
		String filePath = path;
		
		if (email == null) {
			filePath += "physItem_database.csv";
		}
		
		else {
			filePath += email + "_physItem_data.csv";
		}
		
		CsvReader reader = new CsvReader(filePath);
		reader.readHeaders();
		
		while(reader.readRecord()){
			
			String itemType = reader.get("itemType");
			String name = reader.get("name");
			String author = reader.get("author");
			String edition = reader.get("edition");
			String publisherName = reader.get("publisherName");
			String itemID = reader.get("itemID");
			String libLocation = reader.get("libLocation");
			int copyNumber = Integer.parseInt(reader.get("copyNumber"));
			
			String dueDateString = reader.get("dueDate");
	        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
	        Date dueDate = null;
	        try {
	            dueDate = dateFormat.parse(dueDateString);
	            System.out.println(name + " Parsed Date: " + dueDate);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        boolean rentalEnabled = Boolean.valueOf(reader.get("rentalEnabled"));
	        double price = Double.parseDouble(reader.get("price"));
	        
			PhysicalItem newPhysItem = PhysicalItemFactory.getPhysicalItem(itemType, name, author, edition, publisherName, itemID, libLocation, copyNumber, dueDate, rentalEnabled, price);
			physItemList.add(newPhysItem);
		}
	}
	
	public void updateAccounts() throws Exception{
		try {		
				String filePath = path + "account_data.csv";
				CsvWriter csvOutput = new CsvWriter(new FileWriter(filePath, false), ',');
				//email,password,accType,itemsBorrowed,overdueItems,accountLocked
				csvOutput.write("email");
				csvOutput.write("password");
		    	csvOutput.write("accType");
		    	csvOutput.write("itemsBorrowed");
		    	csvOutput.write("overdueItems");
		    	csvOutput.write("accountLocked");
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(Account u: users){
					csvOutput.write(u.getEmail());
					csvOutput.write(u.getPass());
					csvOutput.write(u.getAccType());
					csvOutput.write(String.valueOf(u.getItemsBorrowed()));
					csvOutput.write(String.valueOf(u.getOverdueItems()));
					csvOutput.write(String.valueOf(u.isAccountLocked()));
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
	// Make updatePhysItemsUser
	// Make updatePhysItemsDB
	
	// Should work for both main DB file and user digItem files?
	// To update the main digItem_database.csv, you must modify this code.
	public void updateDigItems(ArrayList<DigitalItem> digItemList, String filePath) throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(filePath, false), ',');
		    	//itemType,genre,name,author,edition,publisherName
				csvOutput.write("itemType");
				csvOutput.write("genre");
				csvOutput.write("name");
				csvOutput.write("author");
				csvOutput.write("edition");
				csvOutput.write("publisherName");
				csvOutput.endRecord();
				
				// else assume that the file already has the correct header line
				// write out a few records
				for(DigitalItem d: digItemList){
					csvOutput.write(d.getItemType());
					csvOutput.write(d.getGenre());
					csvOutput.write(d.getName());
					csvOutput.write(d.getAuthor());
					csvOutput.write(d.getEdition());
					csvOutput.write(d.getPublisherName());
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
		// Should work for both main DB file and user physItem files?
		// To update the main digItem_database.csv, you must modify this code.
		public void updatePhysItems(ArrayList<PhysicalItem> physItemList, String filePath) throws Exception{
			try {		
					CsvWriter csvOutput = new CsvWriter(new FileWriter(filePath, false), ',');
			    	//itemType,name,author,edition,publisherName,itemID,libLocation,copyNumber,dueDate,rentalEnabled,price
					csvOutput.write("itemType");
					csvOutput.write("name");
					csvOutput.write("author");
					csvOutput.write("edition");
					csvOutput.write("publisherName");
					csvOutput.write("itemID");
					csvOutput.write("libLocation");
					csvOutput.write("copyNumber");
					csvOutput.write("dueDate");
					csvOutput.write("rentalEnabled");
					csvOutput.write("price");
					csvOutput.endRecord();
					
					// else assume that the file already has the correct header line
					// write out a few records
					for(PhysicalItem p: physItemList){
						csvOutput.write(p.getItemType());
						csvOutput.write(p.getName());
						csvOutput.write(p.getAuthor());
						csvOutput.write(p.getEdition());
						csvOutput.write(p.getPublisherName());
						csvOutput.write(p.getItemID());
						csvOutput.write(p.getLibLocation());
						csvOutput.write(String.valueOf(p.getCopyNumber()));
						Date dueDate = p.getDueDate();
				        String dueDateString = null;

				        if (dueDate != null) {
				            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
				            dueDateString = dateFormat.format(dueDate);
				        }
				        
				        else {
				        	dueDateString = "null";
				        }
				        
						csvOutput.write(dueDateString);
						csvOutput.write(String.valueOf(p.isRentalEnabled()));
						csvOutput.write(String.valueOf(p.getPrice()));
						csvOutput.endRecord();
					}
					csvOutput.close();
				
				}catch (Exception e) {
					e.printStackTrace();
				}
		}

	// This method is used for 2 things - creating brand new registered accounts, and importing pre-existing ones as Account objects.
	// Could use Factory Pattern to make less cluttered and more efficient.
	public Account accountGenerator(String email, String password, String accType, int itemsBorrowed, int itemsOverdue, boolean accountLocked) throws Exception {
		
		Account user = null;
		
	    if (accType.equals("Visitor")) {
	    	user = new Visitor(new ConcreteAccount(email, password, accType, itemsBorrowed, itemsOverdue, accountLocked));
	    	users.add(user);
	    }
	    else if (accType.equals("Student")) {
	    	user = new Student(new ConcreteAccount(email, password, accType, itemsBorrowed, itemsOverdue, accountLocked));
	    	users.add(user);
	    }
	    
	    else if (accType.equals("Faculty")) {
	    	user = new Faculty(new ConcreteAccount(email, password, accType, itemsBorrowed, itemsOverdue, accountLocked));
	    	users.add(user);
	    }
	    
	    else if (accType.equals("NonFaculty")) {
	    	user = new NonFaculty(new ConcreteAccount(email, password, accType, itemsBorrowed, itemsOverdue, accountLocked));
	    	users.add(user);
	    }
	    
	    else {
	    	throw new Exception("Invalid Account Type");
	    }
	    
	    
	    String[] emailSplitter = email.split("@", 2);
	    String splitEmail = emailSplitter[0];
	    ItemListFactory.getItemList(user, "digItem", path, splitEmail);
	    ItemListFactory.getItemList(user, "physItem", path, splitEmail);
		return user;
	}
	
	public Account iterateDB(String email, String password) throws Exception{
		
		int i = 0;
		Account account;
		while (i < users.size()) {
		    account = users.get(i);
		    
		    String DB_email = account.getEmail();
		    String DB_password = account.getPass();
		    
		    if (email.equals(DB_email)) {
		    	if (password.equals(DB_password)) {
		    		return account;
		    	}
		    	else {
		    		System.out.println("You already have an account linked to this email, but your password is incorrect.");
		    		break;
		    	}
		    }
		    
		    i++;
		}
		
		return null;
	}
}
