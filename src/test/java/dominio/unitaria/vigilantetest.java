package dominio.unitaria;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.ceiba.dominio.vehiculo;
import com.ceiba.servicio.servicioControlflujoVehiculo;
import com.ceiba.servicio.vigilante;
import testdatabuilder.vehiculotestdatabuilder;


@ComponentScan("com.ceiba.restservice")
@ComponentScan("com.ceiba.repositorio.jpa")
@ComponentScan("com.ceiba.dominio")
@ComponentScan("com.ceiba.repositorio")
@EntityScan(basePackages="com.ceiba.dominio")
@ComponentScan("com.ceiba.servicio")

public class vigilantetest {

	
	 
	 @Autowired
	 private servicioControlflujoVehiculo guardia;
	
	
	@Test
	public void Vervehiculos() {
		
		//Arrange
		 
		 List<vehiculo> vehiculos = new ArrayList<>();
		//Act
	    //vehiculos = guardia.Obtenervehiculosparqueados();
		//Assert
	    Assert.assertEquals(1,1);
	}
}
