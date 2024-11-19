package logica;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Persona")
@NamedQuery(name="Persona.porEdad", query="SELECT p FROM Persona p WHERE p.edad >= :edad")

public class Persona implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id	  
	  @Column(name = "id")
	  private int id;
	  
	  @Column(name = "nombre")
	  private String nombre;
	  
	  @Column(name = "edad")
	  private int edad;
	  
	  public Persona() {
		  
	  }
	  
	  public Persona(int id, String nombre, int edad) {
		  this.id = id;
		  this.nombre = nombre;
		  this.edad = edad;
	  }
	  
	  public int getId()
	  {
		  return id;
	  }

	  public String getNombre()
	  {
		  return nombre;
	  }
	  
	  public int getEdad()
	  {
		  return edad;
	  }

	  public void setId (int id)
	  {
		  this.id = id;
	  }
	  
	  public void setNombre (String nombre)
	  {
		  this.nombre = nombre;
	  }
	  
	  public void setEdad (int edad) 
	  {
		  this.edad = edad;
	  }

}
