import java.util.Scanner;

public class LibraryHomePage {

    protected boolean isValid;

    protected void Register(){
        Scanner input = new Scanner(System.in);
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
        	Account student = new Student(name, email, password, accType);
        	//LibraryDatabase.setAccInfo(student);
        }
        
        if (accType.equals("Faculty")) {
        	Account faculty = new Faculty(name, email, password, accType);
        	//LibraryDatabase.setAccInfo(faculty);
        }
        
        if (accType.equals("NonFaculty")) {
        	Account nonFaculty = new NonFaculty(name, email, password, accType);
        	//LibraryDatabase.setAccInfo(nonFaculty);
        }  
        
    }
    protected void login(){
        
    }

}
