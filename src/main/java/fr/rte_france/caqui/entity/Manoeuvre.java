package fr.rte_france.caqui.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the PRODUCTION database table.
 * 
 */
@Entity
@NamedQuery(name="Manoeuvre.findAll", query="SELECT m FROM Manoeuvre m")
public class Manoeuvre extends Evenement implements Serializable {
	private static final long serialVersionUID = 1L;

	private String appareil;

	public Manoeuvre() {}

	public Manoeuvre(String libelle, Date debut,  Etat etat, Ouvrage ouvrage, String appareil) {
		super(libelle, debut, etat, ouvrage);
		this.appareil = appareil;
	}

	public String getAppareil() {
		return appareil;
	}

	public void setAppareil(String appareil) {
		this.appareil = appareil;
	}

}