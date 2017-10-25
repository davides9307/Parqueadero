package com.ceiba.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries( { @NamedQuery(name = "vehiculo.findAll", query = "SELECT v FROM vehiculo v ORDER BY v.idvehiculo") })
public class vehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idvehiculo;
    
	@Column(nullable=false)
	private String Matricula;
	
	@Column(nullable=false)
	private String Cilindraje;
	
	private String Marca;
	
	//@Column(nullable=false)
	private String Fechaentrada;
	
	@Column(nullable=false)
	private String tipo;
	
	
	public vehiculo(){
		
		
	}
	
	
	public vehiculo(String matricula, String cilindraje,String Marca,String fechaentrada,String tipo) {
	
		this.Matricula = matricula;
		this.Cilindraje = cilindraje;
		this.Marca =Marca;
		this.Fechaentrada =fechaentrada;
		this.tipo=tipo;
	}
	
	
	
	public vehiculo(String matricula, String cilindraje,String Marca) {
		
		this.Matricula = matricula;
		this.Cilindraje = cilindraje;
		this.Marca =Marca;
		
	}



	public String getMatricula() {
		return Matricula;
	}


	public String getCilindraje() {
		return Cilindraje;
	}


	public Integer getId_Vehiculo() {
		return idvehiculo;
	}


	public String getMarca() {
		return Marca;
	}


	public String getFechaentrada() {
		return Fechaentrada;
	}



	@Override
	public String toString() {
		return "vehiculo [idVehiculo=" + idvehiculo + ", Matricula=" + Matricula + ", Cilindraje=" + Cilindraje
				+ ", Marca=" + Marca + ", Fechaentrada=" + Fechaentrada + "]";
	}
	
	

}
