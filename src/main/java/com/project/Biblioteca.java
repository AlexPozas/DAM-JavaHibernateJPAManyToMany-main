package com.project;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "Bibiloteca", 

	uniqueConstraints = {@UniqueConstraint(columnNames = "bibliotecaId")})
public class Biblioteca implements Serializable {

	@Id
	@Column(name = "bibliotecaId", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY) // L'id es genera automàticament
	private long bibliotecaId;

	@Column(name = "nom")
	private String nom;

	@Column(name = "ciutat")
	private String ciutat;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "Bibiloteca_Llibre", 
		joinColumns = {@JoinColumn(referencedColumnName = "bibliotecaId")}, 
		inverseJoinColumns = {@JoinColumn(referencedColumnName = "llibreId")})
	private Set<Llibre> llibres; // Ha de tenir getter i setter perquè s'encarrega de la taula relacional N:N

	public Biblioteca( String nom, String ciutat) {
		
		this.nom = nom;
		this.ciutat = ciutat;
		
	}

	public long getBibliotecaId() {
		return bibliotecaId;
	}

	public void setBibliotecaId(long bibliotecaId) {
		this.bibliotecaId = bibliotecaId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCiutat() {
		return ciutat;
	}

	public void setCiutat(String ciutat) {
		this.ciutat = ciutat;
	}

	public Set<Llibre> getLlibres() {
		return llibres;
	}

	public void setLlibres(Set<Llibre> llibres) {
		this.llibres = llibres;
	}

	@Override
	public String toString() {
		return "Biblioteca [bibliotecaId=" + bibliotecaId + ", nom=" + nom + ", ciutat=" + ciutat + ", llibres="
				+ llibres + "]";
	}

	


	






	///public List<Object[]> queryEmployees () {
	///	long id = this.getContactId();
		///return Manager.queryTable("SELECT DISTINCT e.* FROM Employee_Contact ec, Employee e WHERE e.id = ec.employees_id AND ec.contacts_id = " + id);
	///}

	
}