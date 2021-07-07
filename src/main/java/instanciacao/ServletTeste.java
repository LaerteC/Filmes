package instanciacao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Filme;
import servico.FilmeServico;

@WebServlet("/ServletTeste")
public class ServletTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Servidor Funcionandoo ").append(request.getContextPath());
		
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.parse("01/03/1954");
			
			FilmeServico fs = new FilmeServico();
			
			List<Filme> lista = fs.buscarPorNomeAno("o",1997,2005);
				
				for(Filme m : lista) {
					
					response.getWriter().append(m +" \n");
				}
		
		
		}catch(Exception ex) {
			
			response.getWriter().append(ex.getMessage());
			
		}
	}

}
