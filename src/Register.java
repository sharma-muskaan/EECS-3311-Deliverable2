public class Register {


    protected String email;
    protected String password;
    protected String accType;
    public boolean approved;

    protected String getEmail(){
        return this.email;
    }
    protected String getPass(){
        return this.password;

    }
    protected String getAccType(){
        return this.accType;
    }

    protected void setEmail(String email){
        this.email = email;
    }
    protected void setPassword(String pass){
        this.password = pass;
    }
    protected void setAccType(String type){
        this.accType = type;
    }
    public void setApproved(boolean approved) {
    	this.approved = approved;
    }
    
    




}
