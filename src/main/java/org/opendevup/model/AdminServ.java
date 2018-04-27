package org.opendevup.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("adminserv")
public class AdminServ extends Personne implements Serializable{
	
	
	

}
