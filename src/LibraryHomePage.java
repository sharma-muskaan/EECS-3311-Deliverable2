import java.util.ArrayList;
import java.util.Scanner;

public class LibraryHomePage {
	
	private static LibraryHomePage homePage;
	private static LibraryDatabase database;
    private Scanner input;
    
    private LibraryHomePage() throws Exception {
    	database = LibraryDatabase.getInstance();
		input = new Scanner(System.in);
    }
    
    public static LibraryHomePage getInstance() throws Exception {
    	if (homePage == null) {
    		homePage = new LibraryHomePage();
    	}
		return homePage;
    }
	
    protected void loggedOutHomePage() throws Exception {
        
    	while (true) {
        	System.out.println("L = Log In");
            System.out.println("R = Register");
            String nextPage = input.nextLine();
            
            if (nextPage.equals("L")) {
            	login();
            }
            
            if (nextPage.equals("R")) {
            	register();
            }
            else {
            	System.out.println("Please enter a valid input!");
            }
            
    	}
    }
    
    private void loggedInHomePageGeneral(Account user) {
    	ArrayList<PhysicalItem> userPhysicalItems = user.getPhysicalItemList();
    	ArrayList<DigitalItem> userDigitalItems = user.getDigitalItemList();
    	
    	System.out.println("Login completed!\n");
    	System.out.println("Rentals:");
    	for (PhysicalItem p : userPhysicalItems) {
    		System.out.println("Name: " + p.getName());
    		System.out.println("Author: " + p.getAuthor());
    		System.out.println("Item Type: " + p.getItemType());
    		System.out.println("Due Date: " + p.getDueDate() + "\n");
    	}
    	
    	System.out.println("E-Books:");
    	for (DigitalItem d : userDigitalItems) {
    		System.out.println("Name: " + d.getName());
    		System.out.println("Author: " + d.getAuthor());
    		System.out.println("Item Type: " + d.getItemType() + "\n");
    	}
    	
    	System.exit(0);
    	
    	// TODO
    	// Displays list of hard cover books that a user is renting, plus their due dates.
    	// Prompts warnings for books with due dates less than 24 hours.
    	// Prompts DIFF warning if book is past due date.
    	// Also contains buttons for accessing common user tasks like search, rent, etc.
    }
    
    public void managementPortal(LibraryManager manager) throws Exception {
    	for (PhysicalItem p : LibraryDatabase.physItemsDB) {
    		System.out.println("Name: " + p.getName());
    		System.out.println("Author: " + p.getAuthor());
    		System.out.println("Item Type: " + p.getItemType());
    		System.out.println("Due Date: " + p.getDueDate() + "\n");
    		System.out.println("[DISABLE]");
    		//Placeholder for button on each Item panel. When clicked, changes to [ENABLE].
    		//GUI panel would print info about Item, but ALSO hold a direct reference to it.
    		//This means that the search below will not need to be done to retrieve the Item.
    	}
    	
    	//Instead of following print statements, assume there is "Add Physical Item" and "Add Digital Item" buttons.
    	System.out.println("AP = Add Physical Item");
    	System.out.println("AD = Add Digital Item");
    	System.out.println("E = Add Physical Item");
    	System.out.println("D = Add Physical Item");
    	String userInput = input.nextLine();
    	
    	if (userInput.equals("D")) {
    		System.out.println("Select Item Type: ");
    		String itemType =  input.nextLine();
    		System.out.println("Select Genre: " );
			String genre = input.nextLine();
			System.out.println("Enter Name: ");
			String name = input.nextLine();
			System.out.println("Enter Author Name: ");
			String author = input.nextLine();
			System.out.println("Enter Edition: ");
			String edition = input.nextLine();
			System.out.println("Enter Publisher: ");
			String publisherName = input.nextLine();
			
			DigitalItem newDigItem = new DigitalItem(itemType, genre, name, author, edition, publisherName);
			manager.addDigitalItem(newDigItem);
    	}
    	else if (userInput.equals("D")) {
    		System.out.println("Select Item Type: ");
    		String itemType =  input.nextLine();
			System.out.println("Enter Name: ");
			String name = input.nextLine();
			System.out.println("Enter Author Name: ");
			String author = input.nextLine();
			System.out.println("Enter Edition: ");
			String edition = input.nextLine();
			System.out.println("Enter Publisher: ");
			String publisherName = input.nextLine();
			System.out.println("Enter Item ID: " );
			String itemID = input.nextLine();
			System.out.println("Enter Library Location: " );
			String libLocation = input.nextLine();
			//it can be assumed that an item that is only offered for sale just has rentalEnabled = false
			System.out.println("Can this item be accessed for free? (Enter true or false.) " );
			boolean rentalEnabled = Boolean.valueOf(input.nextLine());
			System.out.println("If for sale, enter price: " );
			double price = Double.parseDouble(input.nextLine());
			
			PhysicalItem newPhysItem = PhysicalItemFactory.getPhysicalItem(itemType, name, author, edition, publisherName, itemID, libLocation, 20, null, rentalEnabled, price);
			manager.addPhysicalItem(newPhysItem);
    	}
    	
    	System.exit(0);
    }
    
    private void register() throws Exception{
    	System.out.println("Enter email: ");
        String email = input.nextLine();
        
        System.out.println("Enter password: ");
        String password = input.nextLine();
        
        // This would be replaced with a button in implementation.
        System.out.println("Select Account Type: ");
        String accType = input.nextLine();
        
        Account accountExists = database.iterateDB(email, password);
        
        if (accountExists != null) {
        	System.out.println("You already have an account. Please try logging in instead!");
        }
        else {
            // TODO - Add some validation method prior to account creation if not Visitor.
    		database.accountGenerator(email, password, accType, 0, 0, false);
    		database.updateAccounts();
    		System.out.println("Registration successful! Please login.");
        }
        
        loggedOutHomePage();
    }
    
    private void login() throws Exception{
    	Account registeredAccount = null;
    	
    	String MGR_email = "MGR_ACCESS";
    	String MGR_password = "Password";
    	
    	while (true) {
    		
    		System.out.println("Enter email:");
            String email = input.nextLine();
            
            System.out.println("Enter password:");
            String password = input.nextLine();
            
            if (email.equals(MGR_email) && password.equals(MGR_password)) {
            	LibraryManager manager = new LibraryManager(email, password);
            	managementPortal(manager);
            }
            
            else {
                registeredAccount = database.iterateDB(email, password);
                
                if (registeredAccount != null) {
                	break;
                }
            }
            
            System.out.println("Incorrect credentials, please try again!");
    	}
    	
    	// Maybe have infoExists provided as input to load user profile to loggedInHomePageGeneral.
    	loggedInHomePageGeneral(registeredAccount);
    }
}
