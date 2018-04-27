package org.opendevup.repository;

import java.util.List;

import org.opendevup.model.Enseignant;
import org.opendevup.model.Etudiant;
import org.opendevup.model.Personne;
import org.opendevup.model.Unite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long>{

	// **************************FindById********************************************

	public List<Enseignant> findBynom(String n);
	public Page<Enseignant> findBynom(String n, Pageable pageable);
	@Query("select en from Enseignant en where en.nom like :x")
	public Page<Enseignant> chercheEnseignant(@Param("x")String mc,Pageable pageable);
	

		// *********************RECHERCHE PAR NOM OR PAR
		// CIN*************************************
		/*@Query("SELECT e FROM Etudiant e where e.nom=:nom or e.cin=:cin")
		public Page<Etudiant> findBynomOrcin(@Param("nom") String nom,
				@Param("cin") String cin, Pageable pageable);

		

		// *********************** Pargroupeetparpage **************************
		@Query("SELECT e FROM Etudiant e where e.groupe.idGrp=:idGrp")
		public Page<Etudiant> findEtudiantbyGroupe(@Param("idGrp") Long idGrp,
				Pageable pageable);

		// ************************
		// ParOrdreAlphabétiqueEtparpage*************************

		@Query("SELECT e FROM Etudiant e Order By e.nom asc")
		public Page<Etudiant> findbyOrdreAlpha(Pageable pageable);*/

		// *******************LesEtudiantsD’un groupe***************************************

		
	
}
