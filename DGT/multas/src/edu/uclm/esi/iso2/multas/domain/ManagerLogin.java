package edu.uclm.es.iso2.DGT;

import java.util.Set;

public class ManagerLogin {
	public Set<Vehicle>  comprobarCredenciales(String dni, String pass){
		
		OwnerDao gestorProp= new OwnerDao();
		Owner propietario = gestorProp.findByDni(dni);
		if(!propietario.equals(null)){
			if(propietario.getPass().equals(pass)){
				return propietario.getVehicles();
			}			
			
		}else{
			System.out.println("No se ha encontrado al conductor con dni: "+dni);
			return null;
		}
	}
}
