package org.opendevup.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.opendevup.model.Departement;
import org.opendevup.model.Groupe;
import org.opendevup.model.Matiere;




@Entity
public class Filiere implements Serializable {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idFiliere")
	private long idFilere;
	private String nomFiliere;
	@OneToMany(mappedBy="filiere")
	private Collection<Groupe> groupes;
	@ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn (name="idDept")
	  private Departement dept;
	@OneToMany(mappedBy="filiere")
	private Collection<Matiere> matieres;
	
	
	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Filiere(long idFilere, String nomFiliere, Departement dept, Collection<Matiere> matieres) {
		super();
		this.idFilere = idFilere;
		this.nomFiliere = nomFiliere;
		this.dept = dept;
		this.matieres = matieres;
	}
	public long getIdFilere() {
		return idFilere;
	}
	public void setIdFilere(long idFilere) {
		this.idFilere = idFilere;
	}
	public String getNomFiliere() {
		return nomFiliere;
	}
	public void setNomFiliere(String nomFiliere) {
		this.nomFiliere = nomFiliere;
	}
	public Departement getDept() {
		return dept;
	}
	public void setDept(Departement dept) {
		this.dept = dept;
	}
	public Collection<Matiere> getMatieres() {
		return matieres;
	}
	public void setMatieres(Collection<Matiere> matieres) {
		this.matieres = matieres;
	}
	
	

}
