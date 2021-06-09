package dao;

import dao.implementacao.ArtistaDaoImpl;
import dao.implementacao.FilmeDaoImpl;
import dao.implementacao.ParticipacaoDaoImpl;

public class DaoFactory {
	
	public static ArtistaDao criarArtistaDao() {
		
		return new ArtistaDaoImpl();
		
	}
	
	public static FilmeDao criarFilmeDao() {
		
		return new FilmeDaoImpl();
		
	}
	
	public static ParticipacaoDao criarParticipacaoDap() {
		
		return new ParticipacaoDaoImpl();
		
	}

}
