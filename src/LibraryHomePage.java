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
    
    private void loggedInHomePage(Account user) {
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
    
    private void register() throws Exception{
    	LibraryHomePage newAccount = new LibraryHomePage();
    	String email;
    	String password;
    	
    	while (true) {
    		System.out.println("Enter email: ");
            email = input.nextLine();
            
            if (newAccount.isValidEmail(email)) {
                break;
            }
            System.out.println("Please enter a York University email");
    	}
 	
        while (true) {          
            System.out.println("Enter password: ");
            password = input.nextLine();
            
            if (newAccount.isStrongPassword(password)) {
                break; 
            }
            
            System.out.println("Password is not strong enough. Please make a new password with the following requirements:");
            System.out.println("- At least 8 characters long");
            System.out.println("- At least one uppercase letter");
            System.out.println("- At least one lowercase letter");
            System.out.println("- At least one digit");
            System.out.println("- At least one symbol");
        }
        
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
    		database.accountGenerator(email, password, accType, 0, 0, false);
    		database.updateAccounts();
    		System.out.println("Registration successful! Please login.");
            loggedOutHomePage();
        }
    }
    

	private void login() throws Exception{
    	Account registeredAccount = null;
    	
    	while (true) {
    		
    		System.out.println("Enter email:");
            String email = input.nextLine();
            
            System.out.println("Enter password:");
            String password = input.nextLine();
            
            registeredAccount = database.iterateDB(email, password);
            
            if (registeredAccount != null) {
            	break;
            }
            
            System.out.println("Incorrect credentials, please try again!");
    	}
    	
    	// Maybe have infoExists provided as input to load user profile to loggedInHomePage.
    	loggedInHomePage(registeredAccount);
    }
    
    private boolean isValidEmail(String email) {
		return email.endsWith("yorku.ca");
	}
    
    private boolean isStrongPassword(String password) {
    	
        if (password == null || password.length() < 8) {
            return false; // Password should be at least 8 characters long
        }
        
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasNumber = false;
        boolean hasSymbol = false;
        
        // Loop through each character in the password
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else {
                // Assuming symbols are any characters that are not letters or digits
                hasSymbol = true;
            }
        }
        
        // Check if all criteria are met
        return hasUpperCase && hasLowerCase && hasNumber && hasSymbol;
    }
   
}
