package com.skilldistillery.jets.entity;

public class PassengerJet extends Jet {

	public PassengerJet(String model, double speed, double range, double price, String type) {
		super(model, speed, range, price, type);
	}

	@Override
	public void fly() {
		System.out.println(
				"| Passenger Jet " + getModel() + " departs late and flies for " + getFlightTime() + " hours.");

	}

}
