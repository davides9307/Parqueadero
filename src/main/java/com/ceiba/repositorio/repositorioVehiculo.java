package com.ceiba.repositorio;

import java.util.List;

import com.ceiba.dominio.vehiculo;

public interface repositorioVehiculo {
	
	
	public List<vehiculo> listarvehiculos();
	public vehiculo obtenervehiculo(vehiculo Vehiculo);
	public vehiculo guardarvehiculo(vehiculo Vehiculo);
	public vehiculo actualizar(vehiculo Vehiculo);
	public vehiculo borrarvehiculo(vehiculo Vehiculo);


}
