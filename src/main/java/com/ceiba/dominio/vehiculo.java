package com.ceiba.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import com.ceiba.dominio.Slot;

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
	
	@OneToOne
	@JoinColumn(name="idslot")
	private Slot idslot;

	
	private String Fechaentrada;
	
	public vehiculo(){
		
		
	}
	
	
	public vehiculo(String matricula, String cilindraje,String Marca,String fechaentrada,String tipo) {
	
		this.Matricula = matricula;
		this.Cilindraje = cilindraje;
		this.Marca =Marca;
		this.Fechaentrada =fechaentrada;
	
	}
	
	
	
	public vehiculo(String matricula, String cilindraje,String Marca) {
		
		this.Matricula = matricula;
		this.Cilindraje = cilindraje;
		this.Marca =Marca;
		
	}

	
	public void Syncwith(String matricula, String cilindraje,String Marca,String fechaentrada,String tipo) {
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


	public Integer getId_Vehiculo() {
		return idvehiculo;
	}


	public String getMarca() {
		return Marca;
	}
	
	

	public String getFechaentrada() {
		return Fechaentrada;
	}
	
	public Integer getIdvehiculo() {
		return idvehiculo;
	}


	public void setIdvehiculo(Integer idvehiculo) {
		this.idvehiculo = idvehiculo;
	}


	public void setMatricula(String matricula) {
		Matricula = matricula;
	}


	public void setCilindraje(String cilindraje) {
		Cilindraje = cilindraje;
	}


	public void setMarca(String marca) {
		Marca = marca;
	}


	public void setFechaentrada(String fechaentrada) {
		Fechaentrada = fechaentrada;
	}

	 
	public Slot getSlot() {
		
		return idslot;
	}
	
	public void setSlot(Slot idslot) {
		
		this.idslot = idslot;
		
	}




	@Override
	public String toString() {
		return "vehiculo [idVehiculo=" + idvehiculo + ", Matricula=" + Matricula + ", Cilindraje=" + Cilindraje
				+ ", Marca=" + Marca + ", Fechaentrada=" + Fechaentrada + "]";
	}
	
	

}
