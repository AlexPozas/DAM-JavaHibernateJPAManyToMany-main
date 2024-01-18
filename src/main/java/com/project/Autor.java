package com.project;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "Autor", 

	uniqueConstraints = {@UniqueConstraint(columnNames = "autorId")})
public class Autor implements Serializable {

	@Id
	@Column(name = "autorId", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY) // L'id es genera automàticament
	private long autorId;

	@Column(name = "nom")
	private String nom;


	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private Set<Llibre> llibres;


	public Autor(String nom) {
		
		this.nom = nom;
		
	}


	public long getAutorId() {
		return autorId;
	}


	public void setAutorId(long autorId) {
		this.autorId = autorId;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Set<Llibre> getLlibres() {
		return llibres;
	}


	public void setLlibres(Set<Llibre> llibres) {
		this.llibres = llibres;
	}


	@Override
	public String toString() {
		return "Autor [autorId=" + autorId + ", nom=" + nom + ", llibres=" + llibres + "]";
	}

	 // Ha de tenir getter i setter perquè s'encarrega de la taula relacional N:N

	


	






	///public List<Object[]> queryEmployees () {
	///	long id = this.getContactId();
		///return Manager.queryTable("SELECT DISTINCT e.* FROM Employee_Contact ec, Employee e WHERE e.id = ec.employees_id AND ec.contacts_id = " + id);
	///}

	
}