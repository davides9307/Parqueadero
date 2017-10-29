package com.ceiba.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries( { @NamedQuery(name = "slot.findbytipo", query = "SELECT s FROM Slot s WHERE s.Tipoespacio = :tipo and idvehiculo IS NOT NULL"),
@NamedQuery(name = "slot.setcampo", query = "UPDATE Slot s set s.idvehiculo = NULL WHERE s.idvehiculo = :id"),
@NamedQuery(name = "slot.findall", query = "SELECT t FROM Slot t WHERE  t.idvehiculo IS NOT NULL"),
@NamedQuery(name = "slot.find", query = "SELECT t FROM Slot t ")


})
public class Slot {
	
	

	
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idslot;
	
	
	@Column(nullable = false)
	private String Tipoespacio;
	
	@OneToOne
	@JoinColumn(name="idvehiculo")
	private vehiculo idvehiculo;
	
	
	
	public Slot() {
		
		
	}
	
	public Slot(String tipoespacio) {
		
		this.Tipoespacio=tipoespacio;
	}
	
	
	public Integer getIdslot() {
		return idslot;
	}

	public void setIdslot(Integer idslot) {
		this.idslot = idslot;
	}

	public String getTipoespacio() {
		return Tipoespacio;
	}

	public void setTipoespacio(String tipoespacio) {
		this.Tipoespacio = tipoespacio;
	}
	
	public vehiculo getidvehiculo() {
		
		return idvehiculo;
		
	}
	
	public void setidvehiculo(vehiculo idvehiculo) {
		
		this.idvehiculo=idvehiculo;
	}
	

}
