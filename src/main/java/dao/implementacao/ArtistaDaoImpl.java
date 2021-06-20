package dao.implementacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ArtistaDao;
import dominio.Artista;

public class ArtistaDaoImpl implements ArtistaDao {
	
	private EntityManager em;
	
	public ArtistaDaoImpl() {
		
		this.em = EM.getLocalEm();
		 
	}
	
	

	@Override
	public void inserirAtualizar(Artista x) {
		
		if(x.getCodArtista() !=null) {
			x = em.merge(x);
			
		}
		
		em.persist(x);
		
	}

	@Override
	public void excluir(Artista x) {
		
		x=em.merge(x);
		
		em.remove(x);
		
	}

	@Override
	public Artista buscar(int cod) {
		// TODO Auto-generated method stub
		return em.find(Artista.class, cod);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Artista> buscarTodos() {
		
		String jpql = " SELECT x FROM Artista x";
		
		Query query =em.createNamedQuery(jpql);
		
		return query.getResultList();
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Artista> buscarTodosOrdenadoPorNome(){
		
		String jpql = "SELECT x  FROM Artista x ORDER BY x.nome";
		
		Query query = em.createNamedQuery(jpql);
		
		return query.getResultList();
		
	}



	
	@SuppressWarnings("unchecked")
    @Override
	public Artista buscaNomeExato(String nome) {
		
		String jpql ="SELECT x FROM Artista x WHERE x.nome = :p1";
		
		Query query =em.createNamedQuery(jpql);
		
		query.setParameter("p1",nome);
		
		List<Artista> auxiliar = query.getResultList();
		
		return (auxiliar.size() > 0) ? auxiliar.get(0) : null;
		
	}

}
