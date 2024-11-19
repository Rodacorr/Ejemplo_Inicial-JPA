package persistencia;

public class PersistenciaException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public void ErrorDePersistencia (String msj) {
		this.mensaje = msj;
	}
	
	public String DarMensaje() {
		return mensaje;
	}
}
