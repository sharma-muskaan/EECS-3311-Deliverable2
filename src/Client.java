public class Client {
	public static void main(String [] args) throws Exception{
		LibraryDatabase database = LibraryDatabase.getInstance();
		LibraryHomePage homePage = LibraryHomePage.getInstance();
		// All loaders for main DB assume that CSV files already exist
		// This can be changed later as needed using a branch of the doesListExist method
		database.loadDigItems(LibraryDatabase.digItemsDB, null);
		database.loadPhysItems(LibraryDatabase.physItemsDB, null);
		database.loadAccounts();
		//database.loadBankData();
		homePage.loggedOutHomePage();
	}
}