package com.ceiba.restservice;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.dominio.Detallefactura;
import com.ceiba.dominio.Slot;
import com.ceiba.dominio.vehiculo;
import com.ceiba.dominio.vehiculoParqueado;
import com.ceiba.repositorio.repositorioSlot;
import com.ceiba.repositorio.jpa.configuracionjpa;
import com.ceiba.servicio.servicioControlflujoVehiculo;
import com.ceiba.servicio.serviciofactura;

import ch.qos.logback.classic.Level;



@RestController
@EnableAutoConfiguration
public class vehiculocontroller {
	
	@Autowired
	servicioControlflujoVehiculo Serviciocontrolflujovehiculo;
	
	@Autowired
	serviciofactura Serviciofactura;
	
	@Autowired
	repositorioSlot repositorioslot;
	
	
	
@GetMapping("/vehiculo")
	
	public List<Slot> getvehiculoslist(){
			
		return Serviciocontrolflujovehiculo.Obtenervehiculosparqueados();
		}
	
	
	
	
	
	@GetMapping("/slot")
	public int buscarslot() {
			
		
		Slot slot = new Slot("carro");
		return repositorioslot.espaciosdisponibles(slot).size();
		//return Serviciocontrolflujovehiculo.existenespaciosdisponibles();
	    
	
	}
	
	
	
	
	@RequestMapping(value = "/wrapper", method = RequestMethod.POST)
	public ResponseEntity<String> updateWithMultipleObjects(
	        @RequestBody vehiculoParqueado vehiculoparqueado) {

		 String Mensaje =Serviciocontrolflujovehiculo.guardarvehiculos(vehiculoparqueado);
	     

	    return new ResponseEntity<String>(Mensaje,HttpStatus.OK);
	}
	

	
	@PutMapping("/salidavehiculo")
	public ResponseEntity<vehiculoParqueado> salidavehiculo(@RequestBody vehiculoParqueado vehiculoparqueado) {

		

		/*if (null == customer) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}
		*/
		
		Serviciofactura.salidavehiculo(vehiculoparqueado);

		return new ResponseEntity<vehiculoParqueado>(vehiculoparqueado, HttpStatus.OK);
	}

	
	
	@GetMapping("/fecha")
	public LocalDateTime diferenciafechat() {
			

		
	   vehiculo Vehiculo = new vehiculo();
	   
		
		
	   Vehiculo.setFechaentrada(LocalDateTime.now().withDayOfMonth(24));
	
				
		//return Serviciofactura.tiemposervicio(Vehiculo);
		
	   return LocalDateTime.now().withDayOfMonth(27).withHour(15);
	   
	
	}
	
	@RequestMapping(value = "/costo", method = RequestMethod.POST)
	public BigDecimal costo(@RequestBody vehiculoParqueado vehiculoparqueado){
		
		
	   
		BigDecimal numero = new BigDecimal(3) ;
		
		vehiculoparqueado.getVehiculo().setFechaentrada(LocalDateTime.now().withDayOfMonth(25).withHour(2));
		
		
		//vehiculo ve = new vehiculo();
		//ve.getSlot().setTipoespacio("carrot");
		//ve.getVehiculo().setFechaentrada(LocalDateTime.now().withDayOfMonth(26));
		
		return Serviciofactura.Calculocostototal(vehiculoparqueado);
			
		
	}
	
	@RequestMapping(value = "/verdad", method = RequestMethod.POST)
	public boolean verdad(@RequestBody vehiculoParqueado vehiculoparqueado){
		
		
	   
		
		return Serviciofactura.Existerecargo(vehiculoparqueado.getSlot().getTipoespacio(), vehiculoparqueado.getVehiculo().getCilindraje());
			
		
	}
	
	
	
	@RequestMapping(value = "/factura", method = RequestMethod.POST)
	public Detallefactura factura(@RequestBody vehiculoParqueado vehiculoparqueado){
		
		
	   
		
		
		
		
		//return Serviciofactura.generarfactura(vehiculoparqueado);
		return Serviciofactura.generarsalidavehiculo(vehiculoparqueado);
		
	}
	
	
	
	

}
