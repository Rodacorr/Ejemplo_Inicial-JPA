package persistencia;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import logica.Persona;
import logica.VOPersona;

public class DAOPersonas {
	EntityManagerFactory factory = null;
	EntityManager manager = null;
	
	public DAOPersonas() {
		factory = Persistence.createEntityManagerFactory("Principal");
	}
	
	public boolean member(int id) {
		boolean bool = false;
		manager = factory.createEntityManager();
		try {
			Persona per = manager.find(Persona.class, id);
			if(per != null)
				bool = true;

		}catch (Exception e){
			e.printStackTrace();
			/* Si algo salio mal, cierro la transacci�n mediante rollback */
		}
		manager.close();
		return bool;
	}
	
	public void insert(Persona persona) {
		manager = factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(persona);
			manager.getTransaction().commit();

		}catch (Exception e){
			e.printStackTrace();
			/* Si algo salio mal, cierro la transacci�n mediante rollback */
			if (manager != null)
		    	manager.getTransaction().rollback();
		}
	}
	
	public Persona find(int id) {
		manager = factory.createEntityManager();
		Persona per = null;
		try {
			per = manager.find(Persona.class, id);
		}catch (Exception e){
			e.printStackTrace();
			/* Si algo salio mal, cierro la transacci�n mediante rollback */
			if (manager != null)
		    	manager.getTransaction().rollback();
		}
		return per;
	}

	public List<VOPersona> listarMayores(int edad) {
	    manager = factory.createEntityManager();
	    List<VOPersona> lista = null;
	    try {
	        Query query = manager.createNamedQuery("Persona.porEdad", Persona.class)
	            .setParameter("edad", edad);
	        List<Persona> personas = query.getResultList();
	        lista = new ArrayList<>();
	        for (Persona persona : personas) {
	            lista.add(new VOPersona(persona));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        if (manager != null)
	            manager.getTransaction().rollback();
	    }
	    if (lista != null && !lista.isEmpty()) {
	        return lista;
	    } else {
	        System.out.println("La lista está vacía");
	        return null;
	    }
	}
}
