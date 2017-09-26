package method;

import java.util.Scanner;

public class retaurant {
	public static void menu(int collectp, int collectck, int collectcoke, int pay) {
		System.out.print("+------ Menu ------+---- Qty ----+----- Price --+\n");
		if (collectp > 0)
			System.out.printf("|\tPizza\t   |\t %2d\t |\t%5d\t|\n", collectp, collectp * 250);
		if (collectck > 0)
			System.out.printf("|\tChickens   |\t %2d\t |\t%5d\t|\n", collectck, collectck * 120);
		if (collectcoke > 0)
			System.out.printf("|\tCoke\t   |\t %2d\t |\t%5d\t|\n", collectcoke, collectcoke * 45);
		System.out.print("+-----------------------------------------------+\n");
		System.out.printf("|\tTotal\t\t\t  %11d - |\n", collectp * 250 + collectck * 120 + collectcoke * 45);
		System.out.print("|\t\t\t\t      --------  |\n");
		System.out.printf("|\tCus pay\t\t\t     %8d   |\n", pay);
		System.out.printf("|\tChange\t\t\t\t%5d\t|\n", pay - (collectp * 250 + collectck * 120 + collectcoke * 45));
		System.out.print("|\t\t\t\t      ========  |\n");
		System.out.print("+-----------------------------------------------+\n");

	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("---------- Welcome to SKE Restaurant ----------\n");
		System.out.printf("1.) Pizza\t %5d Baht.%n", 250);
		System.out.printf("2.) Chickens\t %5d Baht.%n", 120);
		System.out.printf("3.) Coke\t %5d Baht.%n", 45);
		System.out.printf("4.) Total%n");
		System.out.printf("5.) Exit%n");
		int choice = 0;
		int collectp = 0;
		int collectck = 0;
		int collectcoke = 0;
		int total = 0;
		int pay = 0;
		while (true) {
			System.out.print("Enter your choice: ");
			choice = scan.nextInt();
			if (choice == 5) {
				break;
			} else if (choice == 4) {
				System.out.print("Customer pay: ");
				pay = scan.nextInt();
				menu(collectp, collectck, collectcoke, pay);

			} else {
				System.out.print("Enter Qantity: ");

				int quantity = scan.nextInt();
				if (choice == 1) {
					collectp = collectp + quantity;
				} else if (choice == 2) {
					collectck = collectck + quantity;
				} else if (choice == 3) {
					collectcoke = collectcoke + quantity;
				}

			}

		}
		System.out.print("================== Thank you ==================");
	}
}