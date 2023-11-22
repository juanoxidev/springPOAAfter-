package com.juan.poa.dao;

import org.springframework.stereotype.Component;

import com.juan.poa.Cliente;

// tiene que funcionar a modo de componente
@Component

public class ClienteDAO {

	public void insertaCliente(Cliente elCliente) {
		System.out.println("Trabajo realizado OK. cliente insertado con exito!");
	}
}
