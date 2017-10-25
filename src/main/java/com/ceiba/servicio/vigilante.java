package com.ceiba.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.dominio.vehiculo;
import com.ceiba.repositorio.repositorioVehiculo;


@Component
public class vigilante implements servicioControlflujoVehiculo{
	
	@Autowired
	repositorioVehiculo Repositoriovehiculo;

	@Override
	public List<vehiculo> Obtenervehiculosparqueados() {
		
		
		return Repositoriovehiculo.listarvehiculos();
		
	}
	
	
	

}
