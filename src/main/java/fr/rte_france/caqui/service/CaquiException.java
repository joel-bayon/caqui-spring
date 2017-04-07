package fr.rte_france.caqui.service;

import fr.rte_france.caqui.entity.Evenement;
import fr.rte_france.caqui.entity.Regroupement;

@SuppressWarnings("serial")
public class CaquiException extends Exception {
	final public Regroupement regroupement;
	final public Evenement evenement;
	
	public CaquiException(String message, Regroupement regroupement, Evenement evenement) {
		super(message);
		this.regroupement = regroupement;
		this.evenement = evenement;
	}
	
}
