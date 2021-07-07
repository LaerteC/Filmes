package web;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import dominio.Artista;

public class Instanciar {
	
	
	
	public static Artista artista(HttpServletRequest request) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		Artista auxiliar = new Artista();
		String s;
		
		
		s=request.getParameter("codArtista");
		if (s != null && !s.isEmpty()) {
			try {
				auxiliar.setCodArtista(Integer.parseInt(s));
			}catch(NumberFormatException e) {
				System.out.println("Instanciacao: codArtista invalido");
			}
			
			
		}
		
		
		s=request.getParameter("nome");
		if (s != null && !s.isEmpty()) {
			
			auxiliar.setNome(s);
			
		}
		

		s=request.getParameter("nacionalidade");
		if (s != null && !s.isEmpty()) {
			
			auxiliar.setNacionalidade(s);
			
		}
		
		s=request.getParameter("cache");
		if (s != null && !s.isEmpty()) {
			
			auxiliar.setCache(new BigDecimal(s));
			
		}
		
		s=request.getParameter("nascimento");
		if (s != null && !s.isEmpty()) {
			
			try {
				auxiliar.setNascimento(sdf.parse(s));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return auxiliar;
		
	}

}
