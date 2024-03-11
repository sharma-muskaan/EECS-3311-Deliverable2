import java.util.ArrayList;
import java.util.Date;

public interface Account  {
	
	public ArrayList<DigitalItem> digitalItemList = new ArrayList<>();
	public ArrayList<PhysicalItem> physicalItemList = new ArrayList<>();
	
	public String getEmail();
  
	public String getPassword();
    	
    public String getAccType();
    
    public void setEmail(String email);
    
    public void setPassword(String pass);
    
    public void setAccType(String type);
    
    public void setApproved(boolean approved);
	
	public void openOnlineBook(DigitalItem digItem);
	
	public ArrayList<Item> search(String search);
	
	public void subToNews(DigitalItem digItem);
	
	public void rentBook(PhysicalItem physItem);
	
	public void purchaseItem(Item item);
	
	public Date getDueDate();
	
	public void returnBook(PhysicalItem physItem);
	
}
