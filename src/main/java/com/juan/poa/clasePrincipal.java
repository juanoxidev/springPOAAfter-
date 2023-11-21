package com.juan.poa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.juan.poa.dao.ClienteDAO;

public class clasePrincipal {

	public static void main(String[] args) {

		
		// leer la configuracion de Spring
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
		
		// obtener el bean del contenedor de Spring
		ClienteDAO  elCliente = contexto.getBean("clienteDAO", ClienteDAO.class);
		
		// llamar al metodo
		elCliente.insertaCliente(); // este es el nombre del metodo que debe coincidir con la anotacion @Before
		
		//cerrar el contexto
		contexto.close();
	}

}
