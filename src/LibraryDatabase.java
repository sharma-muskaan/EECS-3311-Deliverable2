import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class LibraryDatabase {
	private static LibraryDatabase database;
	private ArrayList<Account> users;
	protected ArrayList<DigitalItem> digItemsDB;
	protected ArrayList<PhysicalItem> physItemsDB;
	private String path;
    
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
			
			String email = reader.get("email");
			String password = reader.get("password");
			String accType = reader.get("accType");
			accountGenerator(email, password, accType);
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
			PhysicalItem newPhysItem = new PhysicalItem(itemType, name, author, edition, publisherName, itemID, libLocation);
			physItemList.add(newPhysItem);
		}
	}
	
	public void updateAccounts() throws Exception{
		try {		
				String filePath = path + "account_data.csv";
				CsvWriter csvOutput = new CsvWriter(new FileWriter(filePath, false), ',');
				//email,password,accType
				csvOutput.write("email");
				csvOutput.write("password");
		    	csvOutput.write("accType");
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(Account u: users){
					csvOutput.write(u.getEmail());
					csvOutput.write(u.getPass());
					csvOutput.write(u.getAccType());
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
			    	//itemType,name,author,edition,publisherName,itemID,libLocation
					csvOutput.write("itemType");
					csvOutput.write("name");
					csvOutput.write("author");
					csvOutput.write("edition");
					csvOutput.write("publisherName");
					csvOutput.write("itemID");
					csvOutput.write("libLocation");
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
						csvOutput.endRecord();
					}
					csvOutput.close();
				
				}catch (Exception e) {
					e.printStackTrace();
				}
		}

	// This method is used for 2 things - creating brand new registered accounts, and importing
	// pre-existing ones as Account objects.
	public Account accountGenerator(String email, String password, String accType) throws Exception {
		
		Account user = null;
		
	    if (accType.equals("Visitor")) {
	    	user = new Visitor(email, password, accType);
	    	users.add(user);
	    }
	    else if (accType.equals("Student")) {
	    	user = new Student(new ConcreteAccount(email, password, accType));
	    	users.add(user);
	    }
	    
	    else if (accType.equals("Faculty")) {
	    	user = new Faculty(new ConcreteAccount(email, password, accType));
	    	users.add(user);
	    }
	    
	    else if (accType.equals("NonFaculty")) {
	    	user = new NonFaculty(email, password, accType);
	    	users.add(user);
	    }
	    
	    else {
	    	throw new Exception("Invalid Account Type");
	    }
	    
	    
	    String[] emailSplitter = email.split("@", 2);
	    String splitEmail = emailSplitter[0];
		doesListExist(user, "digItem", splitEmail);
		doesListExist(user, "physItem", splitEmail);
	    
		return user;
	}
	
	//Only checks for if user lists exist, does not check if main DB lists exist yet.
	public void doesListExist(Account user, String listType, String email) throws Exception {
		// Specify the file path
		
		String fileName = email;
		String filePath = path;
		
		if (listType.equals("digItem")) {
			fileName += "_digItem_data.csv";
			filePath += fileName;
		}
		
		else if (listType.equals("physItem")){
			fileName += "_physItem_data.csv";
			filePath += fileName;
		}

        // Create a File object
        File file = new File(filePath);
        boolean fileExists = file.createNewFile();
        
        try {
            // Create the file
            if (fileExists) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while creating the file: " + e.getMessage());
            e.printStackTrace();
        }
        
        
		if (listType.equals("digItem")) {
	        if (fileExists == true) {
	        	updateDigItems(user.getDigitalItemList(), filePath);
	        }
	        
	        else if (fileExists == false) {
	        	loadDigItems(user.getDigitalItemList(), email);
	        }
		}
		
		else if (listType.equals("physItem")){
	        if (fileExists == true) {
	        	updatePhysItems(user.getPhysicalItemList(), filePath);
	        }
	        
	        else if (fileExists == false) {
	        	loadPhysItems(user.getPhysicalItemList(), email);
	        }
		}
		
	    else {
	    	throw new Exception("Invalid Account Type");
	    }
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
