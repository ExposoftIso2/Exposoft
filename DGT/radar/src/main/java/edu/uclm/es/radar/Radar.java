package edu.uclm.es.radar;

public class Radar {
	boolean encendido=false;
	
	public void encender(){
		if(!encendido)
			encendido=true;
	}
	public void apagar(){
		if(encendido)
			encendido=false;
	}
}
