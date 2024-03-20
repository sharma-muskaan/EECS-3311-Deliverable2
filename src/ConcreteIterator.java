public class ConcreteIterator {

    private LibraryDatabase collection;
    private String iterationState;

    public ConcreteIterator(LibraryDatabase db){
        this.collection = db;
    }

    public void getNext(){

    }
    
    public boolean hasMore(){
        return false;
    }

}
