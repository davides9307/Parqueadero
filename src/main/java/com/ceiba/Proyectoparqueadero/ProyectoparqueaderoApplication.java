package com.ceiba.Proyectoparqueadero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("com.ceiba.restservice")
@ComponentScan("com.ceiba.repositorio.jpa")
@ComponentScan("com.ceiba.dominio")
@ComponentScan("com.ceiba.repositorio")
@EntityScan(basePackages="com.ceiba.dominio")
@ComponentScan("com.ceiba.servicio")
public class ProyectoparqueaderoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoparqueaderoApplication.class, args);
	}
}
