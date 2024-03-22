//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        // Create some LibraryItems manually with titles, authors, and genres
//        List<DigitalItem> items = new ArrayList<>();
//        items.add(new DigitalItem("Ebook", "Fiction", "Book1", "Author1", "1st", "Publisher1"));
//        items.add(new DigitalItem("Audiobook", "Fiction", "Book2", "Author2", "2nd", "Publisher2"));
//        items.add(new DigitalItem("PDF", "Fantasy", "Book3", "Author3", "3rd", "Publisher3"));
//
//        // Create a LibraryDatabase
//        LibraryDatabase database = new LibraryDatabase(items);
//
//        // Get recommendations based on search query and genres and print them
//        String searchQuery = "Book1";
//        List<String> searchGenres = List.of("Fiction");
//        database.printSimilarItems(searchQuery, searchGenres);
//    }
//}
