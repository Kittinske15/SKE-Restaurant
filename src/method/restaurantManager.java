package method;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class restaurantManager {
	private String[] items;
	private double[] prices;
	public List<Food> foodArrayList = new ArrayList<Food>();

	public String[] getMenuItems() {
		String[] items = new String[foodArrayList.size()];
		for (int i = 0; i < foodArrayList.size(); i++) {
			items[i] = foodArrayList.get(i).getName();
		}
		return items;
	}

	public double[] getPrices() {
		double[] prices = new double[foodArrayList.size()];
		for (int i = 0; i < foodArrayList.size(); i++) {
			prices[i] = foodArrayList.get(i).getPrices();
		}
		return prices;
	}

	

	public void init(String file) {
		String menu = file;
		ClassLoader loader = restaurantManager.class.getClassLoader();
		InputStream input = loader.getResourceAsStream(file);
		if (input == null) {
			System.out.println("Could not access file " + file);
			return;
		}
		Scanner scan = new Scanner(input);
		while (scan.hasNextLine()) {
			String[] food = scan.nextLine().split(";");
			foodArrayList.add(new Food(food[0], Double.parseDouble(food[1])));
		}
		items = new String[foodArrayList.size()];
		prices = new double[foodArrayList.size()];
		for (int i = 0; i < foodArrayList.size(); i++) {
			items[i] = foodArrayList.get(i).getName();
			prices[i] = foodArrayList.get(i).getUnitPrice();
		}
	}
}
