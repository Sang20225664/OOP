package hust.soict.dsai.aims.screen;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;

public abstract class AddItemToStoreScreen extends Stage {
    protected TextField tfTitle = new TextField();
    protected TextField tfCategory = new TextField();
    protected TextField tfCost = new TextField();
    protected Button btnAdd = new Button("Add");
    protected Button btnCancel = new Button("Cancel");

    public AddItemToStoreScreen() {
        VBox layout = new VBox(10);
        layout.getChildren().addAll(
            new Text("Title:"), tfTitle,
            new Text("Category:"), tfCategory,
            new Text("Cost:"), tfCost,
            btnAdd, btnCancel
        );

        btnCancel.setOnAction(e -> this.close());

        this.setScene(new Scene(layout, 300, 250));
        this.setTitle("Add Item to Store");
    }

    protected abstract void handleAdd();
}
