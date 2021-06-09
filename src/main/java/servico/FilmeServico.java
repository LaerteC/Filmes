package servico;

import java.util.List;

import dao.DaoFactory;
import dao.FilmeDao;
import dao.implementacao.EM;
import dominio.Filme;

public class FilmeServico {

	
	private FilmeDao dao ;
	
	public FilmeServico() {
		
		dao = DaoFactory.criarFilmeDao();
	}
	
	
	public void inserirAtualizar(Filme x) {
		
		EM.getLocalEm().getTransaction().begin();
		
		dao.inserirAtualizar(x);
		
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Filme x) {
		
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
		
	}
	
	public Filme buscar(int cod) {
		
		
		return dao.buscar(cod);
	
	}
	
	public List<Filme> buscarTodos(){
		
		return dao.buscarTodos();
		
	}
}
