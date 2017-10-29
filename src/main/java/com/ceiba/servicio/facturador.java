package com.ceiba.servicio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.dominio.Detallefactura;
import com.ceiba.dominio.Slot;
import com.ceiba.dominio.factura;
import com.ceiba.dominio.vehiculo;
import com.ceiba.dominio.vehiculoParqueado;
import com.ceiba.repositorio.repositorioSlot;
import com.ceiba.repositorio.repositorioVehiculo;
import com.ceiba.repositorio.repositoriodetallefactura;
import com.ceiba.repositorio.repositoriofactura;


@Component
public class facturador implements serviciofactura{
	
	
	
	@Autowired
	repositorioVehiculo Repositoriovehiculo;
	
	@Autowired
	repositorioSlot repositorioslot;
	
	@Autowired
	repositoriodetallefactura detallefactura;
	
	@Autowired
	repositoriofactura Repositoriofactura;
	

	@Override
	public void salidavehiculo(vehiculoParqueado vehiculo_slot) {
		
		
	
		
		
		vehiculo_slot.getSlot().setidvehiculo(null);
		repositorioslot.Actualizarslot(vehiculo_slot.getSlot());
		//Repositoriovehiculo.borrarvehiculo(vehiculo_slot.getVehiculo());
		
		
	}


	@Override
	public BigDecimal tiemposervicio(LocalDateTime fechaentrada) {
	
		LocalDateTime actual=LocalDateTime.now();
		
		
				
        return new BigDecimal(Duration.between(fechaentrada,actual).getSeconds()/3600);
		
	}


	@Override
	public BigDecimal Calculocostodia(int tiemposervicio,String tipoespacio) {
		
		BigDecimal costodiacarro = new BigDecimal(8000);
		BigDecimal costodiamoto = new BigDecimal(600);
		BigDecimal total=new BigDecimal(0);
		BigDecimal Tiemposervicio = new BigDecimal(tiemposervicio);


		
		
		switch(tipoespacio) {
		case "carro":
			
		
       return total =Tiemposervicio.multiply(costodiacarro);
		
		

		case "moto":
	     return total =Tiemposervicio.multiply(costodiamoto);
	    
	    
	    default:
	    
	    return null;	
	}
		

	}


	@Override
	public BigDecimal Calculocostohora(int tiemposervicio,String tipoespacio) {
		
		BigDecimal costohoracarro = new BigDecimal(1000);
		BigDecimal costohoramoto = new BigDecimal(500);
		BigDecimal total=new BigDecimal(0);
		BigDecimal Tiemposervicio = new BigDecimal(tiemposervicio);

		switch(tipoespacio) {
		case "carro":
			
		
       return total=Tiemposervicio.multiply(costohoracarro);
		
		

		case "moto":
	     return total=Tiemposervicio.multiply(costohoramoto);
	    
	    
	    default:
	    
	    return null;	
	}
	
	}


	@Override
	public BigDecimal Calculocostototal(vehiculoParqueado vehiculo_slot) {
		 int tiemposervicio =tiemposervicio(vehiculo_slot.getVehiculo().getFechaentrada()).intValue();
		 BigDecimal total= new BigDecimal(0);
		 BigDecimal tarifarecargo = new BigDecimal(2000);
		
		while(tiemposervicio >=9) {
			if(tiemposervicio/24 == 0) {
				
				total=total.add(Calculocostodia(1,vehiculo_slot.getSlot().getTipoespacio()));
				tiemposervicio =tiemposervicio-24;
				
			}
			
			else {
				
				total=total.add(Calculocostodia(tiemposervicio/24,vehiculo_slot.getSlot().getTipoespacio()));
				tiemposervicio =tiemposervicio-24*(tiemposervicio/24);
				
			}
			
			
		}
		
		if(tiemposervicio>0)
		{
		
		total=total.add(Calculocostohora(tiemposervicio, vehiculo_slot.getSlot().getTipoespacio()));
		}
		
		if (Existerecargo(vehiculo_slot.getSlot().getTipoespacio(),vehiculo_slot.getVehiculo().getCilindraje())) {
			
			
			total = total.add(tarifarecargo);
		}
		
		
		return total;
	}


	@Override
	public boolean Existerecargo(String tipoespacio, Integer cilindraje) {
		
		if(tipoespacio.equals("moto")) {
			
			
			if(cilindraje > 500) {
				
				return true;
			}
		
		} 
		return false;
	}


	@Override
	public Detallefactura generarfactura(vehiculoParqueado vehiculo_slot) {
		
		
		//Esta instruccion no debe ir se agrega para prueba 
		vehiculo_slot.getVehiculo().setFechaentrada(LocalDateTime.now().withDayOfMonth(27));
		Detallefactura detalle = new Detallefactura();
		factura Factura = new factura();
		Factura.setValortotal(Calculocostototal(vehiculo_slot));
		Factura.setIdUsuario(vehiculo_slot.getVehiculo());
		Factura = Repositoriofactura.crearfactura(Factura);
		
		
		detalle.setIdfactura(Factura);
		detalle.setFechaentrada(vehiculo_slot.getVehiculo().getFechaentrada());
		detalle.setFechasalida(LocalDateTime.now().withDayOfMonth(29));
		detalle.setValor(Factura.getValortotal());
		
		
		return detallefactura.crearDetalle(detalle);
		
		
	}


	@Override
	public Detallefactura generarsalidavehiculo(vehiculoParqueado vehiculo_slot) {
		salidavehiculo(vehiculo_slot);
		return generarfactura(vehiculo_slot);
		
	}
  

}
