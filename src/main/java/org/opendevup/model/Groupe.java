package org.opendevup.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.opendevup.model.Etudiant;
import org.opendevup.model.Filiere;
@Entity
public class Groupe implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idGrp")
	private long idGrp;
	@Column(name="nomGrp")
	private String nomGrp;
	private int niveau;
	@ManyToOne
	@JoinColumn(name="idFiliere")
	private Filiere filiere;
	
	@OneToMany(mappedBy="groupe")
	private Collection<Etudiant> etudiants;

	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Groupe(long idGrp, String nomGrp, int niveau, Filiere filiere) {
		super();
		this.idGrp = idGrp;
		this.nomGrp = nomGrp;
		this.niveau = niveau;
		this.filiere = filiere;

	}

	public long getIdGrp() {
		return idGrp;
	}

	public void setIdGrp(long idGrp) {
		this.idGrp = idGrp;
	}

	public String getNomGrp() {
		return nomGrp;
	}

	public void setNomGrp(String nomGrp) {
		this.nomGrp = nomGrp;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	
	
	
	

}
