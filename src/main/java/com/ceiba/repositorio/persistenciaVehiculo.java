package com.ceiba.repositorio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.dominio.vehiculo;
import com.ceiba.repositorio.jpa.configuracionjpa;

@Component
@Transactional
public class persistenciaVehiculo implements repositorioVehiculo{
	
	@Autowired
	configuracionjpa Configuracionjpa;
	
	public List<vehiculo> listarvehiculos(){
		
		
		return Configuracionjpa.GetEntityManager().createQuery("SELECT v FROM vehiculo v ORDER BY v.idvehiculo").getResultList();
	}

	@Override
	public vehiculo obtenervehiculo(vehiculo Vehiculo) {
		
		return Configuracionjpa.GetEntityManager().find(vehiculo.class, Vehiculo.getId_Vehiculo());
	}

	@Override
	public void guardarvehiculo(vehiculo Vehiculo) {
		
		Configuracionjpa.GetEntityManager().merge(Vehiculo);
		
	}

}
