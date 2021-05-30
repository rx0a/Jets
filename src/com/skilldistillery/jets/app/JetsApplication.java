package com.skilldistillery.jets.app;

import java.io.IOException;
import java.util.Scanner;

import com.skilldistillery.jets.entity.AirField;

public class JetsApplication {
	AirField a = new AirField();

	public static void main(String[] args) throws IOException {
		JetsApplication j = new JetsApplication();
		Scanner kb = new Scanner(System.in).useDelimiter("\n");
		j.run(kb);
	}

	public void run(Scanner kb) throws IOException {

		lines();
		System.out.println("|              Main Menu              |");
		lines();
		System.out.println("| [1] List current fleet              |");
		System.out.println("| [2] Fly all jets                    |");
		System.out.println("| [3] View the fastest jet            |");
		System.out.println("| [4] View the jet with longest range |");
		System.out.println("| [5] Load all cargo jets             |");
		System.out.println("| [6] Dogfight!                       |");
		System.out.println("| [7] Add a jet to the fleet          |");
		System.out.println("| [8] Remove a jet from the fleet     |");
		System.out.println("| [9] Quit                            |");
		lines();
		System.out.print("|  > ");

		boolean repeat = true;

		do {
			int menu = kb.nextInt();
			switch (menu) {
			case 1:
				lines();
				a.printJets(a.readJetsFromFile());
				cont(kb);
				break;
			case 2:
				lines();
				a.flyJets(a.readJetsFromFile());
				lines();
				cont(kb);
				break;
			case 3:
				lines();
				a.getFastest(a.readJetsFromFile());
				cont(kb);
				break;
			case 4:
				lines();
				a.getLongest(a.readJetsFromFile());
				cont(kb);
				break;
			case 5:
				lines();
				a.loadCargo(a.readJetsFromFile());
				lines();
				cont(kb);
				break;
			case 6:
				lines();
				a.fight(a.readJetsFromFile());
				lines();
				cont(kb);
				break;
			case 7:
				lines();
				a.addUserJet(kb, a.readJetsFromFile());
				lines();
				cont(kb);
				break;
			case 8:
				lines();
				a.removeJet(kb, a.readJetsFromFile());
				lines();
				cont(kb);
				break;

			case 9:
				goodbye();
				break;
			}

		} while (repeat);
	}

	public void lines() {
		System.out.println("|-------------------------------------|");
	}

	public void cont(Scanner kb) throws IOException {
		System.out.println("| Press [ Enter ] for Main Menu       |");
		lines();
		if (kb.next().equals("")) {
			run(kb);
		} else {
			run(kb);
		}
	}

	public void goodbye() {
		lines();
		System.out.println("|              Goodbye!               |");
		lines();

	}
}
