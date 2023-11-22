### Realizar tareas posteriores a la ejecucion de un metodo AfterReturning

Cuando utilizarlo : Acciones tras login. Postprocesado de datos modificar formatear datos tras ejecutar metodo. Cuestiones de seguridad

AfterReturning: captura el return de una funcion y hace tareas. El nombre del returning debe ser igual al nombre de la variable que le pasamos por parametro al aspecto.

```java
@AfterReturning(pointcut="execution(* com.juan.poa.dao.ClienteDAO.obtenerClientes(..))", returning="clientes")
public void tareaTrasObtenerClientes(List<Cliente> clientes) {
	for (Cliente cliente : clientes) {
		if(cliente.getTipo().equalsIgnoreCase("VIP")) System.out.println("Existen clientes VIP en el listado");		
	}
}
```


AfterThrowing: Si durante la ejecucion del programa se presenta una excepcion, podemos controlar que hacer con esta anotacion. El nombre de throwing debe coincidir con el nombre del parametro que le pasamos. 

```java
@AfterThrowing(pointcut="execution(* com.juan.poa.dao.ClienteDAO.obtenerClientes(..))",throwing="laExcepcion")
public void procesandoDatosAfterExceptionObtenerClientes(Throwable laExcepcion) {
	System.out.println("Aqui se estarian ejecutando de forma automatica las tareas tras excepcion");
}
```

After: Realiza tareas automatizadas no importa si la app lanza una excepcion o no. Parecido al finally. No tiene acceso a la excepcion
Casos de uso: guardar logs de loggins, labores de auditoria, etc.

```java
@After("execution(* com.juan.poa.dao.ClienteDAO.obtenerClientes(..))")
public void ejecutandoTareasConYSinException(JoinPoint elPoint) {
	System.out.println("Ejecutando tareas automatizadas, no importa que pase");
}
```

Around

Ejecuta tareas antes pre procesadas y despues postprocesadas del metodo que llamamos getServicio()

```java
@Around("execution(* com.juan.poa.servicio.*.getServicio(..))")
public Object ejecutarServicio(ProceedingJoinPoint elPoint) throws Throwable {
	System.out.println("========== Comienzo de acciones antes de llamar al metodo getServicio()");
	// instruccion donde el point apunta al metodo que queremos utilizar, en este caso getServicio()
	Object resultado = elPoint.proceed();
	System.out.println(" Tareas despues de llamar al metodo getServicio()");
	return resultado;
}
	
```




