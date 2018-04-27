package org.opendevup.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.opendevup.model.Matiere;
@Entity
public class Note implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idNote")
private long idNote;
private String module;
private double noteDS;
private double noteExamen;
private double noteTP;
private int rang;
private double moyenneGeneral;
private String situation;

@ManyToOne
@JoinColumn(name="idMatiere")
private Matiere matieres;

@ManyToOne(optional=false)
@JoinColumn(name="id", referencedColumnName="id",nullable=false, updatable=false, insertable=false)
private Enseignant enseignant;

@ManyToOne(optional=false)
@JoinColumn(name="id", referencedColumnName="id", nullable=false, updatable=false, insertable=false)
private Etudiant etudiant;

public Enseignant getEnseignant() {
	return enseignant;
}

public void setEnseignant(Enseignant enseignant) {
	this.enseignant = enseignant;
}

public Etudiant getEtudiant() {
	return etudiant;
}

public void setEtudiant(Etudiant etudiant) {
	this.etudiant = etudiant;
}



public Note() {
	super();
	// TODO Auto-generated constructor stub
}

public Note(long idNote, String module, double noteDS, double noteExamen, double noteTP, int rang,
		double moyenneGeneral, String admis, Matiere matieres) {
	super();
	this.idNote = idNote;
	this.module = module;
	this.noteDS = noteDS;
	this.noteExamen = noteExamen;
	this.noteTP = noteTP;
	this.rang = rang;
	this.moyenneGeneral = moyenneGeneral;
	this.situation = situation;
	this.matieres = matieres;
}

public long getIdNote() {
	return idNote;
}

public void setIdNote(long idNote) {
	this.idNote = idNote;
}

public String getModule() {
	return module;
}

public void setModule(String module) {
	this.module = module;
}

public double getNoteDS() {
	return noteDS;
}

public void setNoteDS(double noteDS) {
	this.noteDS = noteDS;
}

public double getNoteExamen() {
	return noteExamen;
}

public void setNoteExamen(double noteExamen) {
	this.noteExamen = noteExamen;
}

public double getNoteTP() {
	return noteTP;
}

public void setNoteTP(double noteTP) {
	this.noteTP = noteTP;
}

public int getRang() {
	return rang;
}

public void setRang(int rang) {
	this.rang = rang;
}

public double getMoyenneGeneral() {
	return moyenneGeneral;
}

public void setMoyenneGeneral(double moyenneGeneral) {
	this.moyenneGeneral = moyenneGeneral;
}

public String getAdmis() {
	return situation;
}

public void setAdmis(String admis) {
	this.situation = admis;
}

public Matiere getMatieres() {
	return matieres;
}

public void setMatieres(Matiere matieres) {
	this.matieres = matieres;
}





}
