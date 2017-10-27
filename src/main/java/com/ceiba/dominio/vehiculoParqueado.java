package com.ceiba.dominio;

public class vehiculoParqueado {
	
	
	private vehiculo Vehiculo;
	private Slot slot;
	
	
	public vehiculo getVehiculo() {
		return Vehiculo;
	}
	public void setVehiculo(vehiculo vehiculo) {
		Vehiculo = vehiculo;
	}
	public Slot getSlot() {
		return slot;
	}
	public void setSlot(Slot slot) {
		this.slot = slot;
	}
	
	
}