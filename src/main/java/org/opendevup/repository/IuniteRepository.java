package org.opendevup.repository;

import java.util.List;

import org.opendevup.model.Unite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface IuniteRepository extends JpaRepository<Unite,Long > {
public List<Unite> findBycoefficient (double c);

public List<Unite> findBynomUnite(String n);
public Page<Unite> findBynomUnite(String n, Pageable pageable);
@Query("select u from Unite u where u.nomUnite like :x")
public Page<Unite> chercheUnite(@Param("x")String mc,Pageable pageable);



//@Query("UPDATE Unite u SET u.nomUnite = :nom WHERE u.idUnite = :Id")
//Unite updateUnite(@Param("Id") Long Id, @Param("nom") String nom);
}


