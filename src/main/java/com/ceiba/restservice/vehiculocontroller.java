package com.ceiba.restservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ceiba.dominio.vehiculo;
import com.ceiba.repositorio.jpa.configuracionjpa;
import com.ceiba.servicio.servicioControlflujoVehiculo;




@RestController

public class vehiculocontroller {
	
	@Autowired
	servicioControlflujoVehiculo Serviciocontrolflujovehiculo;
	
	
	
@GetMapping("/vehiculo")
	
	public List<vehiculo> getvehiculoslist(){
			
			//return Arrays.asList(new vehiculo("abc123","200cc","ferrari"));
		return Serviciocontrolflujovehiculo.Obtenervehiculosparqueados();
		}
	
/*@GetMapping("/vehiculo")
   public vehiculo obtenervehiculo() {
	
	return Configuracionjpa.obtenervehiculo(1);
	
}
*/
	

}
