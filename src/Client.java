import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Client {
	public static void main(String [] args) throws Exception{
		LibraryDatabase database = LibraryDatabase.getInstance();
		LibraryHomePage homePage = new LibraryHomePage();
		// All loaders for main DB assume that CSV files already exist
		// This can be changed later as needed using a branch of the doesListExist method
		database.loadPhysItems(database.physItemsDB, null);
		database.loadCourses(database.coursesDB, null);
		database.loadDigItems(database.digItemsDB, null);
		database.loadAccounts();
		database.purgeFinishedCourses();
		//database.loadBankData();
		homePage.loggedOutHomePage();
	}
}