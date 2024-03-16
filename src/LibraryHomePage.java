import java.util.Scanner;

public class LibraryHomePage {

    protected boolean isValid;
    Scanner input = new Scanner(System.in);

    protected void Register(){
        System.out.println("Enter name:");
        String name = input.nextLine();
        
        System.out.println("Enter email:");
        String email = input.nextLine();
        
        System.out.println("Enter password:");
        String password = input.nextLine();
        
        System.out.println("Select Account Type:");
        String accType = input.nextLine();
        
        //to follow design principles (single responsibility) this should later be moved to a new method
        if (accType.equals("Visitor")) {
        	Account visitor = new Visitor(name, email, password, accType);
        	//LibraryDatabase.setAccInfo(visitor);
        }
        if (accType.equals("Student")) {
        	Account student = new Student(new ConcreteAccount(name, email, password, accType));
        	//LibraryDatabase.setAccInfo(student);
        }
        
        if (accType.equals("Faculty")) {
        	Account faculty = new Faculty(new ConcreteAccount(name, email, password, accType));
        	//LibraryDatabase.setAccInfo(faculty);
        }
        
        if (accType.equals("NonFaculty")) {
        	Account nonFaculty = new NonFaculty(name, email, password, accType);
        	//LibraryDatabase.setAccInfo(nonFaculty);
        }  
        
    }
    
    protected void login(){
    	System.out.println("Enter email:");
        String email = input.nextLine();
        
        System.out.println("Enter password:");
        String password = input.nextLine();
        
        //TODO - Assess if matches with database entry!
    }
}
