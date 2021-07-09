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

@WebServlet("/filme/pesquisar")
public class FilmePesquisar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/filme/formPesquisar.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	
	request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
