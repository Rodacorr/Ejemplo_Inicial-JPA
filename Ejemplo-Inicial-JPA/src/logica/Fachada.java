package logica;

import java.util.List;

import persistencia.DAOPersonas;

public class Fachada {
	private DAOPersonas daoP;
	
	public Fachada() {
		daoP = new DAOPersonas();
	}
	
	public void nuevaPersona(VOPersona vop) {
		Persona persona = new Persona(vop.getId(), vop.getNombre(), vop.getEdad());
		daoP.insert(persona);
	}
	
	public VOPersona obtenerPersona(int id) {
		Persona persona = daoP.find(id);
		if(persona != null) {
			 return new VOPersona(persona);
        } else
            return null;
	}
	
	public List<VOPersona> listarMayores(int edad){
		return daoP.listarMayores(edad);
	}
}
