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
    
    protected void loggedInHomePage() {
    	System.out.println("Login completed!");
    	System.exit(0);
    	
    	// TODO
    	// Displays list of hard cover books that a user is renting, plus their due dates.
    	// Prompts warnings for books with due dates less than 24 hours.
    	// Prompts DIFF warning if book is past due date.
    	// Also contains buttons for accessing common user tasks like search, rent, etc.
    }
    
    protected void register() throws Exception{
    	while (true) {
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
            	loggedOutHomePage();
            }
            else {
                // TODO - Add some validation method prior to account creation if not Visitor.
        		Account account = database.accountGenerator(email, password, accType);
        		database.updateAccounts();
        		System.out.println("Registration successful!");
                loggedOutHomePage();
            }
    	}
    }
    
    protected void login() throws Exception{
    	Account infoExists = null;
    	
    	while (true) {
    		
    		System.out.println("Enter email:");
            String email = input.nextLine();
            
            System.out.println("Enter password:");
            String password = input.nextLine();
            
            infoExists = database.iterateDB(email, password);
            
            if (infoExists != null) {
            	break;
            }
            
            System.out.println("Incorrect credentials, please try again!");
    	}
    	
    	// Maybe have infoExists provided as input to load user profile to loggedInHomePage.
    	loggedInHomePage();
    }
}
