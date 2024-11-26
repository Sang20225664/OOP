package hust.soict.dsai.aims.store;
import java.util.ArrayList;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<>(); // Danh sách DVD trong cửa hàng

    // Phương thức thêm DVD vào cửa hàng
    public void addDVD(DigitalVideoDisc disc) {
        if (disc != null) {
            itemsInStore.add(disc);
            System.out.println("Added DVD: " + disc.getTitle());
        } else {
            System.out.println("Cannot add null DVD!");
        }
    }

    //  xóa DVD khỏi cửa hàng
    public void removeDVD(DigitalVideoDisc disc) {
        if (itemsInStore.contains(disc)) {
            itemsInStore.remove(disc);
            System.out.println("Removed DVD: " + disc.getTitle());
        } else {
            System.out.println("DVD not found in the store!");
        }
    }

    // liệt kê các DVD trong cửa hàng
    public void printStoreItems() {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            System.out.println("****************** STORE ITEMS ******************");
            for (DigitalVideoDisc disc : itemsInStore) {
                System.out.println(disc.toString());
            }
            System.out.println("************************************************");
        }
    }
}
