package com.ceiba.repositorio;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.dominio.Slot;
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
	public int espaciosdisponibles() {
		return Configuracionjpa.GetEntityManager().createNamedQuery("slot.findAll").getMaxResults();
		
	}
	
	
	

}
