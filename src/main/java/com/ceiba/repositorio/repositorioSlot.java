package com.ceiba.repositorio;

import java.util.List;

import com.ceiba.dominio.Slot;

public interface repositorioSlot {

	public Slot guardarenslot(Slot slot);
	
	public List<Slot> espaciosdisponibles(Slot slot);
		
	public Slot borrarslot(Slot slot);	
	
	public void Actualizarslot(Slot slot);

	
}
