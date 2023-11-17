package mvcspringprueba.com.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mvcspringprueba.com.controlador.entity.Cliente;
// para que spring registe esta clase como un bean usamos la annotation repository
@Repository
public class ClienteDAOClass implements ClienteDAO {
// lo llamamos igual a como lo espeficiamos al hibernate sessionfactory  en el archivo spring-crud-servlet.xml
// hacemos una inyeccion de dependencias para sesionfactory por eso usamos @Autowired
	@Autowired
	private SessionFactory sessionFactory;
	// la anotacion transactional nos permite prescindir de crear la transaccion, hacer el begin commit rollback  
	@Override
	@Transactional
	public List<Cliente> getClientes() {
		// obtener la session 
		Session miSession = sessionFactory.getCurrentSession();
		
		//crear la consulta Query
		
		Query<Cliente> miQuery= miSession.createQuery("from Cliente", Cliente.class);
		
		// ejecutar la Query y devolver resultados
		List<Cliente> clientes = miQuery.getResultList();
		
		return clientes;
	}
	@Override
	@Transactional
	public void insertarCliente(Cliente elCliente) {
		// obtener la session 
		Session miSession = sessionFactory.getCurrentSession();
		// insertar el cliente
		miSession.save(elCliente);
		
	}
	

}
