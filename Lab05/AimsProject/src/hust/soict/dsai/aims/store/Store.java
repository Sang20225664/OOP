package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>(); // Danh sách DVD trong cửa hàng

    // Phương thức thêm DVD vào cửa hàng
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Added to store: " + media.getTitle());
        } else {
            System.out.println(media.getTitle() + " is already in the store!");
        }
    }

    //  xóa DVD khỏi cửa hàng
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Removed from store: " + media.getTitle());
        } else {
            System.out.println(media.getTitle() + " is not in the store!");
        }
    }

    // liệt kê các DVD trong cửa hàng
        public void printStore() {
            System.out.println("***********************STORE***********************");
            if (itemsInStore.isEmpty()) {
                System.out.println("The store is empty.");
            } else {
                System.out.println("Items in Store:");
                for (int i = 0; i < itemsInStore.size(); i++) {
                    System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
                }
            }
            System.out.println("****************************************************");
        }
        public Media findMediaByTitle(String title) {
            for (Media media : itemsInStore) {
                if (media.getTitle().equalsIgnoreCase(title)) {
                    return media;
                }
            }
            return null;
        }


        // Search for media by ID
        public void searchById(int id) {
            boolean found = false;
            for (Media media : itemsInStore) {
                if (media.getId() == id) {
                    System.out.println("Found item: " + media.toString());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("No item found with ID: " + id);
            }
        }

        public ArrayList<Media> getItemsInStore() {
            return itemsInStore; // Trả về danh sách các Media trong store
        }

}
