package com.ceiba.repositorio;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.dominio.Detallefactura;
import com.ceiba.dominio.factura;
import com.ceiba.repositorio.jpa.configuracionjpa;

@Component
@Transactional
public class persistenciadetallefactura implements repositoriodetallefactura{

	@Autowired
	configuracionjpa Configuracionjpa;
	
	@Override
	public Detallefactura crearDetalle(Detallefactura detalle) {
		
    return Configuracionjpa.GetEntityManager().merge(detalle);
	}

	

}
