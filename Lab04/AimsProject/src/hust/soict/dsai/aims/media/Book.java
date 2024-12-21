package hust.soict.dsai.aims.media;
import java.util.*;
public class Book extends Media{
	
	private ArrayList<String> authors = new ArrayList<>();
	
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	public void addAuthor(String author) {
		if(!author.contains(author)) {
			authors.add(author);
		}
	}
	public void removeAuthor(String author) {
		if(authors.contains(author)) {
			authors.remove(author);
		}
	}
	public String toString() {
		return "Book - " + super.toString() + " - Author: " + authors;
	}
	public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = (ArrayList<String>) authors;
    }
	@Override
	public void print() {
        System.out.print(getId() + ". Book - " + getTitle() + " - " + getCategory() + " : ");
        for (String author : authors) {
            System.out.println("Author: " + author);
        }
        System.out.println(getCost() + "$");
    }
}
