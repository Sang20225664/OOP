package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Tạo giỏ hàng mới
        Cart cart = new Cart();

        // Tạo các DVD mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        // Thêm DVD vào giỏ hàng
        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);

        // In giỏ hàng
        cart.printCart();

        // Tìm kiếm DVD theo ID
        System.out.println("\nSearch by ID:");
        cart.searchById(2); // Tìm DVD có ID = 2
        cart.searchById(5); // Tìm DVD không tồn tại

        // Tìm kiếm DVD theo tiêu đề
        System.out.println("\nSearch by Title:");
        cart.searchByTitle("Star");  // Tìm DVD có tiêu đề chứa "Star"
        cart.searchByTitle("Harry"); // Tìm DVD không tồn tại
    }
}
