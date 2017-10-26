package com.ceiba.servicio;


import java.util.List;

import com.ceiba.dominio.Slot;
import com.ceiba.dominio.vehiculo;

public interface servicioControlflujoVehiculo {

	
	public List<vehiculo> Obtenervehiculosparqueados();
	
	public void guardarvehiculos(vehiculo Vehiculo,Slot slot);
	
	public boolean existenespaciosdisponibles();
	
	
}
