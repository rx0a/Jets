package com.skilldistillery.jets.entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AirField {
	private List<Jet> squad = new ArrayList<>();

	public void addJet(Jet jet) {
		squad.add(jet);
		jet.setId(squad.size());
	}

	public void printJets(List<Jet> squad) {
		for (Jet j : squad) {
			System.out.println(j);
		}
	}

	public void flyJets(List<Jet> squad) {
		for (Jet j : squad) {
			j.fly();
		}
	}

	public void getFastest(List<Jet> squad) {
		Jet fastestJet = squad.get(0);

		Iterator<Jet> itr = squad.iterator();
		while (itr.hasNext()) {
			Jet j = itr.next();
			if (j.getSpeed() > fastestJet.getSpeed()) {
				fastestJet = j;
			}
		}
		System.out.println("|          The Fastest Jet            |");
		System.out.println(fastestJet);
	}

	public void loadCargo(List<Jet> squad) {
		for (Jet j : squad) {
			if (j instanceof CargoCarrier) {
				((CargoCarrier) j).loadCargo();
			}
		}

	}

	public void fight(List<Jet> squad) {
		for (Jet j : squad) {
			if (j instanceof CombatReady) {
				((CombatReady) j).fight();
			}
		}

	}

	public void removeJet(Scanner kb, List<Jet> squad) {
		System.out.println("| Please enter the ID of the Jet:     |");
		System.out.println("|-------------------------------------|");
		System.out.print("|  > ");
		int r = kb.nextInt();
		Iterator<Jet> itr = squad.iterator();
		while (itr.hasNext()) {
			Jet j = itr.next();
			if (j.getId() == r) {
				itr.remove();
			}
		}
		System.out.println("|            Jet removed.             |");
	}

	public void getLongest(List<Jet> squad) {
		Jet longestRange = squad.get(0);

		Iterator<Jet> itr = squad.iterator();
		while (itr.hasNext()) {
			Jet j = itr.next();
			if (j.getRange() > longestRange.getRange()) {
				longestRange = j;
			}
		}
		System.out.println("|     The Jet with Longest Range      |");
		System.out.println(longestRange);
	}

	public List<Jet> readJetsFromFile() throws IOException {

		if (squad.size() < 5) {
			try (BufferedReader buf = new BufferedReader(new FileReader("jets.csv"))) {
				String line;
				Jet jet;
				while ((line = buf.readLine()) != null) {
					String[] jetInfo = line.split(",");
					String model = jetInfo[0];
					double speed = (Double.parseDouble(jetInfo[1]));
					double range = (Double.parseDouble(jetInfo[2]));
					double price = (Double.parseDouble(jetInfo[3]));
					String type = jetInfo[4];

					if (type.equalsIgnoreCase("cargo")) {
						jet = new CargoJet(model, speed, range, price, type);
						addJet(jet);
					} else if (type.equalsIgnoreCase("passenger")) {
						jet = new PassengerJet(model, speed, range, price, type);
						addJet(jet);
					} else if (type.equalsIgnoreCase("fighter")) {
						jet = new FighterJet(model, speed, range, price, type);
						addJet(jet);
					}

				}
				buf.close();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		return squad;

	}

	public void addUserJet(Scanner kb, List<Jet> squad) throws IOException {
		Jet jet;
		System.out.println("| Please enter the type of the Jet:  |");
		System.out.println("| [Passenger]  [Cargo]  [Fighter]    |");
		System.out.println("|-------------------------------------|");
		System.out.print("|  > ");
		String type = kb.next();
		System.out.println("| Please enter the model of the Jet:  |");
		System.out.println("|-------------------------------------|");
		System.out.print("|  > ");
		String model = kb.next();
		System.out.println("| Please enter the speed of the Jet:  |");
		System.out.println("| [MPH]                               |");
		System.out.println("|-------------------------------------|");
		System.out.print("|  > ");
		double speed = (kb.nextDouble() * 1.60934);
		System.out.println("| Please enter the range of the Jet:  |");
		System.out.println("| [KMs]                               |");
		System.out.println("|-------------------------------------|");
		System.out.print("|  > ");
		double range = kb.nextDouble();
		System.out.println("| Please enter the price of the Jet:  |");
		System.out.println("| [Million USD]                       |");
		System.out.println("|-------------------------------------|");
		System.out.print("|  > ");
		double price = kb.nextDouble();

		if (type.equalsIgnoreCase("cargo")) {
			jet = new CargoJet(model, speed, range, price, type);
			addJet(jet);
		} else if (type.equalsIgnoreCase("passenger")) {
			jet = new PassengerJet(model, speed, range, price, type);
			addJet(jet);
		} else if (type.equalsIgnoreCase("fighter")) {
			jet = new FighterJet(model, speed, range, price, type);
			addJet(jet);
		}
		System.out.println("|-------------------------------------|");
		System.out.println("| Jet added to file.                  |");

	}
}