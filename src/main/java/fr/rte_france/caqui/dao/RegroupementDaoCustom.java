package fr.rte_france.caqui.dao;

import fr.rte_france.caqui.entity.Etat;

public interface RegroupementDaoCustom {
	//must be implemented ... by application (not JpaRepository) !
	public boolean isEnCours(long idRegroupement);
	public Etat getEtat(long idRegroupement);
}
