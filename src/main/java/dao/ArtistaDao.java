package dao;

import java.util.List;

import dominio.Artista;

public interface ArtistaDao {

	public void inserirAtualizar(Artista x);

	public void excluir(Artista x);

	public Artista buscar(int cod);

	public List<Artista> buscarTodos();

	public List<Artista> buscarTodosOrdenadoPorNome();

	public Artista buscaNomeExato(String nome);

	public List<Artista> buscarPorNome(String trecho);

	public Artista buscaNomeExatoDiferente(Integer codigo, String nome);

}
