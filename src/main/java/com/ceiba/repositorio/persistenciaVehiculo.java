package com.ceiba.repositorio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
		
		return Configuracionjpa.GetEntityManager().find(vehiculo.class, Vehiculo.getIdvehiculo());
	}

	@Override
	public vehiculo guardarvehiculo(vehiculo Vehiculo) {
		
	

        
		
		Vehiculo.setFechaentrada(LocalDateTime.now());
		return Configuracionjpa.GetEntityManager().merge(Vehiculo);
		
	}

	@Override
	public vehiculo actualizar(vehiculo Vehiculo) {
		
		return null;
	}

	@Override
	public vehiculo borrarvehiculo(vehiculo Vehiculo) {
		
		
	   vehiculo vehiculoencontrado=Configuracionjpa.GetEntityManager().find(vehiculo.class, Vehiculo.getIdvehiculo());
	   Configuracionjpa.GetEntityManager().remove(vehiculoencontrado);
	   return vehiculoencontrado;
	}

}
