import java.io.File;
import java.io.IOException;

public class Client {
	public static void main(String [] args) throws Exception{
		//String path = "src/csv/account_data.csv";
		
		// Specify the file path
		String filePath = "src/csv/";
		String testFileName = "testFile" + ".csv";
		filePath += testFileName;

        // Create a File object
        File file = new File(filePath);

        try {
            // Create the file
            if (file.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file: " + e.getMessage());
            e.printStackTrace();
        }
		
		//LibraryHomePage homePage = LibraryHomePage.getInstance(path);
	}
}

//boolean check = new File(directory, temp).exists();