package com.ceiba.servicio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.dominio.Slot;
import com.ceiba.dominio.vehiculo;
import com.ceiba.dominio.vehiculoParqueado;
import com.ceiba.repositorio.repositorioSlot;
import com.ceiba.repositorio.repositorioVehiculo;


@Component
public class vigilante implements servicioControlflujoVehiculo{
	
	@Autowired
	repositorioVehiculo Repositoriovehiculo;
	
	@Autowired
	repositorioSlot RepositorioSlot;

	@Override
	public List<Slot> Obtenervehiculosparqueados() {
		
	return	RepositorioSlot.Slotocupados();
		
		//return Repositoriovehiculo.listarvehiculos();
		
	}

	@Override
	public String guardarvehiculos(vehiculoParqueado vehiculo_slot) {
		
		//vehiculo_slot.getVehiculo().setParqueado("True");
		
        if(!ImpedimentoparaIngreso(vehiculo_slot.getVehiculo())) {
        	if (existenespaciosdisponibles(vehiculo_slot.getSlot())) {
        		
        		
        		vehiculo_slot.getSlot().setidvehiculo(Repositoriovehiculo.guardarvehiculo(vehiculo_slot.getVehiculo()));
        		RepositorioSlot.guardarenslot(vehiculo_slot.getSlot());
        		
        		
        		
        		return "Vehiculo guardado de manera exitosa";
		}
        	else {
			
        		return "No existen espacios disponibles vuelva luego";
			
        	}
		
        }
        
        else {
        	
        		return "No puede ingresar debido a que no es un dia habil";
        	
        }
	}

	@Override
	public boolean existenespaciosdisponibles(Slot slot) {
		


		switch(slot.getTipoespacio()) {
		case "carro":
			
		return RepositorioSlot.espaciosdisponibles(slot).size() >= 3 ? false:true;
		

		case "moto":
		return RepositorioSlot.espaciosdisponibles(slot).size() >= 2 ? false:true;
	
		
		default:
		return false;	



}
	
		
	}

	@Override
	public boolean ImpedimentoparaIngreso(vehiculo Vehiculo) {
		
		if(Vehiculo.getMatricula().charAt(0) != 'A') {
			
			return false;
		}
		
		else {
			
			
				if(EsLunesoDomingo()) {
				
					return false;	
				
				
				}
			
				else {
			
					return true;	
				
				}
		}
			
			
		
		
	}

	@Override
	public boolean EsLunesoDomingo() {
		
		Date actual=new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(actual); 
		
		
		if (calendar.get(Calendar.DAY_OF_WEEK)==1 ||  calendar.get(Calendar.DAY_OF_WEEK)==7) {
			
			return true;
			
		}
		
		
		
			return false;
	}
	
	
	

}
