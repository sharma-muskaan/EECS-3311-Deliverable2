public class Client {
	public static void main(String [] args) throws Exception{
		LibraryDatabase database = LibraryDatabase.getInstance();
		LibraryHomePage homePage = LibraryHomePage.getInstance();
		database.loadAccounts();
		//database.loadUsers();
		//database.loadDigItems();
		//database.loadPhysItems();
		//database.loadBankData();
		homePage.loggedOutHomePage();
	}
}