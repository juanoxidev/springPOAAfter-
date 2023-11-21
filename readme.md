### Aspecto (Aspect):

Un "aspecto" en Spring es una forma de modularizar aspectos transversales o preocupaciones comunes en tu aplicación que no están directamente relacionados con la funcionalidad principal del negocio. Los aspectos se utilizan para encapsular comportamientos que se aplican a múltiples puntos de tu aplicación.
 
En Spring, los aspectos se implementan utilizando AOP (Aspect-Oriented Programming). Se definen mediante clases especiales llamadas "aspectos", que contienen métodos llamados "advice" que se ejecutan en puntos específicos del código de la aplicación (por ejemplo, antes o después de un método).
 
> ```java
> @Aspect
> public class LoggingAspect {
> 
>    @Before("execution(* com.example.service.*.*(..))")
>    public void logBeforeMethodExecution(JoinPoint joinPoint) {
>        // Lógica de logging antes de la ejecución del método
>    }
> }
> ```

### Bean:

Un "bean" en Spring es simplemente un objeto que es gestionado por el contenedor de Spring (ApplicationContext). Estos objetos son creados, configurados y administrados por Spring. Los beans en Spring son componentes reutilizables que forman la base de la configuración de una aplicación Spring.
 
Pueden ser instancias de clases normales de Java o instancias de clases específicas de Spring (por ejemplo, controladores, servicios, repositorios, etc.). Los beans suelen estar decorados con anotaciones como `@Component`, `@Service`, `@Repository`, etc.
 
> ```java
> @Service
> public class MiServicio {
>    // Lógica del servicio
> }
> ```

En resumen, un "aspecto" es un concepto de programación orientada a aspectos utilizado para modularizar preocupaciones transversales en la aplicación, mientras que un "bean" es simplemente un objeto gestionado por el contenedor de Spring. Aunque ambos conceptos son fundamentales en Spring, cumplen propósitos diferentes en la arquitectura de la aplicación.

## Programacion orientada a aspectos

### Pointcut expressions


Podemos indicarle al aspecto que se ejectue cuando un metodo devuelva void y se llame `insertaCliente` va a ejecutar el aspecto en el metodo indicado de cualquier clase.
`@Before("execution(public void insertaCliente())")	`

Podemos indicarle al aspecto que se ejectue cuando un metodo devuelva void y empiece con alguna palabra ej `inserta*` va a ejecutar el aspecto a todos los metodos que empiecen con inserta.
`@Before("execution(public void inserta*())")	`

Podemos indicarle al aspecto que se ejectue cuando un metodo devuelva cualquier dato y empiece con alguna palabra ej `inserta*` va a ejecutar el aspecto a todos los metodos que empiecen con inserta.
`@Before("execution(public * inserta*())")	`


Podemos indicarle al aspecto que se ejectue cuando un metodo devuelva cualquier dato, que reciba cualquier parametro/s y empiece con alguna palabra ej `inserta*` va a ejecutar el aspecto a todos los metodos que empiecen con inserta.
`@Before("execution(public * inserta*(..))")	`

Podemos indicarle al aspecto que se ejectue cuando un metodo devuelva cualquier dato, que reciba un tipo de dato en particular o particular y otros, y empiece con alguna palabra ej `inserta*` va a ejecutar el aspecto a todos los metodos que empiecen con inserta.
`@Before("execution(public * inserta*(com.juan.poa.dao.ClienteDAO))")	`

`@Before("execution(public * inserta*(com.juan.poa.dao.ClienteDAO, ..))")	`


Podemos indicarle al aspecto que se ejectue cuando un metodo de la clase X devuelva cualquier dato, que reciba cualquier parametro/s  y empiece con alguna palabra ej `inserta*` va a ejecutar el aspecto a todos los metodos que empiecen con inserta de la clase indicada.

`@Before("execution(public * com.juan.poa.dao.ClienteDAO.inserta*(..))")	`

Reutilizacion de pointcut expressions 

```java
@Pointcut("execution(public * insertaCliente(..))")
private void paraClientes() {}
```

Siempre que insertemos un cliente primero se van a realizar estas tareas:

```java
@Before("paraClientes()")	
public void antesInsertarCliente () {
	System.out.println("El usuario esta logeado");
	System.out.println("El perfil para insertar clientes es correcto");
}
```

se ejecute el pointcut en un package, que actue en cualquier metodo tengan los parametros que tengan  

```java
@Pointcut("execution(* com.juan.poa.*.*(..))")
private void paraClientes() {}
```


se ejecute el pointcut en un package, que actue en los metodos getter tengan los parametros que tengan  

```java
@Pointcut("execution(* com.juan.poa.*.get*(..))")
private void paraGetters() {}
```


se ejecute el pointcut en un package, que actue en los metodos setter tengan los parametros que tengan  

```java
@Pointcut("execution(* com.juan.poa.*.set*(..))")
private void paraSetters() {}
```

### Combinacion de pointcut expressions con valores logicos

Actuar en todos los metodos menos en los setters y los getters

```java
@Pointcut("execution(* com.juan.poa.*.set*(..))")
private void paraClientes() && !(paraGetters() || paraSetters()) {}
private void paraPaqueteExceptoSettersyGetters() {}
```