package edu.uclm.es.iso2.DGT;

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
