package method;

public class Food {

	private String name;
	private double prices;
	private int quantity = 0;
	private String items;

	public Food(String name, double price) {
		this.items = name;
		this.prices = price;
	}

	public String getName() {
		return items;
	}

	public double getPrices() {
		return prices;
	}

	public int getQuantity() {
		return quantity;
	}

	public int addQuantity(int plus) {
		return quantity += plus;
	}
	
	public double getUnitPrice(){
		return prices;
	}

}
