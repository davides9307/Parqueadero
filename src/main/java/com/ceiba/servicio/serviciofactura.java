package com.ceiba.servicio;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.ceiba.dominio.vehiculo;
import com.ceiba.dominio.vehiculoParqueado;

public interface serviciofactura {

	public void salidavehiculo(vehiculoParqueado vehiculo_slot);
	public long tiemposervicio(vehiculo Vehiculo);
	public BigDecimal Calculocosto(vehiculo Vehiculo);
}
