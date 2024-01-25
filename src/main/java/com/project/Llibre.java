package com.project;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;


    
   @Entity
@Table(name = "Llibre",
    uniqueConstraints = {@UniqueConstraint(columnNames = "llibreid")})
public class Llibre {
    
    @Id
    @Column(name = "llibreid", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long llibreid;

    @Column(name = "nom")
    private String nom;

    @Column(name = "editorial")
    private String editorial;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @ManyToMany(mappedBy = "biblioteques", cascade = CascadeType.MERGE)
    private Set<Biblioteca> biblioteques;

    @ManyToMany(mappedBy = "llibres", cascade = CascadeType.MERGE)
    private Set<Persona> persones;

      public Llibre() {}


      public Llibre( String nom, String editoral) {
        
         this.nom = nom;
         this.editorial = editoral;
         
      }


      public long getLlibreId() {
         return llibreid;
      }


      public void setLlibreId(long llibreId) {
         this.llibreid = llibreid;
      }


      public String getNom() {
         return nom;
      }


      public void setNom(String nom) {
         this.nom = nom;
      }


      public String getEditoral() {
         return editorial;
      }


      public void setEditoral(String editoral) {
         this.editorial = editoral;
      }


      public Set<Biblioteca> getBiblioteques() {
         return biblioteques;
      }


      public void setBiblioteques(Set<Biblioteca> biblioteca) {
         this.biblioteques = biblioteca;
      }


      public Set<Persona> getPersones() {
         return persones;
      }


      public void setPersones(Set<Persona> persones) {
         this.persones = persones;
      }


      public Autor getAutor() {
         return autor;
      }


      public void setAutor(Autor autor) {
         this.autor = autor;
      }


      @Override
      public String toString() {
         return "Llibre [llibreid=" + this.getLlibreId() + ", nom=" + this.getNom() + ", editorial=" + this.getEditoral() + ", autor=" + this.getAutor()
               + ", biblioteques=" + this.getBiblioteques() + ", persones=" + this.getPersones() + "]";
      }


  

      
 }