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

	public void inserir(Artista x) throws ServicoException {

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

	public void atualizar(Artista x) {

		try {

			Artista temp = dao.buscaNomeExatoDiferente(x.getCodArtista(), x.getNome());

			if (temp != null) {

				throw new ServicoException(" Ja existe um artista com esse Nome", 1);
			}

			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		} catch (Exception e) {

			if (Transaction.isActive()) {

				Transaction.rollBack();

			}

		}
	}

	public void excluir(Artista x) throws ServicoException {

		try {
			x = dao.buscar(x.getCodArtista());

			if (!x.getParticipacoes().isEmpty()) {

				throw new ServicoException(" Artista possui Participações", 2);
			}

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

	public List<Artista> buscarPorNome(String trecho) {

		return dao.buscarPorNome(trecho);
	}

}
