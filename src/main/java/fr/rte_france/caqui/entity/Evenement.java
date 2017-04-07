package fr.rte_france.caqui.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the EVENEMENT database table.
 * 
 */
@Entity
@NamedQuery(name="Evenement.findAll", query="SELECT e FROM Evenement e")
public class Evenement extends EcritureCahier implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade=CascadeType.PERSIST)
	//@JoinColumn(name="ID_OUVRAGE")
	private Ouvrage ouvrage;
	protected Etat etat;

	public Evenement() {}
	
	public Evenement(String libelle, Date debut,  Etat etat, Ouvrage ouvrage) {
		super(libelle, debut);
		this.etat = etat;
		this.ouvrage = ouvrage;
	}

	public Ouvrage getOuvrage() {
		return this.ouvrage;
	}

	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "Evenement [" + super.toString() + " ouvrage=" + ouvrage + " etat=" + etat + "]";
	}
	
	
	
	
}