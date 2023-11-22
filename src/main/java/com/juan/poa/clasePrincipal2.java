package com.juan.poa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.juan.poa.servicios.MedicionServicio;

public class clasePrincipal2 {

	public static void main(String[] args) {

		
		// leer la configuracion de Spring
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
		
		// obtener el bean del contenedor de Spring
		MedicionServicio  miServicio = contexto.getBean("medicionServicio", MedicionServicio.class);
		
		System.out.println("Llamando al metodo getServicio()");
		String datos = miServicio.getServicio();
		System.out.printf("Devolucion del metodo: %s", datos);
		contexto.close();
	}

}
