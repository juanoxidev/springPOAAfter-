package mvcspringprueba.com.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import mvcspringprueba.com.controlador.entity.Cliente;
import mvcspringprueba.com.dao.ClienteDAO;

@Controller
@RequestMapping("/cliente")
public class Controlador {
	@Autowired
	private ClienteDAO clienteDAO;
 
	@RequestMapping("/lista")
	public String listaClientes(Model elModelo) {
		// obtener los clientes desde el DAO 
		List<Cliente> losClientes = clienteDAO.getClientes();
		// agregar los clientes al modelo
		elModelo.addAttribute("clientes",losClientes);
		return "lista-clientes";
	}
	
	@RequestMapping("/muestraFormularioAgregar")
	public String retornarFormAgregarCliente(Model elModelo) {
		// Bind de datos de los clientes
		Cliente elCliente = new Cliente();
		elModelo.addAttribute("cliente", elCliente);
		return "formularioCliente";
	}
	
	@RequestMapping("/insertarCliente")
	public String agregarCliente(@ModelAttribute("cliente") Cliente elCliente) {
		// InsertarCliente en la BBDD
		clienteDAO.insertarCliente(elCliente);
		// redireccion a la lista de clientes
		return "redirect:/cliente/lista";
	}
}
