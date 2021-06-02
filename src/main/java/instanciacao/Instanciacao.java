package instanciacao;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Artista;
import dominio.Filme;
import dominio.Participacao;

/**
 * Servlet implementation class Instanciacao
 */

@WebServlet("/Instanciacao")
public class Instanciacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			Filme f1 = new Filme(null, "O aviado", 170, 2005);

			Filme f2 = new Filme(null, "Titanic", 195, 1997);

			Artista a1 = new Artista(null, "Leonardo di Caprio", "EUA", new BigDecimal("10000.00"),
					sdf.parse("11/11/1974"));

			Artista a2 = new Artista(null, "Cate Blancett", " Austr�lia", new BigDecimal("50000.00"),
					sdf.parse("14/05/1973"));

			Artista a3 = new Artista(null, "Kate Winslett", "UK", new BigDecimal("800.00"), sdf.parse("05/10/1975"));

			Participacao p1 = new Participacao(null, "Jack Dawson", new BigDecimal("2000.00"), f2, a1);

			Participacao p2 = new Participacao(null, "Howard", new BigDecimal("1000.00"), f1, a1);

			Participacao p3 = new Participacao(null, "Rose Bukater", new BigDecimal("1000.00"), f2, a3);

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("meujpa");
			
			EntityManager em= emf.createEntityManager();
			
			em.getTransaction().begin();
			em.persist(f1);
			em.persist(f2);
			em.persist(a1);
			em.persist(a2);
			em.persist(a3);
			em.persist(p1);
			em.persist(p2);
			em.persist(p3);
			
			
			em.getTransaction().commit();
			
			em.close();
			emf.close();
			
			
			

			response.getWriter().append(" Laerte Est� Aprendendo a porra toda!!!!  ");

		} catch (ParseException e) {

			response.getWriter().append(" Erro ao Instanciar Data !!!");
			e.printStackTrace();
		}

	}

}
