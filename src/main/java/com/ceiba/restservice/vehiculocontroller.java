package com.ceiba.restservice;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.dominio.Slot;
import com.ceiba.dominio.vehiculo;
import com.ceiba.repositorio.jpa.configuracionjpa;
import com.ceiba.servicio.servicioControlflujoVehiculo;

import ch.qos.logback.classic.Level;



@RestController
@EnableAutoConfiguration
public class vehiculocontroller {
	
	@Autowired
	servicioControlflujoVehiculo Serviciocontrolflujovehiculo;
	
	
@GetMapping("/vehiculo")
	
	public List<vehiculo> getvehiculoslist(){
			
		return Serviciocontrolflujovehiculo.Obtenervehiculosparqueados();
		}
	
	
	
	@RequestMapping(value = "/vehiculo", method = RequestMethod.POST)
	public ResponseEntity<vehiculo> persistCrear(@RequestBody vehiculo Vehiculo,@RequestBody Slot slot) {
			
		
		
	  Serviciocontrolflujovehiculo.guardarvehiculos(Vehiculo,slot);
	
	
		
		return new ResponseEntity<vehiculo>(Vehiculo,HttpStatus.OK);
	   
	}
	
	
	
	@GetMapping("/slot")
	public boolean buscarslot() {
			
		
		
		return Serviciocontrolflujovehiculo.existenespaciosdisponibles();
	
	
	}
	

	

}
