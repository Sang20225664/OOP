package hust.soict.dsai.aims.screen;

import java.io.IOException;


import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

public class CartScreen extends JFrame {
	private Store store;
    private Cart cart;
    static {
		Platform.startup(() -> {
		});
	}
    private void initializeFxPanel(JFXPanel fxPanel) {
		Platform.runLater(() -> {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
				CartScreenController controller = new CartScreenController(store, cart, this);
				loader.setController(controller);
				Parent root = loader.load();
				fxPanel.setScene(new Scene(root));
			} catch (IOException e) {
				e.printStackTrace();
			} catch (LimitExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
    
    public CartScreen(Store store, Cart cart) {
        super();
        this.cart = cart;
        this.store = store;
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(800, 600);
        this.setVisible(true);

        Platform.runLater(() -> {
            try {
                // Load FXML and controller
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/screen/fxml/cart.fxml"));
                CartScreenController controller = new CartScreenController(store, cart, null);
                loader.setController(controller);
                Parent root = loader.load();

                // Create a VBox to hold the MenuBar and the root content
                VBox vbox = new VBox();
                MenuBar menuBar = createMenuBar();
                vbox.getChildren().addAll(menuBar, root);

                fxPanel.setScene(new Scene(vbox));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (LimitExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
    }
    
    private MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();

        Menu menuUpdateStore = new Menu("Update Store");
        MenuItem addBook = new MenuItem("Add Book");
        MenuItem addCD = new MenuItem("Add CD");
        MenuItem addDVD = new MenuItem("Add DVD");

        // Add actions
        addBook.setOnAction(e -> Platform.runLater(() -> new AddBookToStoreScreen(store).setResizable(true)));
        addCD.setOnAction(e -> Platform.runLater(() -> new AddCompactDiscToStoreScreen(store).setVisible(true)));
        addDVD.setOnAction(e -> Platform.runLater(() -> new AddDigitalVideoDiscToStoreScreen(store).setResizable(true)));

        menuUpdateStore.getItems().addAll(addBook, addCD, addDVD);
        menuBar.getMenus().add(menuUpdateStore);

        return menuBar;
    }
    public static void main(String[] args) throws LimitExceededException, IllegalArgumentException {
        // Create new DigitalVideoDiscs (DVDs)
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Avatar", "Sci-fi", "James Cameron", 162);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Avengers", "Action", "Joss Whedon", 143);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Coco", "Animation", "Lee Unkrich", 105);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Gladiator", "Historical Drama", "Ridley Scott", 155);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Finding Nemo", "Animation", "Andrew Stanton", 100);

        // Create new Tracks for CompactDiscs
        Track track1 = new Track("Moonlight Sonata", 15);
        Track track2 = new Track("Symphony No. 5", 25);
        Track track3 = new Track("Fur Elise", 6);
        Track track4 = new Track("Clair de Lune", 9);
        Track track5 = new Track("Bolero", 13);

        // Create new CompactDiscs (CDs)
        CompactDisc cd1 = new CompactDisc("Classical Legends", "Classical", "Various", 35.99f);
        cd1.addTrack(track1);
        cd1.addTrack(track2);

        CompactDisc cd2 = new CompactDisc("Piano Collection", "Classical", "Beethoven", 29.95f);
        cd2.addTrack(track3);

        CompactDisc cd3 = new CompactDisc("Relaxing Melodies", "Ambient", "Various", 20.00f);
        cd3.addTrack(track4);
        cd3.addTrack(track5);

        // Create a new Cart and add media items
        Cart shoppingCart = new Cart();
        shoppingCart.addMedia(dvd1);
        shoppingCart.addMedia(dvd2);
        shoppingCart.addMedia(dvd3);
        shoppingCart.addMedia(dvd4);
        shoppingCart.addMedia(dvd5);
        shoppingCart.addMedia(cd1);
        shoppingCart.addMedia(cd2);
        shoppingCart.addMedia(cd3);

        // Create a Store and display the Cart screen
        Store mediaStore = new Store();
        new CartScreen(mediaStore, shoppingCart);
    }
}