package hust.soict.dsai.aims.disc;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Playable;

public class DigitalVideoDisc extends Disc implements Playable{
	
	private String title;
//	private String category;
//	private String director;
	private int length;
//	private float cost;
//	
//	private static int nbDigitalVideoDiscs = 0;
//	private int id;
//	
	public String getTitle() {
		return title;
	}
//	public String getCategory() {
//		return category;
//	}
//	public String getDirector() {
//		return director;
//	}
	public float getLength() {
		return length;
	}
//	public float getCost() {
//		return cost;
//	}
//	public void setTitle(String title) {
//		this.title = title;
		
//	}
	public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost, director, length);
    }
	public DigitalVideoDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }
//	public static int getNbDigitalVideoDiscs() {
//        return nbDigitalVideoDiscs;
//    }
//    public int getId() {
//        return id;
//    }

	public DigitalVideoDisc( String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }
	
	public DigitalVideoDisc(int id, String title, String category, String director, int length,
			float cost) {
		// TODO Auto-generated constructor stub
		super(id, title, category, length, director, cost);
	}
	//	public DigitalVideoDisc(String title) {
//		this.title = title;
//		nbDigitalVideoDiscs++; 
//        this.id = nbDigitalVideoDiscs;
//	}
//	public DigitalVideoDisc(String category, String  title, float cost) {
//		this.category = category;
//		this.title = title;
//		this.cost = cost;
//		nbDigitalVideoDiscs++; 
//        this.id = nbDigitalVideoDiscs;
//	}
//	public DigitalVideoDisc(String title, String category, String director, float cost) {
//		this.title = title;
//		this.category = category;
//		this.director = director;
//		this.cost = cost;
//		nbDigitalVideoDiscs++; 
//        this.id = nbDigitalVideoDiscs;
//	}
//	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
//		this.title = title;
//		this.category = category;
//		this.director = director;
//		this.length = length;
//		this.cost = cost;
//		nbDigitalVideoDiscs++; 
//        this.id = nbDigitalVideoDiscs;
//	}
//	public boolean isMatch(String title) {
//        return this.title.toLowerCase().contains(title.toLowerCase());
//    }
	public void print() {
        System.out.println(getId() + ". DVD - " + this.getTitle() + " - " + this.getCategory()
                + " - " + this.getDirector() + " - " + this.getLength() + " : " + this.getCost() + "$");
    }
	public void play() throws PlayerException {
	    if (this.getLength() > 0) {
	        // TODO: Thực hiện logic phát DigitalVideoDisc (DVD)
	        System.out.println("Playing DVD: " + this.getTitle());
	        System.out.println("DVD length: " + this.getLength());
	    } else {
	        // In thông báo lỗi và ném ngoại lệ
	        System.err.println("ERROR: DVD length is non-positive!");
	        throw new PlayerException("ERROR: DVD length is non-positive!");
	    }
	}

}
