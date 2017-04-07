package fr.rte_france.caqui.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.rte_france.caqui.dao.RegroupementDao;
import fr.rte_france.caqui.dao.RegroupementJpa;
import fr.rte_france.caqui.entity.Etat;
import fr.rte_france.caqui.entity.Regroupement;

@Repository
public class RegroupementDaoImpl implements RegroupementDao {
	
	@Autowired
	RegroupementJpa daoJpa;

	@Override
	public void delete(Long idRegroupement) {
		daoJpa.delete(idRegroupement);
		
	}

	@Override
	public Regroupement findOne(Long idRegroupement) {
		// TODO Auto-generated method stub
		return daoJpa.findOne(idRegroupement);
	}

	@Override
	public Regroupement save(Regroupement regroupement) {
		// TODO Auto-generated method stub
		return daoJpa.save(regroupement);
	}

	@Override
	public boolean isEnAttente(Long idRegroupement) {
		// TODO Auto-generated method stub
		return daoJpa.isEnAttente(idRegroupement);
	}

	@Override
	public boolean isClos(Long idRegroupement) {
		// TODO Auto-generated method stub
		return daoJpa.isClos(idRegroupement);
	}

	@Override
	public Etat getEtat(long idRegroupement) {
		if(daoJpa.isClos(idRegroupement)) return Etat.CLOS;
		else if(isEnAttente(idRegroupement)) return Etat.EN_ATTENTE;
		return Etat.EN_COURS;
	}

	@Override
	public boolean isEnCours(long idRegroupement) {
		// TODO Auto-generated method stub
		return  (! daoJpa.isClos(idRegroupement)) && (!daoJpa.isEnAttente(idRegroupement));
	}
	

}
