package hust.soict.dsai.aims.media;
public class Disc extends Media {
    private float length;
    private String director;
    public Disc(int id, String title, String category, float cost,  String director,float length) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }
    public Disc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }
    public Disc(int id, String title) {
        super(id, title);
    }
    public Disc(String title, String category, String director, float cost) {
		// TODO Auto-generated constructor stub
    	super(title, category, director, cost);
	}
	
	public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }
    @Override
    public void print() {
        System.out.println("Disc [ID: " + getId() + ", Title: " + getTitle() + ", Category: " + getCategory()
                + ", Cost: " + getCost() + ", Director: " + director + ", Length: " + length + "]");

    }

}