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
@NamedQueries( { @NamedQuery(name = "slot.findAll", query = "SELECT s FROM Slot s WHERE s.Tipoespacio = carro") })
public class Slot {
	
	
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idslot;
	
	
	@Column(nullable = false)
	private String Tipoespacio;
	
	
	
	
	
	public Integer getIdslot() {
		return idslot;
	}

	public void setIdslot(Integer idslot) {
		idslot = idslot;
	}

	public String getTipoespacio() {
		return Tipoespacio;
	}

	public void setTipoespacio(String tipoespacio) {
		Tipoespacio = tipoespacio;
	}
	
	
	

}
