package hust.soict.dsai.aims.media;

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
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing track: " + title);
        System.out.println("Track length: " + length + " seconds");
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
