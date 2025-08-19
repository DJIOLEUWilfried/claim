package com.kozao.views;

import java.util.Scanner;

public class HomePage {

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Dashboard();

		String value = sc.nextLine();

		choix(value);

	}

	public static void Dashboard() {
		System.out.println("\n ======   a- Login   ======");
		System.out.println("\n ======   b- Registration   ======");
	}

	public static void choix(String value) {

		value = value.toLowerCase();
		if (value.length() == 1) {

			char val = value.charAt(0);
			switch (val) {

			case 'a':
				
				break;

			case 'b':
				System.out.println("bbb");
				break;

			default:
				Dashboard();

				Scanner sc = new Scanner(System.in);
				String v = sc.nextLine();
				choix(v);
				break;
			}
			
		} else {
			Dashboard();

			Scanner sc = new Scanner(System.in);
			String v = sc.nextLine();
			choix(v);
		}
	}

}
