module lab04 {
    // Các module Java cơ bản được yêu cầu
    requires java.desktop;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires java.base;

    // Mở các package để JavaFX có thể sử dụng reflection
    opens hust.soict.dsai.aims.media to javafx.base, javafx.fxml;
    opens hust.soict.dsai.aims.cart to javafx.fxml;
    opens hust.soict.dsai.aims.store to javafx.fxml;
    opens hust.soict.dsai.aims.screen to javafx.fxml;
    opens application to javafx.graphics, javafx.fxml;

    // Xuất các package để chúng có thể được truy cập bởi các module khác
    exports hust.soict.dsai.aims.media;
    exports hust.soict.dsai.aims.cart;
    exports hust.soict.dsai.aims.store;
    exports hust.soict.dsai.aims.screen;
    exports hust.soict.dsai.aims.exception;
}
