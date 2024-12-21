package hust.soict.dsai.aims.screen;

import java.awt.Label;
import java.awt.event.ActionEvent;


import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.exception.InvalidDataException;
import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartScreenController {
    private Cart cart;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

	private static Store store;

	private static JFrame stage;

    public CartScreenController(Store store, Cart cart, JFrame stage) throws LimitExceededException {
    	super();
    	this.store = store;
		this.cart = cart;
		this.stage = stage;

        // Sample data
        cart.addMedia(new DigitalVideoDisc(1, "DVD1's Title", "category 1", 7.87f));
        cart.addMedia(new CompactDisc(2, "CD2's Title", "category 2", 19.21f));
        cart.addMedia(new Book(3, "Book3's Title", "category 3", 14.61f));
    }

    @FXML
    private void initialize() {
        // Set up the table columns
        System.out.println("Initializing...");
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        if (cart == null) {
            System.out.println("Cart is null!");
        } else if (cart.getItemsOrdered() == null) {
            System.out.println("ItemsOrdered is null!");
        } else {
            System.out.println("Cart size: " + cart.getItemsOrdered().size());
        }

        tblMedia.setItems(cart.getItemsOrdered());

        // Initially hide the buttons
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Listen for changes in the TableView selection
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue != null) {
                    updateButtonBar(newValue);
                }
            }
        });
    }

    private void updateButtonBar(Media media) {
        
        btnRemove.setVisible(true);
        if(media instanceof Playable) {
        	btnPlay.setVisible(true);
        }
        else {
        	btnPlay.setVisible(false);
        }
    }

    // Method to load and display the Cart Screen
    public static void showCartScreen(Cart cart) {
        try {
            FXMLLoader loader = new FXMLLoader(CartScreenController.class.getResource("/hust/soict/dsai/aims/screen/cart.fxml"));
            CartScreenController controller = new CartScreenController(store, cart, stage);
            loader.setController(controller);
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void btnRemovePressed(ActionEvent event) throws InvalidDataException {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    }
    @FXML
    private Label lblTotalCost;

    private void updateTotalCost() {
        float totalCost = cart.totalCost();
        lblTotalCost.setText("Total Cost: $" + totalCost);
    }

    @FXML
    private void btnPlaceOrderPressed() {
        System.out.println("Order placed successfully!");
        cart.clear();
        updateTotalCost();
    }
    public void handleAddMedia(Media selectedMedia) {
        try {
            cart.addMedia(selectedMedia); // Thử thêm media vào giỏ
        } catch (LimitExceededException e) {
            // Hiển thị thông báo lỗi
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}