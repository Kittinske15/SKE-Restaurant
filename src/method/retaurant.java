package method;

import java.util.Scanner;

public class retaurant {

	static int[] price = { 250, 120, 45 };
	static String[] menu = { "Pizza", "Chickens", "Coke" };
	static int[] collect = { 0, 0, 0 };

	public static void menu() {
		System.out.println("---------- Welcome to SKE Restaurant ----------");
		for (int i = 0; i < price.length; i++) {
			System.out.printf("%d.) %s\t %5d Baht.%n", i + 1, menu[i], price[i]);
		}
		System.out.printf("%d.) Total%n", menu.length + 1);
		System.out.printf("%d.) Exit%n", menu.length + 2);
	}

	public static int total() {
		int sum = 0;
		for (int s = 0; s < collect.length; s++) {
			sum += collect[s] * price[s];
		}
		return sum;
	}

	public static void menu(int pay) {
		System.out.print("+------ Menu ----+---- Qty ------+----- Price --+\n");
		for (int i = 0; i < menu.length; i++) {
			if (collect[i] > 0)
				System.out.printf("|\t%-8s |\t %2d\t |\t%5d\t|\n", menu[i], collect[i], collect[i] * price[i]);
		}
		System.out.print("+-----------------------------------------------+\n");
		System.out.printf("|%7s%-24s  %11d - |\n", "","Total",total());
		System.out.printf("|%39s" + "------- |\n","");
		System.out.printf("|%7s%-24s     %8d   |\n","","cus pay", pay);
		System.out.printf("|\tChange\t\t\t\t%5d\t|\n", pay - total());
		System.out.printf("|%39s======= |\n","");

		System.out.print("+-----------------------------------------------+\n");
        
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		menu();
		int choice = 0;
		int pay = 0;
		while (true) {
			System.out.print("Enter your choice: ");
			choice = scan.nextInt();
			if (choice == 5) {
				break;
			} else if (choice == 4) {
				System.out.print("Customer pay: ");
				pay = scan.nextInt();
				menu(pay);

			} else {
				System.out.print("Enter Qantity: ");

				int quantity = scan.nextInt();
				if (choice == 1) {
					collect[0] = collect[0] + quantity;
				} else if (choice == 2) {
					collect[1] = collect[1] + quantity;
				} else if (choice == 3) {
					collect[2] = collect[2] + quantity;
				}
			}
		}
		System.out.print("================== Thank you ==================");
	}
}