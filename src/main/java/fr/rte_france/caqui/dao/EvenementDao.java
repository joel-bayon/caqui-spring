package fr.rte_france.caqui.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.rte_france.caqui.entity.Evenement;

public interface EvenementDao extends JpaRepository<Evenement, Long>{}
