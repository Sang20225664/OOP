package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.Media;
public class Cart {
	 
	 public ArrayList<Media> itemsOrdered = new ArrayList<>();
	 
	 public void addMedia(Media media) {
	        if (!itemsOrdered.contains(media)) {
	            itemsOrdered.add(media);
	            System.out.println("Added to cart: " + media.getTitle());
	        } else {
	            System.out.println(media.getTitle() + " is already in the cart!");
	        }
	    }
	 public void removeMedia(Media media) {
	        if (itemsOrdered.contains(media)) {
	            itemsOrdered.remove(media);
	            System.out.println("Removed from cart: " + media.getTitle());
	        } else {
	            System.out.println(media.getTitle() + " is not in the cart!");
	        }
	    }
	 
	 public float totalCost() {
	        float total = 0.0f;
	        for (Media media : itemsOrdered) {
	            total += media.getCost();
	        }
	        return total;
	    }
	
	
	
	 public void printCart() {
	        System.out.println("***********************CART***********************");
	        if (itemsOrdered.isEmpty()) {
	            System.out.println("The cart is empty.");
	        } else {
	            System.out.println("Ordered Items:");
	            for (int i = 0; i < itemsOrdered.size(); i++) {
	                System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
	            }
	            System.out.println("Total cost: " + totalCost() + " $");
	        }
	        System.out.println("***************************************************");
	    }
	 public void searchById(int id) {
	        boolean found = false;
	        for (Media media : itemsOrdered) {
	            if (media.getId() == id) {
	                System.out.println("Found Media: " + media.toString());
	                found = true;
	                break;
	            }
	        }
	        if (!found) {
	            System.out.println("No Media found with ID: " + id);
	        }
	    }

	    // Tìm kiếm Media theo tiêu đề
	 public Media searchByTitle(String title) {
	        for (Media media : itemsOrdered) {
	            if (media.getTitle().equalsIgnoreCase(title)) {
	                return media;
	            }
	        }
	        return null;
	    }
	    public void sortByTitleCost() {
	        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	    }

	    public void sortByCostTitle() {
	        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	    }
}
