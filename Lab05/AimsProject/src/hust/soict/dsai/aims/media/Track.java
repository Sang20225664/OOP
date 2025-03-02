package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable{
	private String title;
	private int length;
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public void play() throws PlayerException {
	    if (this.getLength() > 0) {
	        // TODO: Thực hiện logic phát Track
	        System.out.println("Playing Track: " + this.getTitle());
	        System.out.println("Track length: " + this.getLength());
	    } else {
	        // In thông báo lỗi và ném ngoại lệ
	        System.err.println("ERROR: Track length is non-positive!");
	        throw new PlayerException("ERROR: Track length is non-positive!");
	    }
	}

	public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Track track = (Track) obj;
        return length == track.length && title.equals(track.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode() + length;
    }
}
