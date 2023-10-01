package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplList;
import modelo.javabeans.Cliente;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet("/cliente")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDao cdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
        cdao = new ClienteDaoImplList();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");
		
		switch (opcion) {
		case "todos":
			procTodos(request,response);
			break;
		case "ver":
			procVerUno(request,response);
			break;
		case "eliminar":
			procEliminar(request,response);
			break;
		case "altaCliente":
			procMostrarFormularioAlta(request,response);
			break;
		default:
			System.out.println("Opción incorrecota:"+opcion);
		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensaje = null;
		Cliente cliente = new Cliente();
		cliente.setNombre(request.getParameter("nombre"));
		cliente.setCantidadEmpleados(Integer.parseInt(request.getParameter("cantidadEmpleados")));
		cliente.setFacturacionAnual(Double.parseDouble(request.getParameter("facturacionAnual")));
		
		if (cdao.insert(cliente)!=null)
			mensaje="Cliente dado de alta";
		else
			mensaje="error al dar de alta";
		
		request.setAttribute("mensaje", mensaje);
		request.setAttribute("clientes", cdao.findAll());
		request.getRequestDispatcher("inicio.jsp").forward(request, response);
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void procTodos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("clientes", cdao.findAll());
		request.getRequestDispatcher("inicio.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void procVerUno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente = cdao.findById(Integer.parseInt(request.getParameter("idCliente")));
		request.setAttribute("cliente", cliente);
		request.getRequestDispatcher("verCliente.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void procEliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensaje = null;
		if (cdao.delete(Integer.parseInt(request.getParameter("idCliente")))==1)
			mensaje="Cliente eliminado correctamete";
		else
			mensaje="Cliente no se ha podido eliminar";
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("cliente?opcion=todos").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void procMostrarFormularioAlta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("altaCliente.jsp").forward(request, response);
	}

}
