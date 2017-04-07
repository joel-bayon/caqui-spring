package fr.rte_france.caqui.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.rte_france.caqui.entity.Regroupement;


public interface RegroupementJpa extends JpaRepository<Regroupement, Long>{ // operations CRUD sur entité Regroupement et quelques requête métier spécifiques
	
	@Query("select case when (count(*) = 0) then true else false end"
			+ " from Regroupement r join r.evenements e where r.id = ?1 and e.etat <> fr.rte_france.caqui.entity.Etat.CLOS")
	public boolean isClos(long idRegroupement);
	@Query("select case when (count(*) = 0) then true else false end"
			+ " from Regroupement r join r.evenements e where r.id = ?1 and e.etat <> fr.rte_france.caqui.entity.Etat.EN_ATTENTE")
	public boolean isEnAttente(long idRegroupement);
	
	@Query("select r from Regroupement r JOIN FETCH r.evenements e where r.id=?1")
	public Regroupement getRegroupementWithEvenements(long idRegroupement);


}
