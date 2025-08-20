package com.kozao.views;

import java.util.Scanner;

public class HomePage {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String value;
		char val;
		boolean r = true;

		do {

			Dashboard();

			value = sc.nextLine();

			value = value.toLowerCase();

			if (value.length() == 1) {

				val = value.charAt(0);
				switch (val) {

				case 'a':
					Login.main(args);
					r = false;
					break;

				case 'b':
					System.out.println("\n\n bbb");
					r = false;
					break;

				default:

					r = true;
					break;
				}

			}

		} while (r == true);
		
		


	}

	public static void Dashboard() {
		System.out.println("\n ======   a- Login   ======");
		System.out.println("\n ======   b- Forgot password ?  ======");
	}

}
