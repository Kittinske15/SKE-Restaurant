package method;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class OrderMenu {

	static private RestaurantManager file = new RestaurantManager();
	static private Scanner scan = new Scanner(System.in);

	static double[] prices;
	static String[] menuItems;
	static int[] collect;
	

	
	public static void setPrice() {
		prices = file.getPrices();
	}

	public static void setOrder() {
		menuItems = file.getMenuItems();
		collect = new int[menuItems.length];
	}

	public static int getIntReply(String prompt) {
		System.out.print(prompt);
		int s = scan.nextInt();
		return s;
	}

	public static String getStringReply(String prompt) {
		System.out.print(prompt);
		String s = scan.next();
		return s;
	}

	public static void menu() {
		System.out.println("--------------- Welcome to SKE Restaurant ---------------");
		for (int i = 0; i < menuItems.length; i++) {
			System.out.printf("%d.) %-20s %5.0f Baht.%n", i + 1, menuItems[i], prices[i]);
		}
		System.out.println();

		System.out.println(" [e] Edit order");
		System.out.println(" [p] Print order");
		System.out.println(" [x] Cancel order");
		System.out.println(" [c] Checkout");
	}

	public static int total() {
		int sum = 0;
		for (int s = 0; s < menuItems.length; s++) {
			sum += collect[s] * prices[s];
		}
		return sum;
	}

	public static void totalMenu(double pay) {
		System.out.print("+------ Menu --------+------ Qty --------+----- Price --+\n");
		for (int i = 0; i < menuItems.length; i++) {
			if (collect[i] > 0)
				System.out.printf("|%-20s|%-7s%2d%-9s |%-6s%5.0f\t|\n", menuItems[i], "", collect[i], "", "",
						collect[i] * prices[i]);
		}
		System.out.print("+-------------------------------------------------------+\n");
		System.out.printf("|%7s%-32s  %11d - |\n", "", "Total", total());
		System.out.printf("|%46s" + "-------  |\n", "");
		System.out.printf("|%7s%-32s     %8.0f   |\n", "", "cus pay", pay);
		System.out.printf("|\tChange%-31s%8.0f\t|\n", "", pay - total());
		System.out.printf("|%46s=======  |\n", "");

		System.out.print("+-------------------------------------------------------+\n");

	}

	public static void showMenu() {

		while (true) {
			String choice = getStringReply("Enter your Choice: ");
			if (choice.equals("p")){
				System.out.print("Cus pay: ");
				int pay = scan.nextInt();
				totalMenu(pay);
			}
			else if (choice.equals("e"))
				editMenu();
			else if (choice.equals("x"))
				cancelMenu();
			else if (choice.equals("c"))
				break;
			if (choice.charAt(0) > 48 && choice.charAt(0) < 57) {
				int choicenum = Integer.parseInt(choice);
				int quan = getIntReply("Enter your Quantity: ");
				collect[choicenum - 1] += quan;
			}

		}
		System.out.print("======================= Thank you =======================");
	}

	public static void editMenu() {
		int editNum = getIntReply("Edit number: ");
		int collectMenu = getIntReply("Change quantity: ");
		collect[editNum - 1] = collectMenu;

	}

	public static void cancelMenu() {
		int cancelNum = getIntReply("Cancel number: ");
		collect[cancelNum - 1] = 0;
	}

	public static void main(String[] args) {
		file.init("menu");
		setOrder();
		setPrice();
		menu();
		showMenu();
		Date date = new Date();
		System.out.print("\n"+date);

	}
}
