package com.ceiba.repositorio.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ceiba.dominio.vehiculo;



@Repository
@Transactional
public class persistenciasistema implements configuracionjpa{

	@PersistenceContext
	private EntityManager Entitymanager;
	
	
	@Override
	public EntityManager GetEntityManager() {
		
		return Entitymanager;
	}
	
	

	
	
}
