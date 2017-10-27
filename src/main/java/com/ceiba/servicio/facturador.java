package com.ceiba.servicio;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.dominio.Slot;
import com.ceiba.dominio.vehiculo;
import com.ceiba.dominio.vehiculoParqueado;
import com.ceiba.repositorio.repositorioSlot;
import com.ceiba.repositorio.repositorioVehiculo;


@Component
public class facturador implements serviciofactura{
	
	
	
	@Autowired
	repositorioVehiculo Repositoriovehiculo;
	
	@Autowired
	repositorioSlot repositorioslot;
	

	@Override
	public void salidavehiculo(vehiculoParqueado vehiculo_slot) {
		
		
	
		
		
		vehiculo_slot.getSlot().setidvehiculo(null);
		repositorioslot.Actualizarslot(vehiculo_slot.getSlot());
		Repositoriovehiculo.borrarvehiculo(vehiculo_slot.getVehiculo());
		
		
	}


	@Override
	public long tiemposervicio(vehiculo Vehiculo) {
	
		LocalDateTime actual=LocalDateTime.now();
		
		return  Duration.between(Vehiculo.getFechaentrada(),actual).getSeconds()/3600;
				
		
	}


	@Override
	public BigDecimal Calculocosto(vehiculo Vehiculo) {
		BigDecimal numero =4,3;
	return numero;
		
	}
	
	

}
