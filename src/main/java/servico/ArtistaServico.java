package servico;

import java.util.ArrayList;
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

	public void validar(Artista x)throws ValidacaoException {
		
		List<String> erros = new ArrayList<>();
		
		if(x.getNome() ==null) {
			
			erros.add(" Favor Preencher o Campo Nome");
		}
		if(x.getNacionalidade() ==null) {
			
			erros.add(" Fvor Preencher o Campo Nacionalidade");
		}
		if(x.getCache()==null) {
			
			erros.add("Favor Informar um valor para o Cache");
		}
		if(x.getNascimento()==null) {
			erros.add(" Favor Informar uma Data");
		}
		
		
		if(!erros.isEmpty()) {
			
			throw new ValidacaoException("Erro de validação ", erros);
		}
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
			
			System.out.println("Erro: " + e.getMessage());

		}

	}

	public void atualizar(Artista x) throws ServicoException {

		try {

			Artista temp = dao.buscaNomeExatoDiferente(x.getCodArtista(), x.getNome());

			if (temp != null) {

				throw new ServicoException(" Ja existe um artista com esse Nome", 1);
			}

			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		} catch (RuntimeException e) {

			if (Transaction.isActive()) {

				Transaction.rollBack();

			}
			
			System.out.println("Erro: " + e.getMessage());

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
			
			System.out.println("Erro: " + e.getMessage());

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
