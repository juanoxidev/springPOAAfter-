package mvcspringprueba.com.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	
	@PostMapping("/insertarCliente")
	public String agregarCliente(@ModelAttribute("cliente") Cliente elCliente) {
		// InsertarCliente en la BBDD
		clienteDAO.insertarCliente(elCliente);
		// redireccion a la lista de clientes
		return "redirect:/cliente/lista";
	}
	
	@GetMapping("/muestraFormularioActualizar")
	/* La anotación @RequestParam se utiliza para extraer el valor del parámetro de la URL. 
	El nombre del parámetro en el método (clienteId) debe coincidir con el nombre especificado en la URLindicada en el jsp c:param (clienteId) .*/
	public String muestraFormularioActualizar(@RequestParam("clienteId")int id, Model elModelo) {
		// Obtener el cliente segun id pasado por parametro
		Cliente elCliente = clienteDAO.getCliente(id);
		// Establecer el cliente como atributo del modelo
		elModelo.addAttribute("cliente",elCliente);
		// Enviar el atributo al formulario
		return "formularioCliente";
	}
	
	@GetMapping("/muestraFormularioActualizar")
	/* La anotación @RequestParam se utiliza para extraer el valor del parámetro de la URL. 
	El nombre del parámetro en el método (clienteId) debe coincidir con el nombre especificado en la URLindicada en el jsp c:param (clienteId) .*/
	public String eliminarCliente(@RequestParam("clienteId")int id) {
		// Eliminar el cliente segun id pasado por parametro
		 clienteDAO.eliminarCliente(id);
// redireccionar a la lista de clientes
		return "redirect:/cliente/lista";
	}
}
