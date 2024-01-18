package com.project;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Llibre", 
   uniqueConstraints = {@UniqueConstraint(columnNames = "llibreId")})
public class Llibre implements Serializable {
    
   @Id
	@Column(name = "llibreId", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY) // L'id es genera automàticament
	private long llibreId;
   
      @Column(name = "nom")
      private String nom; 
      
      @Column(name = "editoral")
      private String editoral;   
      


      @ManyToMany(mappedBy = "llibres")   
      private Set<Biblioteca> biblioteques;


      @ManyToMany(mappedBy = "llibres2")
      private Set<Persona> persones;

      @ManyToOne
      @JoinColumn(name="autorId", insertable=false,
                  updatable=false)
      private Autor autor;

      public Llibre() {}


      public Llibre( String nom, String editoral) {
        
         this.nom = nom;
         this.editoral = editoral;
         
      }


      public long getLlibreId() {
         return llibreId;
      }


      public void setLlibreId(long llibreId) {
         this.llibreId = llibreId;
      }


      public String getNom() {
         return nom;
      }


      public void setNom(String nom) {
         this.nom = nom;
      }


      public String getEditoral() {
         return editoral;
      }


      public void setEditoral(String editoral) {
         this.editoral = editoral;
      }


     


      public Set<Biblioteca> getBiblioteques() {
         return biblioteques;
      }


      public void setBiblioteques(Set<Biblioteca> biblioteques) {
         this.biblioteques = biblioteques;
      }


      public Set<Persona> getPersones() {
         return persones;
      }


      public void setPersones(Set<Persona> persones) {
         this.persones = persones;
      }

      @Override
      public String toString() {
         return "Llibre [llibreId=" + llibreId + ", nom=" + nom + ", editoral=" + editoral + ", id_autor=" + autor
               + ", biblioteques=" + biblioteques + ", persones=" + persones + "]";
      }





      public Autor getAutor() {
         return autor;
      }





      public void setAutor(Autor autor) {
         this.autor = autor;
      }


     


      
    

     



      
 }