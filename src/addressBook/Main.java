package addressBook;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<Entry> addressBook = new ArrayList<>();

    public String addEntry(Entry entry){

    }

    public String removeEntry(String email){

    }

    public List<Entry> searchEntry(int searchType, String searchQuery){

    }

    public void printBook(){
        for (Entry entry : addressBook) {
            System.out.println(entry.toString() + "\n");
        }
    }

    public void deleteBook(){
        addressBook.clear();
        System.out.println("Address book cleared!");
    }

    public static void main(String[] args) {

    }
}
