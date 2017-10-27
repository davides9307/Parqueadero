package com.ceiba.servicio;


import java.util.List;

import com.ceiba.dominio.Slot;
import com.ceiba.dominio.vehiculo;
import com.ceiba.dominio.vehiculoParqueado;

public interface servicioControlflujoVehiculo {

	
	public List<vehiculo> Obtenervehiculosparqueados();
	
	public String guardarvehiculos(vehiculoParqueado vehiculo_slot);
	
	public boolean existenespaciosdisponibles(Slot slot);
	
	public boolean ImpedimentoparaIngreso(vehiculo Vehiculo);
	
	public boolean EsLunesoDomingo();
	
	
	
}
