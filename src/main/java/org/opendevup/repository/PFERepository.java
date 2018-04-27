package org.opendevup.repository;

import java.util.List;

import org.opendevup.model.PFE;
import org.opendevup.model.Unite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PFERepository extends JpaRepository<PFE, Long>{

	
	public List<PFE> findBynomPrenom(String n);
	public Page<PFE> findBynomPrenom(String mc, Pageable pageable);
	@Query("select f from PFE f where f.nomPrenom like :x")
	public Page<PFE> cherchePFE(@Param("x")String mc,Pageable pageable);

}
