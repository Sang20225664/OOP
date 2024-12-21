package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
	public CompactDisc(int id, String title, String category, float cost, String director, String artists) {
		super(id, title, category, cost, director, 0);
		this.setArtists(artists);
	}
	public CompactDisc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	public CompactDisc(String string, String string2, String string3, float f) {
		// TODO Auto-generated constructor stub
		super(string, string2, string3, f);
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
	
	public void play() throws PlayerException {
	    // Kiểm tra độ dài của CompactDisc
	    if (this.getLength() > 0) {
	        // TODO: Phát tất cả các track trong CompactDisc
	        java.util.Iterator<Track> iter = tracks.iterator(); // Lấy iterator cho danh sách tracks
	        Track nextTrack;
	        
	        while (iter.hasNext()) {
	            nextTrack = iter.next(); // Lấy track tiếp theo
	            try {
	                nextTrack.play(); // Phát track
	            } catch (PlayerException e) {
	                // In thông báo lỗi và tiếp tục với track kế tiếp
	                System.err.println("ERROR: Cannot play track. " + e.getMessage());
	                throw e; // Nếu muốn dừng toàn bộ, ném lại ngoại lệ
	            }
	        }
	    } else {
	        // Nếu độ dài CompactDisc <= 0, ném ngoại lệ
	        System.err.println("ERROR: CD length is non-positive!");
	        throw new PlayerException("ERROR: CD length is non-positive!");
	    }
	}

	public void print() {
        System.out.println(getId() + ". CD - "
                + getTitle() + " - " + getCategory() + " - "
                + getDirector() + " - " + artists + " - "
                + getCost() + "$");
    }

}
