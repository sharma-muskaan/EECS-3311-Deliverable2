public class LibraryDatabase {


    private LibraryDatabase db;


    LibraryDatabase(){

    }
    
    public Iterator createIterator(){
        return null;
    }

    public LibraryDatabase getInstance(){
        return this.db;
    }
    
    protected Item getItemInfo(){
        return null;
    }
    
    protected Account getAccInfo() {
    	
		return null;
    }
    
    protected void setAccInfo(Account account) {
    	
    }
}
