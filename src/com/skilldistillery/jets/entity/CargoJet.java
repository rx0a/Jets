package com.skilldistillery.jets.entity;

public class CargoJet extends Jet implements CargoCarrier {

	public boolean cargoLoaded = false;

	public CargoJet(String model, double speed, double range, double price, String type) {
		super(model, speed, range, price, type);
	}

	@Override
	public void loadCargo() {
		cargoLoaded = true;
		System.out.println("| All cargo is loaded to " + getModel());
	}

	@Override
	public void fly() {

		if (cargoLoaded == false) {
			System.out.println(
					"| Cargo Jet " + getModel() + " flies for " + getFlightTime() + " hours with an empty cargo hold.");

		} else {
			System.out.println(
					"| Cargo Jet " + getModel() + " flies for " + getFlightTime() + " hours with a full cargo hold.");

		}
	}

}
