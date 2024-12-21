package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private VBox drawingAreaPane; // Khu vực vẽ

    @FXML
    private RadioButton penButton; // Nút bút

    @FXML
    private RadioButton eraserButton; // Nút tẩy

    @FXML
    private ToggleGroup toolsToggleGroup; // Nhóm toggle cho Pen và Eraser

    // Xóa toàn bộ canvas khi nhấn nút Clear
    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    // Xử lý sự kiện kéo chuột trên canvas
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // Kiểm tra xem Pen hay Eraser đang được chọn
        Color color = penButton.isSelected() ? Color.BLACK : Color.WHITE;

        // Vẽ một hình tròn tại vị trí con trỏ chuột
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
        drawingAreaPane.getChildren().add(newCircle);
    }
}
