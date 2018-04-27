package org.opendevup.repository;

import java.util.List;

import org.opendevup.model.Departement;
import org.opendevup.model.Unite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IdepartementRepository extends JpaRepository<Departement, Long> {

	
	public List<Departement> findBynom(String n);
	public Page<Departement> findBynom(String n, Pageable pageable);
	@Query("select d from Departement d where d.nom like :x")
	public Page<Departement> chercheDept(@Param("x")String mc,Pageable pageable);

}
