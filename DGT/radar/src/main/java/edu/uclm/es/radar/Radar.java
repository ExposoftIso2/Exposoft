package edu.uclm.es.radar;

import edu.uclm.esi.iso2.multas.domain.*;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class Radar {

	private boolean encendido = false;
	private double velocidadMaxima;
	private Date fecha;
	private String localizacion;

	public Radar(double vMax, String location){
		velocidadMaxima=vMax;
		localizacion=location;
	}
	private void encender() throws Exception{
		if(!encendido){
			encendido=true;
			tomarFoto();
		}else
			throw new Exception("Ya encendido");
	}

	private void apagar() throws Exception{
		if(encendido){
			encendido=false;
		}else
			throw new Exception("Ya apagado");
	}

	public void tomarFoto() {
		Random r=new Random();
		double velocidadCoche;
		String matricula;
		while(encendido){
			velocidadCoche=r.nextDouble()*(velocidadMaxima+40);
			matricula=r.nextInt(9999)+"ABC";
			Inquiry(matricula, velocidadCoche, localizacion,velocidadMaxima);
			TimeUnit.SECONDS.sleep(10);
		}
	}

}