package mvcspringprueba.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CRUDConecta
 */
@WebServlet("/CRUDConecta")
public class CRUDConecta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDConecta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String jdbcUrl = "jdbc:mysql://localhost:3306/gestionpedidoscrud?useSSL=false";
		String usuario = "root";
		String pass = "";
		// cadena de conexion de mysql 8
		String driver = "com.mysql.cj,jdbc.Driver";
		try {
			// printwriter escribe en el navegador
			PrintWriter out= response.getWriter();
			
			// que nos diga a que base de datos nos estamos conectando
			out.print("Nombre de la base de datos: " + jdbcUrl + "<br>");
			
			//cargamos el driver de la bbdd 
			Class.forName(driver);
			
			// establecemos la conexion con la bbdd
			Connection miConexion = DriverManager.getConnection(jdbcUrl, usuario, pass);
			
			out.print("Conectado");
			
			// cerramos la conexion 
			miConexion.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
