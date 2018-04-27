package org.opendevup.repository;

import java.util.List;

import org.opendevup.model.Filiere;
import org.opendevup.model.Matiere;
import org.opendevup.model.Unite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FiliereRepository extends JpaRepository<Filiere, Long>{
	
	public List<Filiere> findBynomFiliere(String n);
	public Page<Filiere> findBynomFiliere(String n, Pageable pageable);
	@Query("select f from Filiere f where f.nomFiliere like :x")
	public Page<Filiere> chercheFiliere(@Param("x")String mc,Pageable pageable);
}
