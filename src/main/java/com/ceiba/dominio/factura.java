package com.ceiba.dominio;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class factura {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Idfactura;
	
	//@Column(nullable=false)
	private BigDecimal Valortotal;
	
	
    @OneToOne
	@JoinColumn(name="idvehiculo")
	private vehiculo Vehiculo;
	
	
	public factura() {
		
		
	}

	public Integer getIdfactura() {
		return Idfactura;
	}

	public void setIdfactura(Integer idfactura) {
		Idfactura = idfactura;
	}

	public BigDecimal getValortotal() {
		return Valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
		Valortotal = valortotal;
	}
	
	
	

	public vehiculo getVehiculo() {
		return Vehiculo;
	}

	public void setIdUsuario(vehiculo Vehiculo) {
		this.Vehiculo=Vehiculo;
	}
	
	

	
	

}
