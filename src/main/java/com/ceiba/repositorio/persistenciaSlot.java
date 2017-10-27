package com.ceiba.repositorio;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.dominio.Slot;
import com.ceiba.dominio.vehiculo;
import com.ceiba.repositorio.jpa.configuracionjpa;


@Component
@Transactional
public class persistenciaSlot implements repositorioSlot{

	
	@Autowired
	configuracionjpa Configuracionjpa;
	
	@Override
	public Slot guardarenslot(Slot slot) {
		
		
		return Configuracionjpa.GetEntityManager().merge(slot);
		
	}

	@Override
	public List<Slot> espaciosdisponibles(Slot slot) {
		
		
		
		Query query = Configuracionjpa.GetEntityManager().createNamedQuery("slot.findbytipo");
		query.setParameter("tipo", slot.getTipoespacio());
		return query.getResultList();
		
	}
	
	
	@Override
	public Slot borrarslot(Slot slot) {
		
	   Slot slotencontrado=Configuracionjpa.GetEntityManager().find(Slot.class,slot.getIdslot());
	   Configuracionjpa.GetEntityManager().remove(slotencontrado);
		return slotencontrado;
	}

	@Override
	public void Actualizarslot(Slot slot) {
		
	
		Configuracionjpa.GetEntityManager().merge(slot);
		
	}
	
	
	

}
