package org.opendevup.repository;

import java.util.List;

import org.opendevup.model.Groupe;
import org.opendevup.model.Unite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GroupeRepository extends JpaRepository<Groupe, Long>{

	
	public List<Groupe> findBynomGrp(String n);
	public Page<Groupe> findBynomGrp(String n, Pageable pageable);
	@Query("select g from Groupe g where g.nomGrp like :x")
	public Page<Groupe> chercheGrp(@Param("x")String mc,Pageable pageable);

}
