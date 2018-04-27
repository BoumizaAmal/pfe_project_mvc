package org.opendevup.controller;

import java.util.List;

import javax.validation.Valid;

import org.opendevup.model.Etudiant;
import org.opendevup.model.Groupe;
import org.opendevup.model.PFE;
import org.opendevup.model.Personne;
import org.opendevup.model.Unite;
import org.opendevup.repository.GroupeRepository;
import org.opendevup.repository.PFERepository;
import org.opendevup.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value="/etudiant")
public class EtudiantController {
	
	@Autowired
	private GroupeRepository grprepository;
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private PFERepository pferepository;
	
//***********************LISTE PAR PAGE************************


	
	@RequestMapping(value = "/Index")
	public String Index(Model model,
			@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name="motCle",defaultValue="")String mc) {

		Page<Etudiant> etud = etudiantRepository.chercheEtudiant("%"+mc+"%",new PageRequest(p, 5));
		
		int pagesCount = etud.getTotalPages();
		int[] pages = new int[pagesCount];
		for (int i = 0; i < pagesCount; i++) {
			pages[i] = i;
		}

		model.addAttribute("pages", pages);
		
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle",mc);
		model.addAttribute("pageEtudiant", etud);
		return "etudiant/etudiants";
	}



	/*
	 @RequestMapping(value="/Accueil")
	    public String accueil(Model model) {

	       	        return "Accueil";
	    }
	 
	*/
	 //***********************SAVE************************
	 @RequestMapping(value="/form",method=RequestMethod.GET)
	    public String formEtudiant(Model model) {
		 model.addAttribute("etudiant",new Etudiant());
		 List<Groupe> listGrp = grprepository.findAll();
			model.addAttribute("groupeList", listGrp);
			List<PFE> listpfe = pferepository.findAll();
			model.addAttribute("pfeList", listpfe);
	       	        return "etudiant/Addetudiant";
	    }
	 
	 @RequestMapping(value = "/saveEtudiant", method = RequestMethod.POST)
	 public String save(@Valid Etudiant et, BindingResult bindingResult)

	 {
	 	if(bindingResult.hasErrors()){
	 		return "etudiant/Addetudiant";
	 	}

	 	etudiantRepository.save(et);

	 	return "redirect:Index";
	 }
	 
	
	 
	
	 
	 //***********************DELETE************************
	
	 @RequestMapping(value="/supprimer")
	    public String supprimer(Long id) {
		 etudiantRepository.deleteById(id);  
		    return "redirect:Index";
	    }
	
	 //***********************UPDATE************************
	 @RequestMapping(value="/edit")
	    public String edit(Long id ,Model model) {
		 
		 Etudiant et= etudiantRepository.getOne(id);
		 model.addAttribute("etud",et);
		 List<Groupe> listGroupe = grprepository.findAll();
			model.addAttribute("grpList", listGroupe);
			 List<PFE> listpfe = pferepository.findAll();
				model.addAttribute("pfeList", listpfe);
		 return "etudiant/Editetudiant";
		 
	 }
	

	 
	 
	 
	 @RequestMapping(value="/findbyGroupe")
	 public String findEtudiantbyClasse(Model model,@RequestParam(name="idGrp")Long idGrp,@RequestParam(name = "page", defaultValue = "0") int p) {

		     Page<Etudiant> etds = etudiantRepository.findEtudiantbyGroupe(idGrp,new PageRequest(p, 5));
			int pagesCount=etds.getTotalPages();
			int[] pages= new int[pagesCount];
			for (int i = 0; i < pagesCount; i++) {
				pages[i]=i;
			}
						
			model.addAttribute("pages", pages);
			model.addAttribute("pageCourante", p);			
			model.addAttribute("pageEtudiant", etds);
			return "etudiant/etudiants";
			}







	 @RequestMapping(value = "/UpdateEtudiant", method = RequestMethod.POST)
	 public String update(@Valid Etudiant et, BindingResult bindingResult)

	 {

	 	if (bindingResult.hasErrors()) {
	 		return "etudiant/Editetudiant";
	 	}
	 	etudiantRepository.save(et);
	 	return "redirect:Index";
	 }	
	 


}
