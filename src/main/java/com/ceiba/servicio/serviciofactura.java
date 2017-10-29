package com.ceiba.servicio;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.ceiba.dominio.Detallefactura;
import com.ceiba.dominio.vehiculo;
import com.ceiba.dominio.vehiculoParqueado;

public interface serviciofactura {

	public void salidavehiculo(vehiculoParqueado vehiculo_slot);
	public BigDecimal tiemposervicio(LocalDateTime fechaentrada);
	public BigDecimal Calculocostodia(int tiemposervicio,String tipoespacio);
	public BigDecimal Calculocostohora(int tiemposervicio,String tipoespacio);
	public BigDecimal Calculocostototal(vehiculoParqueado vehiculo_slot);
	public boolean Existerecargo(String tipoespacio,Integer cilindraje);
	public Detallefactura generarfactura(vehiculoParqueado vehiculo_slot);
	public Detallefactura generarsalidavehiculo(vehiculoParqueado vehiculo_slot);
}
