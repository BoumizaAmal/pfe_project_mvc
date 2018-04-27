package org.opendevup.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.opendevup.model.Matiere;


@Entity
public class Unite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idUnite")
	private long idUnite;
	@NotEmpty
	@Size(min=4,max=30)
	private String nomUnite;
	
	private int nbrMatier;
	@NotEmpty
	private String type;

	private double coefficient;
	
	@OneToMany(mappedBy="unite")
	private Collection<Matiere> matieres;

	public Unite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getIdUnite() {
		return idUnite;
	}

	public void setIdUnite(long idUnite) {
		this.idUnite = idUnite;
	}

	public String getNomUnite() {
		return nomUnite;
	}

	public void setNomUnite(String nomUnite) {
		this.nomUnite = nomUnite;
	}

	public int getNbrMatier() {
		return nbrMatier;
	}

	public void setNbrMatier(int nbrMatier) {
		this.nbrMatier = nbrMatier;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	public Collection<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(Collection<Matiere> matieres) {
		this.matieres = matieres;
	}

	public Unite(long idUnite, String nomUnite, int nbrMatier, String type, double coefficient) {
		super();
		this.idUnite = idUnite;
		this.nomUnite = nomUnite;
		this.nbrMatier = nbrMatier;
		this.type = type;
		this.coefficient = coefficient;
	}
	
	
	
	
}
