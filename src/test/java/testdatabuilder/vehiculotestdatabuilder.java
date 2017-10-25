package testdatabuilder;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ceiba.dominio.vehiculo;



public class vehiculotestdatabuilder {

	private static final String MATRICULA = "CRT903";
	private static final String CILINDRAJE = "200CC";
	private static final String MARCA = "FERRARI";
	private static final String FECHAENTRADA = "02/03/2017";
	
	
	
	private String Matricula;
	private String Cilindraje;
	private String Marca;
	//private Date Fechaentrada;
	
	
	public vehiculotestdatabuilder() {
		this.Matricula = MATRICULA;
		this.Cilindraje = CILINDRAJE;
		this.Marca = MARCA;
		//this.Fechaentrada = DateFECHAENTRADA;
	}

	public vehiculotestdatabuilder conMatricula(String matricula) {
		this.Matricula = matricula;
		return this;
	}

	public vehiculotestdatabuilder conCilindraje(String cilindraje) {
		this.Cilindraje = cilindraje;
		return this;
	}

	public vehiculotestdatabuilder conMarca(String marca) {
		this.Marca = marca;
		return this;
	}

	public vehiculo build() {
		return new vehiculo(this.Matricula, this.Cilindraje, this.Marca);
	}
	
	
	
	
	
}
