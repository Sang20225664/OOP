package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	public CompactDisc(int id, String title, String category, float cost, String director, String artists) {
		super(id, title, category, cost, director, 0);
		this.setArtists(artists);
	}
	private void setArtists(String artists) {
		// TODO Auto-generated method stub
		this.artists = artists;
	}
	private String artists;
	private ArrayList<Track> tracks = new ArrayList<>();

	public String getArtists() {
		return artists;
	}
	public void addTrack(Track track) {
		if(!tracks.contains(track)) {
			tracks.add(track);
		}
	}
	public void removeTrack(Track track) {
		tracks.remove(track);
	}
	public float getLength() {
		int l = 0;
		for(Track t : tracks) {
			l += t.getLength();
		}
		return l;
	}
	
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing CD: " + getTitle());
		System.out.println("CD artist: " + artists);
        System.out.println("CD length: " + this.getLength());
		for(Track t : tracks) {
			t.play();
		}
	}
	public void print() {
        System.out.println(getId() + ". CD - "
                + getTitle() + " - " + getCategory() + " - "
                + getDirector() + " - " + artists + " - "
                + getCost() + "$");
    }

}
