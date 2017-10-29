package com.ceiba.dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Detallefactura {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdDetalle;
	
	@Column(nullable=false)
	private LocalDateTime fechaentrada;
	
	@Column(nullable=false)
	private LocalDateTime fechasalida;
	
	@Column(nullable=false)
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "idfactura")
	private factura Idfactura;
	
	public Detallefactura() {
		
		
	}

	public Integer getIdDetalle() {
		return IdDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		IdDetalle = idDetalle;
	}

	public LocalDateTime getFechaentrada() {
		return fechaentrada;
	}

	public void setFechaentrada(LocalDateTime fechaentrada) {
		this.fechaentrada = fechaentrada;
	}

	public LocalDateTime getFechasalida() {
		return fechasalida;
	}

	public void setFechasalida(LocalDateTime fechasalida) {
		this.fechasalida = fechasalida;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public factura getIdfactura() {
		return Idfactura;
	}

	public void setIdfactura(factura idfactura) {
		Idfactura = idfactura;
	}
	

}
