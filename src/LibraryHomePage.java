import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryHomePage {
	
	static LibraryHomePage homePage;
	public static ArrayList<Account> users = new ArrayList<Account>();
	public static String path;
    protected boolean isValid;
    static Scanner input = new Scanner(System.in);
	
	public static void main(String [] args) throws Exception{
		String path = "src/account_data.csv";
		homePage = new LibraryHomePage();
		homePage.load(path);
		loggedOutHomePage();
	}
	
	
	public static Account accountGenerator(String email, String password, String accType) throws Exception {
		
		Account user;
		
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
	    
		return user;
	}
	
	public boolean iterateDB(String path, String email, String password) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){
			String DB_email = reader.get("email");
			String DB_password = reader.get("password");
			
			if (DB_email.equals(email) && DB_password.equals(password)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void load(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){
			
			String email = reader.get("email");
			String password = reader.get("password");
			String accType = reader.get("accType");
			accountGenerator(email, password, accType);
		}
	}
	
	public void update(String path) throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
				//name,id,email,password
				csvOutput.write("name");
				csvOutput.write("id");
		    	csvOutput.write("email");
				csvOutput.write("password");
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

    protected static void loggedOutHomePage() throws Exception {
        System.out.println("L = Log In");
        System.out.println("R = Register");
        String nextPage = input.nextLine();
        
        if (nextPage.equals("L")) {
        	login();
        }
        
        if (nextPage.equals("R")) {
        	register();
        }
    }
    
    protected static void loggedInHomePage() {
    	System.out.println("Login completed!");
    	System.exit(0);
    	
    	// TODO
    	// Displays list of hard cover books that a user is renting, plus their due dates.
    	// Prompts warnings for books with due dates less than 24 hours.
    	// Prompts DIFF warning if book is past due date.
    	// Also contains buttons for accessing common user tasks like search, rent, etc.
    }
    
    protected static void register() throws Exception{
        System.out.println("Enter email: ");
        String email = input.nextLine();
        
        System.out.println("Enter password: ");
        String password = input.nextLine();
        
        // This would be replaced with a button in implementation.
        System.out.println("Select Account Type: ");
        String accType = input.nextLine();
        
        // TODO - Add some validation method prior to account creation if not Visitor.
		accountGenerator(email, password, accType);
		homePage.update(path);
        loggedOutHomePage();
    }
    
    protected static void login() throws Exception{
    	boolean isValid = false;
    	
    	while (true) {
    		
    		System.out.println("Enter email:");
            String email = input.nextLine();
            
            System.out.println("Enter password:");
            String password = input.nextLine();
            
            isValid = iterateDB(path, email, password);
            
            if (isValid) {
            	break;
            }
            
            System.out.println("Incorrect credentials, please try again!");
    	}
    	
    	loggedInHomePage();
    }
}
