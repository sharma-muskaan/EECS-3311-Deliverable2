import java.util.List;

public class ConcreteIterator implements Iterator {

//    private LibraryDatabase collection;
//    private String iterationState;
	
	private List<DigitalItem> items;
    
    private int position = 0;

//    public ConcreteIterator(LibraryDatabase db){
//        this.collection = db;
//    }
    
    public ConcreteIterator(List<DigitalItem> items) {
        this.items = items;
    }
    
    @Override
    public Item getNext(){
        if (hasNext()) {
            return items.get(position++);
        }
        return null;
    }
   

	@Override
	public boolean hasNext() {
		return position < items.size();
	}

}
