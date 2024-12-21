package hust.soict.dsai.aims.cart;
import java.util.Collections;



import hust.soict.dsai.aims.exception.InvalidDataException;
import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Cart {
	

	private static final int MAX_NUMBERS_ORDERED = 100;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	 
	 public void addMedia(Media media) throws LimitExceededException, IllegalArgumentException{
			if (itemsOrdered.size() == 0) {
				itemsOrdered.add(media);
				System.out.println("This media has been added");
			}
			else if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
				int check = 0;
				for (int i = 0; i < itemsOrdered.size(); i++ ) {
					if (itemsOrdered.get(i).equals(media)) {
						check += 1;
					}
				}
				if (check == 0) {
					itemsOrdered.add(media);
					System.out.println("This media has been added");
				}
				else {
					throw new IllegalArgumentException("ERROR: This media is already in the cart");
				}

			}
			else {
				throw new LimitExceededException("ERROR: The number of media has reached its limit");
			}
		}


	public void removeMedia(Media m) throws InvalidDataException {
	    if (itemsOrdered.contains(m)) {
	        itemsOrdered.remove(m);
	        System.out.println("Removed from cart: " + m.getTitle());
	    } else {
	        throw new InvalidDataException("Media is not in the cart.");
	    }
	}

	 
	 public float totalCost() {
	        float total = 0.0f;
	        for (Media media : itemsOrdered) {
	            total += media.getCost();
	        }
	        return total;
	    }
	
	
	
	 public String printCart() {
	    	String info = "";
	        if (itemsOrdered.isEmpty()) {
	            info = "The cart is empty";
	        }
	        else {
	            info += ("***********************CART***********************\n");
	            info += "Ordered Items:\n";
	            for (Media item : itemsOrdered) {
	                info += (item.toString()) + "\n";
	            }
	            info = info + "Total cost: " + totalCost();
	            info += "***************************************************\n";
	        }
	        return info;
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
	 public Media searchByTitle(String title) throws InvalidDataException {
		    for (Media media : itemsOrdered) {
		        if (media.getTitle().equalsIgnoreCase(title)) {
		            return media;
		        }
		    }
		    throw new InvalidDataException("Media with title '" + title + "' not found.");
		}

	    public void sortByTitleCost() {
	        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	    }

	    public void sortByCostTitle() {
	        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	    }
	    public void filterById(int id) {
	    	int filtered = 0;
	    	for(Media item: itemsOrdered) {
	    		if (item.isMatch(id)) {
	    			System.out.println("Filter result: \n");
	    			System.out.println(item.toString());
	    			filtered = 1;
	    		}
	    	}
	    	if (filtered == 0) {
	    		System.out.println("No such media in cart!");
	    	}
	    }
	    public void filterByTitle(String title) {
	    	int filtered = 0;
	    	for(Media item: itemsOrdered) {
	    		if (item.isMatch(title)) {
	    			System.out.println("Filter result: \n");
	    			System.out.println(item.toString());
	    			filtered = 1;
	    		}
	    	}
	    	if (filtered == 0) {
	    		System.out.println("No such media in cart!");
	    	}
	    }
	    public ObservableList<Media> getItemsOrdered() {
			return itemsOrdered;
		}
		public void playMedia(String title) {
			Media media = null ;
			for (int i = 0; i < itemsOrdered.size(); i ++) {
				if (itemsOrdered.get(i).getTitle().equals(title)) {
					media = itemsOrdered.get(i);
					break;
				}
			}
			if (media instanceof Playable) {
				try {
					((Playable) media).play();
				}catch (PlayerException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	    public void clear() {
	        itemsOrdered.clear();
	    }


}
