package com.ceiba.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.dominio.Slot;
import com.ceiba.dominio.vehiculo;
import com.ceiba.repositorio.repositorioSlot;
import com.ceiba.repositorio.repositorioVehiculo;


@Component
public class vigilante implements servicioControlflujoVehiculo{
	
	@Autowired
	repositorioVehiculo Repositoriovehiculo;
	
	@Autowired
	repositorioSlot RepositorioSlot;

	@Override
	public List<vehiculo> Obtenervehiculosparqueados() {
		
		
		return Repositoriovehiculo.listarvehiculos();
		
	}

	@Override
	public void guardarvehiculos(vehiculo Vehiculo,Slot slot) {
		
		
		Vehiculo.setSlot(RepositorioSlot.guardarenslot(slot));
		Repositoriovehiculo.guardarvehiculo(Vehiculo);
		
	}

	@Override
	public boolean existenespaciosdisponibles() {
		
		return RepositorioSlot.espaciosdisponibles() != 0 ? true:false;
		
		
	}
	
	
	

}
