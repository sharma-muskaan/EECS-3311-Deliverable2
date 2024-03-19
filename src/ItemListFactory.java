import java.io.File;
import java.io.IOException;

public class ItemListFactory {
	
	private static boolean fileCreator(String filePath) throws IOException {
		File file = new File(filePath);
        boolean fileExists = file.createNewFile();
        
        try {
            // Create the file
            if (fileExists) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while creating the file: " + e.getMessage());
            e.printStackTrace();
        }
		
        return fileExists;
	}

	public static void getItemList(Account user, String listType, String path, String email) throws Exception {

		LibraryDatabase database = LibraryDatabase.getInstance();
		String fileName = email;
		String filePath = path;
		
		if(listType.equals("digItem")) {
			fileName += "_digItem_data.csv";
			filePath += fileName;
			
			boolean fileExists = fileCreator(filePath);
			
			if (fileExists == true) {
	        	database.updateDigItems(user.getDigitalItemList(), filePath);
	        }
	        
	        else if (fileExists == false) {
	        	database.loadDigItems(user.getDigitalItemList(), email);
	        }
		}
		
		else if(listType.equals("physItem")) {
			fileName += "_physItem_data.csv";
			filePath += fileName;
			
			boolean fileExists = fileCreator(filePath);
			
			if (fileExists == true) {
				database.updatePhysItems(user.getPhysicalItemList(), filePath);
	        }
	        
	        else if (fileExists == false) {
	        	database.loadPhysItems(user.getPhysicalItemList(), email);
	        }
			
		}
	}
}
