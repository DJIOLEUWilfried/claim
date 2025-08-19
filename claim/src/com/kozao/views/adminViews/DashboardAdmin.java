package com.kozao.views.adminViews;

import java.util.Scanner;

import com.kozao.views.Login;

public class DashboardAdmin {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("\n\t\t\t\t Bienvenu, " + Login.userSession + " !");
		Dashboard();

		String value = sc.nextLine();

		choix(value);

	}

	public static void Dashboard() {
		System.out.println("\n ======   a- Ajouter un utilisateur   ======");
		System.out.println("\n ======   b- Login   ======");

		System.out.println("\n ======   c- Login   ======");
		System.out.println("\n ======   d- Login   ======");
		System.out.println("\n ======   e- Login   ======");
	}

	public static void choix(String value) {

		value = value.toLowerCase();
		if (value.length() == 1) {

			char val = value.charAt(0);
			switch (val) {

			case 'a':
				System.out.println("aaa");
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
