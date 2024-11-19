package logica;

public class VOPersona {
	private int id;
	private String nombre;
	private int edad;
	
	public VOPersona (Persona persona) {
		this.id = persona.getId();
        this.nombre = persona.getNombre();
        this.edad = persona.getEdad();
	}
	
	public VOPersona(int id, String nombre, int edad) {
	    this.id = id;
	    this.nombre = nombre;
	    this.edad = edad;
	}
	
	public int getId () {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getEdad() {
		return edad;
	}
}
