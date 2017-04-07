package fr.rte_france.caqui.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.rte_france.caqui.entity.Etat;
import fr.rte_france.caqui.entity.Regroupement;

@Transactional(propagation=Propagation.REQUIRED)
public interface RegroupementDao { 
	//must be implemented ... by JpaRepository!
	public void delete(Long idRegroupement);
	public Regroupement findOne(Long idRegroupement);
	public Regroupement save(Regroupement regroupement);
	public boolean isEnAttente(Long idRegroupement);
	public boolean isClos(Long idRegroupement);
	public Regroupement getRegroupementWithEvenements(long idRegroupement);
	
	//must be implemented ... by application (not JpaRepository) !
	public boolean isEnCours(long idRegroupement);
	public Etat getEtat(long idRegroupement);
}
