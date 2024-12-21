package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	private String director;
	
	public Media(int id, String title) {
        this.id = id;
        this.title = title;
    }
	public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
	public Media(int id, String title, String category, float cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	 public Media(String title, String category, String director, float cost) {
		// TODO Auto-generated constructor stub
		 this.title = title;
			this.category = category;
			this.director = director;
			this.cost = cost;
			
	}
	public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getCategory() {
	        return category;
	    }

	    public void setCategory(String category) {
	        this.category = category;
	    }

	    public float getCost() {
	        return cost;
	    }

	    public void setCost(float cost) {
	        this.cost = cost;
	    }
	    public boolean isMatch(int id) {
	    	return this.getId() == id;
	    }
	    public boolean isMatch(String title){
			return (this.getTitle().toLowerCase().equals(title.toLowerCase()));
		}
	
	@Override
	public boolean equals(Object obj) {
	    // Kiểm tra nếu đối tượng so sánh là null
	    if (obj == null) {
	        return false;
	    }

	    // Kiểm tra kiểu của đối tượng bằng `instanceof`
	    if (!(obj instanceof Media)) {
	        return false;
	    }

	    // Ép kiểu đối tượng về Media
	    Media media = (Media) obj;

	    // Kiểm tra tiêu đề có null không và so sánh tiêu đề
	    if (this.title == null || media.getTitle() == null) {
	        return false;
	    }

	    // So sánh tiêu đề, không phân biệt chữ hoa chữ thường
	    return this.title.equalsIgnoreCase(media.getTitle());
	}


    @Override
    public String toString() {
        return "Media [id=" + '\'' + id + '\'' + ", title=" + '\'' + title  + '\''
                + ", category=" + category+ ", cost=" + cost + "]";
    }


    public void displayDetails() {
        System.out.println("----------------MEDIA's DETAILs----------------");
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Category: " + category);
        System.out.println("Cost: " + cost);
        System.out.println("---------------END-----------------");
    }

    public boolean searchMediaByTitle(String title) {
        String[] words = title.split(" ");
        for (String word : words) {
            if (this.title.contains(word)) {
                return true;
            }
        }
        return false;
    }

    public abstract void print();



    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
}
