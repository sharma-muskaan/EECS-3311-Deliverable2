public class Client {
	public static void main(String [] args) throws Exception{
		String path = "src/account_data.csv";
		LibraryHomePage homePage = new LibraryHomePage();
		
		homePage.load(homePage, path);
	}
}