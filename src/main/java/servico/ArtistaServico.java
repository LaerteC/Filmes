package servico;

import java.util.List;

import dao.ArtistaDao;
import dao.DaoFactory;
import dao.Transaction;
import dominio.Artista;

public class ArtistaServico {

	private ArtistaDao dao;

	public ArtistaServico() {

		dao = DaoFactory.criarArtistaDao();

	}

	public void inserirAtualizar(Artista x) throws ServicoException {

		try {

			Artista temporario = dao.buscaNomeExato(x.getNome());

			if (temporario != null) {
				throw new ServicoException("Já existe um Artista com esse Nome", 1);
			}

			Transaction.begin();

			dao.inserirAtualizar(x);

			Transaction.commit();

		} catch (RuntimeException e) {

			if (Transaction.isActive()) {

				Transaction.rollBack();
			}

		}

	}

	public void excluir(Artista x) {

		try {
			Transaction.begin();

			dao.excluir(x);

			Transaction.commit();

		} catch (RuntimeException e) {

			if (Transaction.isActive()) {

				Transaction.rollBack();
			}

		}

	}

	public Artista buscar(int cod) {

		return dao.buscar(cod);

	}

	public List<Artista> buscarTodos() {

		return dao.buscarTodos();

	}

	public List<Artista> buscarTodosOrdenadoPorNome() {

		return dao.buscarTodosOrdenadoPorNome();
	}

}
