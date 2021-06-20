package servico;

public class ServicoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	
	public ServicoException(String mensagem,Integer codigo) {
		
		super(mensagem);
		
		this.codigo=codigo;
		
	}
	public Integer getCodigo() {
		
		return codigo;
	}
	
	

}
