package com.project;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "Persona", 

	uniqueConstraints = {@UniqueConstraint(columnNames = "personaId")})
public class Persona implements Serializable {

	@Id
	@Column(name = "personaId", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY) // L'id es genera automàticament
	private long personaId;

	@Column(name = "dni")
	private String dni;

	@Column(name = "nom")
	private String nom;

	@Column(name = "telefon")
	private String telefon;


	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
@JoinTable(
    name = "Persona_Llibre", 
    joinColumns = {@JoinColumn(referencedColumnName = "personaId")}, 
    inverseJoinColumns = {@JoinColumn(referencedColumnName = "llibreId")}
)
private Set<Llibre> llibres2; // Ha de tenir getter i setter perquè s'encarrega de la taula relacional N:N




	
	public Persona( String dni, String nom, String telefon) {
		
		this.dni = dni;
		this.nom = nom;
		this.telefon = telefon;
		
	}


	public long getPersonaId() {
		return personaId;
	}


	public void setPersonaId(long personaId) {
		this.personaId = personaId;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getTelefon() {
		return telefon;
	}


	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}


	public Set<Llibre> getLlibres() {
		return llibres2;
	}


	public void setLlibres(Set<Llibre> llibres) {
		this.llibres2 = llibres;
	}


	@Override
	public String toString() {
		return "Persona [personaId=" + personaId + ", dni=" + dni + ", nom=" + nom + ", telefon=" + telefon
				+ ", llibres=" + llibres2 + "]";
	}

	


	






	///public List<Object[]> queryEmployees () {
	///	long id = this.getContactId();
		///return Manager.queryTable("SELECT DISTINCT e.* FROM Employee_Contact ec, Employee e WHERE e.id = ec.employees_id AND ec.contacts_id = " + id);
	///}

	
}