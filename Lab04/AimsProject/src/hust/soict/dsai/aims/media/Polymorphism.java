package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Polymorphism {
    public static void main(String[] args) {
        List<Media> media = new ArrayList<Media>();

        CompactDisc cd = new CompactDisc(1, "CD1", "Category1", 10.0f, "Artist1" , "Artist2");
        DigitalVideoDisc dvd = new DigitalVideoDisc(2, "The Matrix", "Science Fiction", 19.99f, "The Wachowskis", 136);
        Book book = new Book(3, "Effective Java", "Programming", 45.99f);

        media.add(cd);
        media.add(dvd);
        media.add(book);

        for (Media m : media) {
            System.out.println(m.toString());
        }

    }
}