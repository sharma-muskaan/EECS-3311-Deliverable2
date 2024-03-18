import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class LibraryDatabase {
	private static LibraryDatabase database;
	private ArrayList<Account> users;
	private String path;
    
    private LibraryDatabase() throws Exception {
		users = new ArrayList<Account>();
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
	
	public void loadDigItems(ArrayList<DigitalItem> digItemList, String fileName) throws Exception{
		String filePath = path + fileName + "_digItemList.csv";
		CsvReader reader = new CsvReader(filePath);
		reader.readHeaders();
		
		while(reader.readRecord()){
			
			String itemType = reader.get("itemType");
			String genre = reader.get("genre");
			String name = reader.get("name");
			String author = reader.get("author");
			String edition = reader.get("edition");
			String publisherName = reader.get("publisherName");
			DigitalItem newDigItem = digItemGenerator(itemType, genre, name, author, edition, publisherName);
			digItemList.add(newDigItem);
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
	
	// Make updateDigItemsDB
	public void updateDigItemsUser(Account user, String filePath) throws Exception{
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
				
				ArrayList<DigitalItem> digItemList = user.getDigitalItemList();
				
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

	// This method is used for 2 things - creating brand new registered accounts, and importing
	// pre-existing ones as Account objects.
	public Account accountGenerator(String email, String password, String accType) {
		
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
	    
//	    else {
//	    	throw new Exception("Invalid Account Type");
//	    }
	    
	    
	    String[] emailSplitter = email.split("@", 2);
	    String splitEmail = emailSplitter[0];
		doesDigListExist(user, splitEmail);
		//physItemGenerator(email);
	    
		return user;
	}
	
	public void doesDigListExist(Account user, String email) {
		// Specify the file path
		String fileName = email + "_" + "digItemList.csv";
		String filePath = path + fileName;

        // Create a File object
        File file = new File(filePath);

        try {
            // Create the file
            if (file.createNewFile()) {
                System.out.println("File created successfully.");
                updateDigItemsUser(user, filePath);
            } else {
                System.out.println("File already exists.");
                loadDigItems(user.getDigitalItemList(), email);
            }
        } catch (Exception e) {
            System.out.println("An error occurred while creating the file: " + e.getMessage());
            e.printStackTrace();
        }
        
        
	}
	
	public DigitalItem digItemGenerator(String itemType, String genre, String name, String author, String edition, String publisherName) {
		DigitalItem digItem = new DigitalItem(itemType, genre, name, author, edition, publisherName);
		return digItem;
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
		    	}
		    }
		    
		    i++;
		}
		
		return null;
	}
}
