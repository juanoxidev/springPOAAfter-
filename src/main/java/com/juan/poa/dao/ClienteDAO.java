package com.juan.poa.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.juan.poa.Cliente;

// tiene que funcionar a modo de componente
@Component

public class ClienteDAO {

	public void insertaCliente(Cliente elCliente) {
		System.out.println("Trabajo realizado OK. cliente insertado con exito!");
	}
	
	public List<Cliente> obtenerClientes(boolean miParam){
		if (miParam)  throw new RuntimeException("Error no se ha podido procesar la peticion");
		
		List<Cliente> clientes = new ArrayList<>();
		//simular clientes devueltos por BBDD
		Cliente cl1 = new Cliente ("Maria", "Normal");
		Cliente cl2 = new Cliente ("Ana", "Normal");
		Cliente cl3 = new Cliente ("Sandra", "VIP");
		Cliente cl4 = new Cliente ("Antonio", "Normal");
		// agregar clientes a lsita
		clientes.add(cl1);
		clientes.add(cl2);
		clientes.add(cl3);
		clientes.add(cl4);
		System.out.println("Ejecucion finalizada de metodo obtenerClientes()");
		return clientes;
	}
}
