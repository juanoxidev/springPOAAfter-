package com.juan.poa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.juan.poa.dao.ClienteDAO;

public class clasePrincipal {

	public static void main(String[] args) {

		
		// leer la configuracion de Spring
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
		
		// obtener el bean del contenedor de Spring
		ClienteDAO  elCliente = contexto.getBean("clienteDAO", ClienteDAO.class);
		Cliente cl1 = new Cliente();
		cl1.setNombre("Juan");
		cl1.setTipo("Normal");
		// llamar al metodo
		elCliente.insertaCliente(cl1); // este es el nombre del metodo que debe coincidir con la anotacion @Before
		
		//cerrar el contexto
		contexto.close();
	}

}
