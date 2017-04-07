package fr.rte_france.caqui.service;

import java.util.Date;
import java.util.List;

import fr.rte_france.caqui.entity.Evenement;
import fr.rte_france.caqui.entity.Regroupement;


public interface GererRegroupement {

	public Regroupement creerRegroupement(String type, String libelle, Date debut, List<Evenement> evenements) throws CaquiException;
	public void ajouterEvenement(long idRegroupement, Evenement evenement) throws CaquiException;
	public void cloturerRegroupement(long idRegroupement); 
}
