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

import org.opendevup.model.Absence;
import org.opendevup.model.Filiere;
import org.opendevup.model.Note;
import org.opendevup.model.Unite;

@Entity
public class Matiere implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idMatiere")
	private long idMatiere;
	private String nomMatier;
	private double coefficient;
	private String Semestre;
	private String type;
	
	@ManyToOne
	@JoinColumn(name="idFiliere")
	private Filiere filiere;
	
	@ManyToOne
	@JoinColumn(name="idUnite")
	private Unite unite;
	
	@OneToMany(mappedBy="matiere")
	private Collection<Absence> absences;
	@OneToMany(mappedBy="matieres")
	private Collection<Note> notes;
	
	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Matiere(long idMatiere, String nomMatier, double coefficient, String semestre, String type) {
		super();
		this.idMatiere = idMatiere;
		this.nomMatier = nomMatier;
		this.coefficient = coefficient;
		Semestre = semestre;
		this.type = type;
	}
	public long getIdMatiere() {
		return idMatiere;
	}
	public void setIdMatiere(long idMatiere) {
		this.idMatiere = idMatiere;
	}
	public String getNomMatier() {
		return nomMatier;
	}
	public void setNomMatier(String nomMatier) {
		this.nomMatier = nomMatier;
	}
	public double getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}
	public String getSemestre() {
		return Semestre;
	}
	public void setSemestre(String semestre) {
		Semestre = semestre;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Filiere getFiliere() {
		return filiere;
	}
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	public Unite getUnite() {
		return unite;
	}
	public void setUnite(Unite unite) {
		this.unite = unite;
	}
	public Collection<Absence> getAbsences() {
		return absences;
	}
	public void setAbsences(Collection<Absence> absences) {
		this.absences = absences;
	}
	public Collection<Note> getNotes() {
		return notes;
	}
	public void setNotes(Collection<Note> notes) {
		this.notes = notes;
	}
	
	
	

}
