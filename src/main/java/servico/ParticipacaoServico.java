package servico;

import java.util.List;

import dao.DaoFactory;
import dao.ParticipacaoDao;
import dao.Transaction;
import dominio.Participacao;

public class ParticipacaoServico {

	private ParticipacaoDao dao;

	public ParticipacaoServico() {

		dao = DaoFactory.criarParticipacaoDap();

	}

	public void atualizar(Participacao x) throws ServicoException {
		
		Participacao aux = dao.buscarExatoDiferente(x.getCodParticipacao(),x.getPersonagem(),x.getArtista(),x.getFilme());
		
		if(aux != null) {
			
			throw new ServicoException(" Erro, ao Atualizar !!!"+x.getArtista().getNome(),2);
		}

		try {
			Transaction.begin();

			dao.inserirAtualizar(x);

			Transaction.commit();

		} catch (RuntimeException e) {

			if (Transaction.isActive()) {

				Transaction.rollBack();
			}

			System.out.println(" Error " + e.getMessage());
		}

	}

	public void inserir(Participacao x) throws ServicoException {
		
		Participacao auxiliar = dao.buscarExato(x.getPersonagem(),x.getArtista(),x.getFilme());
		
		if(auxiliar != null) {
			
			throw new ServicoException(" Já existe esse Personagem para esse Artista "+x.getArtista().getNome(),1);
		}

		try {
			Transaction.begin();
			
			dao.inserirAtualizar(x);
			
			Transaction.commit();
			
		} catch (RuntimeException e) {

			if (Transaction.isActive()) {
				
				Transaction.rollBack();
			}

			System.out.println(" Error " + e.getMessage());
		}
	}

	public void excluir(Participacao x) {

		try {

			Transaction.begin();

			dao.excluir(x);

			Transaction.commit();

		} catch (RuntimeException e) {

			if (Transaction.isActive()) {

				Transaction.rollBack();

			}

			System.out.println(" Error " + e.getMessage());

		}

	}

	public Participacao buscar(int cod) {

		return dao.buscar(cod);

	}

	public List<Participacao> buscarTodos() {

		return dao.buscarTodos();
	}

}
