package edu.uclm.es.radar;

import edu.uclm.esi.iso2.multas.*;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.naming.ldap.ManageReferralControl;
public class Radar {

	private boolean encendido = false;
	private double velocidadMaxima;
	private Date fecha;
	private String localizacion;
	private Manager manager;
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
	public void apertura_de_expendiente(String matricula, double velocidad){
		//creamos un administrador de multas
		Manager manger_aux = manager.get();

		int id_inquiry = manger_aux.openInquiry(matricula,  velocidad,  localizacion,  velocidadMaxima) ;
		registrar_vehiculo(matricula, manger_aux);
	}
	public void registrar_vehiculo(String matricula, Manager manager){
		OwnerDao ownerDao = new OwnerDao();
		Owner owner = ownerDao.findByLicense(String matricula);
		
	}
		
	
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
	

	