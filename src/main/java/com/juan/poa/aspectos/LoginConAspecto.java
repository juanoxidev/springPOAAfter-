package com.juan.poa.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class LoginConAspecto {
	//reutilizacion de pointcut
	// que se ejecute el pointcut un package, que actue en cualquier metodo tengan los parametros que tengan  
@Pointcut("execution(* com.juan.poa.dao.*.*(..))")
public void paraClientes() {}

// ORDENAR ASPECTOS  ORDER(1)ORDER(2)ORDER(3) EN LAS CLASES

	// siempre que insertemos un cliente primero se van a realizar estas tareas:
@Before("paraClientes()")	
public void antesInsertarCliente () {
	System.out.println("El usuario esta logeado");
	System.out.println("El perfil para insertar clientes es correcto");
}


}
