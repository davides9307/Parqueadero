package com.ceiba.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class carro extends vehiculo {

	@Column(nullable=false)
	private String tipo;
	private final static String tipoVehiculo= "carro";

	
	
	public carro(String matricula, String cilindraje, String Marca, Date fechaentrada) {
		super(matricula, cilindraje, Marca, fechaentrada);
		this.tipo=tipoVehiculo;
		// TODO Auto-generated constructor stub
	}



	public  String getTipo() {
		return tipo;
	}
	
	
	
	
}
