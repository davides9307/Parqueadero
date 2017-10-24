package com.ceiba.dominio;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class moto extends vehiculo{


	private String tipo;
	private final static String tipoVehiculo= "moto";

	
	
	
	
	public moto(String matricula, String cilindraje, String Marca, Date fechaentrada) {
		super(matricula, cilindraje, Marca, fechaentrada);
		this.tipo=tipoVehiculo;
		// TODO Auto-generated constructor stub
	}



	
	
	public String getTipo() {
		return tipo;
	}
	
}
