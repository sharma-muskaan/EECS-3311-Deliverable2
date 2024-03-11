import java.util.ArrayList;
import java.util.Date;

public class Decorator implements Account {
	
    protected String email;
    protected String password;
    protected String accType;
    protected boolean approved;

    public Decorator(String email, String password, String accType) {  
        this.email = email;
        this.password = password;
        this.accType = accType;
    }
    
//	public Account getAccount() {
//		return account;
//	}


//	public void setAccount(Account account) {
//		this.account = account;
//	}

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getAccType() {
        return accType;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setAccType(String accType) {
        this.accType = accType;
    }

    @Override
    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @Override
    public void openOnlineBook(DigitalItem digItem) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ArrayList<Item> search(String search) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void subToNews(DigitalItem digItem) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void rentBook(PhysicalItem physItem) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void purchaseItem(Item item) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Date getDueDate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void returnBook(PhysicalItem physItem) {
        // TODO Auto-generated method stub
        
    }

}
