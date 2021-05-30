package com.skilldistillery.jets.entity;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, double range, double price, String type) {
		super(model, speed, range, price, type);
	}

	@Override
	public void fly() {

		System.out.println("| Fighter Jet " + getModel() + " flies for " + getFlightTime() + " hours at "
				+ getMachSpeed() + " machs.");

	}

	@Override
	public void fight() {
		System.out.println("| Fighter Jet " + getModel() + " is locked on target!");
	}

}
