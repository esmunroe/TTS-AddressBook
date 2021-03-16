package addressBook;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<Entry> addressBook = new ArrayList<>();

    public String addEntry(Entry entry){
        if (addressBook.contains(entry)){
            return "Error! This entry contains an email address already in the book.";
        }
        addressBook.add(entry);
        return entry.toString() + "\nAdded new entry!";
    }

    public boolean removeEntry(String email){
        for (int i = 0; i < addressBook.size(); i++) {
            if (addressBook.get(i).getEmailAddress().equals(email)) {
                System.out.println("Deleted the following entry:\n" + addressBook.get(i).toString());
                return true;
            }
        }
        return false;
    }

    public List<Entry> searchEntry(String searchType, String searchQuery){
        List<Entry> result = new ArrayList<>();

        switch (searchType){
            case "first":
                for (Entry entry : addressBook){
                    if (entry.getFirstName().contains(searchQuery)){
                        result.add(entry);
                    }
                }
                break;
            case "last":
                for (Entry entry : addressBook){
                    if (entry.getLastName().contains(searchQuery)){
                        result.add(entry);
                    }
                }
                break;
            case "phone":
                for (Entry entry : addressBook){
                    if (entry.getPhoneNumber().contains(searchQuery)){
                        result.add(entry);
                    }
                }
                break;
            case "email":
                for (Entry entry : addressBook){
                    if (entry.getEmailAddress().contains(searchQuery)){
                        result.add(entry);
                    }
                }
                break;
            default:
                System.out.println("Invalid search option!");
        }

        return result;
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
