package cuppon;

public class Item {
	private int price;
	private String name;
	private String category;
	
	Item(String name, String category, int price){
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
