package addressBook;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private List<Entry> addressBook;

    public AddressBook(){
        this.addressBook = new ArrayList<>();
    }

    public String addEntry(Entry entry){
        if (this.addressBook.contains(entry)){
            return "Error! This entry contains an email address already in the book.";
        }
        this.addressBook.add(entry);
        return entry.toString() + "\nAdded new entry!";
    }

    public boolean removeEntry(String email){
        for (int i = 0; i < this.addressBook.size(); i++) {
            if (this.addressBook.get(i).getEmailAddress().equals(email)) {
                System.out.println("Deleted the following entry:\n" + this.addressBook.get(i).toString());
                addressBook.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Entry> searchEntry(String searchType, String searchQuery){
        List<Entry> result = new ArrayList<>();

        switch (searchType){
            case "first":
                for (Entry entry : this.addressBook){
                    if (entry.getFirstName().contains(searchQuery)){
                        result.add(entry);
                    }
                }
                break;
            case "last":
                for (Entry entry : this.addressBook){
                    if (entry.getLastName().contains(searchQuery)){
                        result.add(entry);
                    }
                }
                break;
            case "phone":
                for (Entry entry : this.addressBook){
                    if (entry.getPhoneNumber().contains(searchQuery)){
                        result.add(entry);
                    }
                }
                break;
            case "email":
                for (Entry entry : this.addressBook){
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
        for (Entry entry : this.addressBook) {
            System.out.println(entry.toString() + "\n");
        }
    }

    public void deleteBook(){
        this.addressBook.clear();
        System.out.println("Address book cleared!");
    }
}
