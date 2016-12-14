package edu.uclm.esi.iso2.multas.domain;

import java.util.Set;
import edu.uclm.esi.iso2.multas.dao.*;
public class ManagerLogin {
	public Set<Vehicle>  comprobarCredenciales(String dni, String pass){
		
		OwnerDao gestorProp= new OwnerDao();
		Owner propietario = gestorProp.findByDni(dni);
		if(!propietario.equals(null)){
			//if(propietario.getPass().equals(pass)){
				return propietario.getVehicles();
			//}			
			
		}else{
			System.out.println("No se ha encontrado al conductor con dni: "+dni);
			return null;
		}
	}
}
