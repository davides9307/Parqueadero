package com.ceiba.repositorio;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.dominio.factura;
import com.ceiba.repositorio.jpa.configuracionjpa;


@Component
@Transactional
public class persistenciafactura implements repositoriofactura {

	@Autowired
	configuracionjpa Configuracionjpa;
	
	
	@Override
	public factura crearfactura(factura Factura) {
		
		
		return Configuracionjpa.GetEntityManager().merge(Factura);
	}

	
	
}
