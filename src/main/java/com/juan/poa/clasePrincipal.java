package com.juan.poa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.juan.poa.dao.ClienteDAO;

public class clasePrincipal {

	public static void main(String[] args) {

		
		// leer la configuracion de Spring
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
		
		// obtener el bean del contenedor de Spring
		ClienteDAO  elCliente = contexto.getBean("clienteDAO", ClienteDAO.class);
		
		boolean miParam=false;
		try {
		// llamar al metodo
		elCliente.obtenerClientes(miParam); // este es el nombre del metodo que debe coincidir con la anotacion @Before
		}catch(Exception e){
			System.out.println("Excepcion lanzada desde la clase principal");
			System.out.println(e.getMessage());
		}
		//cerrar el contexto
		System.out.println("Aqui continuaria la ejecucion del programa");
		contexto.close();
	}

}
