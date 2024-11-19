package logica;

public class LogicaException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public void ErrorDeLogica (String msj) {
		this.mensaje = msj;
	}
	
	public String DarMensaje() {
		return mensaje;
	}
}
