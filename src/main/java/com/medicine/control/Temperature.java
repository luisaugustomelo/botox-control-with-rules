package com.medicine.control;

public class Temperature {
	private double degrees;
	private boolean notify;
	
	Temperature(double d){
		
		this.degrees = d;
		this.notify = false;
	}

	public double getDegrees() {
		return degrees;
	}

	public void setDegrees(double d) {
		this.degrees = d;
	}
	
	public boolean getNotify(){
		return this.notify;
	}
	
	public void setNotify(boolean b){
		this.notify = b;
	}
	
	@Override
	public String toString() {
		return "Nada foi implementado AQUI!";
	}
	
}