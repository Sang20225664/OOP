package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Tạo một cửa hàng
        Store store = new Store();

        // Tạo các DVD mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Animation", "The Lion King", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Science Fiction", "Star Wars", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation", "Aladdin", 18.99f);

        // Thêm DVD vào cửa hàng
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        // In danh sách DVD trong cửa hàng
        store.printStoreItems();

        // Xóa một DVD khỏi cửa hàng
        store.removeDVD(dvd2);

        // In danh sách DVD sau khi xóa
        store.printStoreItems();

        // Thử xóa một DVD không có trong cửa hàng
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Fantasy", "Harry Potter", "Chris Columbus", 152, 30.00f);
        store.removeDVD(dvd4);
    }
}
