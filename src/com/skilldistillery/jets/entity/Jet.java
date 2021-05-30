package com.skilldistillery.jets.entity;

public abstract class Jet {
	private int JetId;
	private String model;
	private double speed;
	private double range;
	private double price;
	private String type;
	
	public Jet(String model, double speed, double range, double price, String type) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
		this.type = type;
	}
	
	public abstract void fly();
	
	public double getFlightTime() {
		 double scale = Math.pow(10, 1);
		return Math.round(range/speed * scale) / scale;
	}
	public double getMachSpeed() {
		//return speed/1234.8;
		 double scale = Math.pow(10, 4);
		 return Math.round(speed/1234.8 * scale) / scale;
	}
	@Override
	public String toString() {
		return (("| ID   : " + getId()+
			   "\n| Type : " + getType()+
		       "\n| Model: " + getModel()+
		       "\n| Speed: " + getMachSpeed()+ " Machs"+
		       "\n| Range: " + getRange()+ " Kms"+
	          "\n| Price: $" + getPrice()+ "M"+
			 	"\n|-------------------------------------|"));
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public double getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return JetId;
	}
	public void setId(int id) {
		this.JetId = id;
	}
}