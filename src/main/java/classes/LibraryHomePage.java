package classes;

public class LibraryHomePage {
	
	public LibraryHomePage() throws Exception {}

	boolean isValidEmail(String email) {
		return email.contains("@");
	}
    
    boolean additionalValidation(String email) {
		return email.endsWith("yorku.ca");
	}
    
	boolean isStrongPassword(String password) {
    	
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
