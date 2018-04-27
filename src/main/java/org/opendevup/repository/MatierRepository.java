package org.opendevup.repository;

import java.util.List;

import org.opendevup.model.Matiere;
import org.opendevup.model.Unite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MatierRepository extends JpaRepository<Matiere, Long>{
	public List<Matiere> findBynomMatier(String n);
	public Page<Matiere> findBynomMatier(String n, Pageable pageable);
	@Query("select m from Matiere m where m.nomMatier like :x")
	public Page<Matiere> chercheMatier(@Param("x")String mc,Pageable pageable);
}
