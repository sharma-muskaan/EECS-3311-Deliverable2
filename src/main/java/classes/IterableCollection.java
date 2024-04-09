package classes;
import java.util.ArrayList;

interface IterableCollection {
    public Iterator createIterator(ArrayList<Item> items);
}
