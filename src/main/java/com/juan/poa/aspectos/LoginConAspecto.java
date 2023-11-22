package com.juan.poa.aspectos;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.juan.poa.Cliente;

@Aspect
@Component
@Order(3)
public class LoginConAspecto {

@Around("execution(* com.juan.poa.servicios.*.getServicio(..))")
public Object ejecutarServicio(ProceedingJoinPoint elPoint) throws Throwable {
	
	System.out.println("========== Comienzo de acciones antes de llamar al metodo getServicio()");
	long comienzo = System.currentTimeMillis();
	// instruccion donde el point apunta al metodo que queremos utilizar, en este caso getServicio()
	Object resultado = elPoint.proceed();
	System.out.println(" Tareas despues de llamar al metodo getServicio() ==========");
	long fin = System.currentTimeMillis();
	long duracion = fin - comienzo;
	System.out.printf(" El metodo tardo %d segundos %n", duracion/1000);
	return resultado;
}
	
	
	
@After("execution(* com.juan.poa.dao.ClienteDAO.obtenerClientes(..))")
public void ejecutandoTareasConYSinException(JoinPoint elPoint) {
	System.out.println("Ejecutando tareas automatizadas, no importa que pase");
}

@AfterThrowing(pointcut="execution(* com.juan.poa.dao.ClienteDAO.obtenerClientes(..))",throwing="laExcepcion")
public void procesandoDatosAfterExceptionObtenerClientes(Throwable laExcepcion) {
	System.out.println("Aqui se estarian ejecutando de forma automatica las tareas tras excepcion");
}
	
	
@AfterReturning(pointcut="execution(* com.juan.poa.dao.ClienteDAO.obtenerClientes(..))", returning="clientes")	
public void tareaTrasObtenerClientes(List<Cliente> clientes) {
	for (Cliente cliente : clientes) {
		if(cliente.getTipo().equalsIgnoreCase("VIP")) { 
			procesadoDatosAfterReturning(cliente);
			System.out.printf("Existen clientes VIP en el listado. Nombre: %s %n", cliente.getNombre());		
		}
	}
}
	
	
	private void procesadoDatosAfterReturning(Cliente cliente) {
		cliente.setNombre(String.format("V.I.P %s", cliente.getNombre().toUpperCase()));
	
	
}


//reutilizacion de pointcut
	// que se ejecute el pointcut un package, que actue en cualquier metodo tengan los parametros que tengan  
@Pointcut("execution(* com.juan.poa.dao.*.*(..))")
public void paraClientes() {}

// ORDENAR ASPECTOS  ORDER(1)ORDER(2)ORDER(3) EN LAS CLASES

	// siempre que insertemos un cliente primero se van a realizar estas tareas:
@Before("paraClientes()")	
public void antesInsertarCliente (JoinPoint miJoin) {
	
	/*rescatamos los argumentos de insertaCliente con el metodo getArgs() nos retorna un array de tipo Object
	 * con todos los argumentos del metodo que se ejecutara a continuacion
	 */

	Object[] argumentos= miJoin.getArgs();
	for (Object object : argumentos) {
		if(object instanceof Cliente) {
			Cliente elCliente = (Cliente) object;
			System.out.printf("Nombre del cliente: %s %n", elCliente.getNombre());
			System.out.printf("Tipo del cliente: %s %n", elCliente.getTipo());
		}
	}
	System.out.println("El usuario esta logeado");
	System.out.println("El perfil para insertar clientes es correcto");
}


}
