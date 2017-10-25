package com.ceiba.repositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.dominio.vehiculo;
import com.ceiba.repositorio.jpa.configuracionjpa;

@Component
public class persistenciaVehiculo implements repositorioVehiculo{
	
	@Autowired
	configuracionjpa Configuracionjpa;
	
	public List<vehiculo> listarvehiculos(){
		
		//return Configuracionjpa.GetEntityManager().createNamedQuery("vehiculo.findall").getResultList();
		return Configuracionjpa.GetEntityManager().createQuery("SELECT v FROM vehiculo v ORDER BY v.idvehiculo").getResultList();
	}

	@Override
	public vehiculo obtenervehiculo(vehiculo Vehiculo) {
		
		return Configuracionjpa.GetEntityManager().find(vehiculo.class, Vehiculo.getId_Vehiculo());
	}

}
