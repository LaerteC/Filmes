package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Artista;
import servico.ArtistaServico;

@WebServlet("/artista/editar")
public class ArtistaEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/artista/formEditar.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		int cod = Integer.parseInt(request.getParameter("cod"));
		
		
				
		ArtistaServico as = new ArtistaServico();
		
		Artista artista =  as.buscar(cod);
		
		
		
		request.setAttribute("item", artista);

		request.getRequestDispatcher(DESTINO).forward(request, response);

	}
}
