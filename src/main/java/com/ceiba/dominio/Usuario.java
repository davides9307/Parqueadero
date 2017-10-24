package com.ceiba.dominio;

public class Usuario {
	
	private Integer IdUsuario;
	private String Nombre;
	private String Apellido;
	private String Cedula;
	private int IdVehiculo;
	
	
	public Usuario(Integer idUsuario, String nombre, String apellido, String cedula) {
		super();
		IdUsuario = idUsuario;
		Nombre = nombre;
		Apellido = apellido;
		Cedula = cedula;
	}


	public Integer getIdUsuario() {
		return IdUsuario;
	}


	public String getNombre() {
		return Nombre;
	}


	public String getApellido() {
		return Apellido;
	}


	public String getCedula() {
		return Cedula;
	}
	
	

}
