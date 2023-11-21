package com.juan.poa.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Aspect
@Component
@Order(2)
public class RequisitosCliente {

	@Before("com.juan.poa.aspectos.LoginConAspecto.paraClientes()")	
	public void requisitosTabla () {
		System.out.println("Hay menos de 300 registros en la tabla, puedes insertar el nuevo cliente");
	}
}
