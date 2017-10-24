package com.ceiba.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class vehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id_Vehiculo;
    
	@Column(nullable=false)
	private String Matricula;
	
	@Column(nullable=false)
	private String Cilindraje;
	
	private String Marca;
	
	@Column(nullable=false)
	private Date Fechaentrada;
	
	
	public vehiculo(String matricula, String cilindraje,String Marca,Date fechaentrada) {
	
		this.Matricula = matricula;
		this.Cilindraje = cilindraje;
		this.Marca =Marca;
		this.Fechaentrada =fechaentrada;
	}


	public String getMatricula() {
		return Matricula;
	}


	public String getCilindraje() {
		return Cilindraje;
	}
	
	

}
