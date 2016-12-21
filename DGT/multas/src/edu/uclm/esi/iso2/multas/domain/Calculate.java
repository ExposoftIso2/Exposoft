package edu.uclm.esi.iso2.multas.domain;

public class Calculate {
	private double speed;
	private double maxSpeed;
	private double lInf1;
	private double lInf2;
	private double lSup1;
	private double lSup2;
	
	public Calculate(double speed, double maxSpeed, double lInf1, double lInf2, double lSup1, double lSup2) {
		this.speed = speed;
		this.maxSpeed = maxSpeed;
		this.lInf1 = lInf1;
		this.lInf2 = lInf2;
		this.lSup1 = lSup1;
		this.lSup2 = lSup2;
	}
	public int amount(){
		if (speed<=maxSpeed)
			return 0;
		else if (speed>=(maxSpeed+1) && speed<=lInf1)
			return 100;
		else if (speed>=(lInf1+1) && speed<=lInf2)
			return 300;
		else if (speed>=(lInf2+1) && speed<=lSup1)
			return 400;
		else if (speed>=(lSup1+1) && speed<=lSup2)
			return 500;
		else if (speed>=(lSup2+1))
			return 600;
		return -1;
	}
	
	public int points(){
		if(speed>=(lInf1+1) && speed<=lInf2)
			return 2;
		else if (speed>=(lInf2+1) && speed<=lSup1)
			return 4;
		else if (speed>=(lSup1+1))
			return 6;
		
		return 0;
	}
	
}
