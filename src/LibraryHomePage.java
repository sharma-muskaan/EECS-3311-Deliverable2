import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryHomePage {
	
	private static LibraryHomePage homePage;
	private ArrayList<Account> users;
	private String path;
    private Scanner input;
    
    private LibraryHomePage(String path) throws Exception {
		users = new ArrayList<Account>();
		input = new Scanner(System.in);
		this.path = path;
		load();
    }
    
    public static LibraryHomePage getInstance(String path) throws Exception {
    	if (homePage == null) {
    		homePage = new LibraryHomePage(path);
    	}
		return homePage;
    }
	
	public void load() throws Exception{
		CsvReader reader = new CsvReader(path);
		reader.readHeaders();
		
		while(reader.readRecord()){
			
			String email = reader.get("email");
			String password = reader.get("password");
			String accType = reader.get("accType");
			accountGenerator(email, password, accType);
		}
		
		loggedOutHomePage();
	}
	
	public void update() throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
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
            
            Account accountExists = iterateDB(email, password);
            
            if (accountExists != null) {
            	System.out.println("You already have an account. Please try logging in instead!");
            	loggedOutHomePage();
            }
            else {
                // TODO - Add some validation method prior to account creation if not Visitor.
        		Account account = accountGenerator(email, password, accType);
        		homePage.update();
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
            
            infoExists = iterateDB(email, password);
            
            if (infoExists != null) {
            	break;
            }
            
            System.out.println("Incorrect credentials, please try again!");
    	}
    	
    	// Maybe have infoExists provided as input to load user profile to loggedInHomePage.
    	loggedInHomePage();
    }
    
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
		    		loggedOutHomePage();
		    	}
		    }
		    
		    i++;
		}
		
		return null;
	}
}
