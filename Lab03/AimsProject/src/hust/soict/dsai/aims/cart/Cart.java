package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	 private int qtyOrdered = 0; //dem so luong dvd trong gio 
	 public static final int MAX_NUMBERS_ORDERED = 20;
	 private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	 
	 
	 
	public float totalCost() {
		float total = 0.0f;
		for(int i = 0; i < qtyOrdered; i++) {
			total += itemOrdered[i].getCost();
		}
		return total;
	}
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		
		if(qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemOrdered[qtyOrdered] = disc;
			qtyOrdered++;
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		boolean found = false;
		for(int i = 0; i < qtyOrdered; i++) {
			if(itemOrdered[i] == disc) {
				found = true;
				for(int j = i; j < qtyOrdered - 1; j++) {
					itemOrdered[j] = itemOrdered[j+1];
				}
				itemOrdered[qtyOrdered -1] = null;
				qtyOrdered--;
				System.out.println("The disc \"" + disc.getTitle() + "\" has been removed.");
				break;
			}
			
			}
		if(!found) {
			System.out.println("Disc not found");
		}
	}
	public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        float totalCost = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemOrdered[i].toString());
            totalCost += itemOrdered[i].getCost();
        }
        System.out.println("Total cost: " + totalCost + " $");
        System.out.println("***************************************************");
    }
	 public void searchById(int id) {
	        boolean found = false;
	        for (int i = 0; i < qtyOrdered; i++) {
	            if (itemOrdered[i].getId() == id) {
	                System.out.println("Found DVD: " + itemOrdered[i].toString());
	                found = true;
	                break;
	            }
	        }
	        if (!found) {
	            System.out.println("No DVD found with ID: " + id);
	        }
	    }
	 public void searchByTitle(String title) {
	        boolean found = false;
	        for (int i = 0; i < qtyOrdered; i++) {
	            if (itemOrdered[i].isMatch(title)) {
	                System.out.println("Found DVD: " + itemOrdered[i].toString());
	                found = true;
	            }
	        }
	        if (!found) {
	            System.out.println("No DVD found with title containing: \"" + title + "\"");
	        }
	    }
}
