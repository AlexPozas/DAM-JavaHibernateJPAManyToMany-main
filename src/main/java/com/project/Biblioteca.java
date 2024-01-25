package com.project;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "Bblioteca", uniqueConstraints = {@UniqueConstraint(columnNames = "bibliotecaId")})
public class Biblioteca {
    
    @Id
    @Column(name = "bibliotecaId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bibliotecaId;

    @Column(name = "nom")

    private String nom;

    @Column(name = "ciutat")
    private String ciutat; 

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Llibres_Biblioteca",
        joinColumns = {@JoinColumn(referencedColumnName = "bibliotecaId")}, 
        inverseJoinColumns = {@JoinColumn(referencedColumnName = "llibreid")})
    private Set<Llibre> biblioteques;


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
		return biblioteques;
	}

	public void setLlibres(Set<Llibre> llibres) {
		this.biblioteques = llibres;
	}


	

	





	public List<Object[]> queryBiblioteca () {
		long id = this.getBibliotecaId();
		return Manager.queryTable("SELECT DISTINCT e.* FROM Llibres_Biblioteca ec, Llibre e WHERE e.id = ec.llibreid AND ec.bibliotecaId = " + id);
	}

	@Override
    public String toString () {
		String str = Manager.tableToString(queryBiblioteca()).replaceAll("\n", " | ");
      	return this.getBibliotecaId() + ": " + this.getNom() + ", " + this.getCiutat() + ", Llibres: [" + str + "]";
    }

	
}