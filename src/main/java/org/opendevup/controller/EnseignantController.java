package org.opendevup.controller;

import java.util.List;

import javax.validation.Valid;

import org.opendevup.model.Enseignant;
import org.opendevup.model.Etudiant;
import org.opendevup.model.Groupe;
import org.opendevup.model.PFE;
import org.opendevup.model.Personne;
import org.opendevup.model.Unite;
import org.opendevup.repository.GroupeRepository;
import org.opendevup.repository.PFERepository;
import org.opendevup.repository.EnseignantRepository;
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
@RequestMapping(value="/enseignant")
public class EnseignantController {
	
	
	@Autowired
	private EnseignantRepository ensRepository;
	@Autowired
	private PFERepository pferepository;
	
//***********************LISTE PAR PAGE************************


	
	@RequestMapping(value = "/Index")
	public String Index(Model model,
			@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name="motCle",defaultValue="")String mc) {

		Page<Enseignant> ens = ensRepository.chercheEnseignant("%"+mc+"%",new PageRequest(p, 5));
		
		int pagesCount = ens.getTotalPages();
		int[] pages = new int[pagesCount];
		for (int i = 0; i < pagesCount; i++) {
			pages[i] = i;
		}

		model.addAttribute("pages", pages);
		
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle",mc);
		model.addAttribute("pageEns", ens);
		return "enseignant/enseignant";
	}



	/*
	 @RequestMapping(value="/Accueil")
	    public String accueil(Model model) {

	       	        return "Accueil";
	    }
	 
	*/
	 //***********************SAVE************************
	 @RequestMapping(value="/form",method=RequestMethod.GET)
	    public String formEnseignant(Model model) {
		 model.addAttribute("enseignant",new Enseignant());
		 
			List<PFE> listpfe = pferepository.findAll();
			model.addAttribute("pfeList", listpfe);
	       	        return "enseignant/Addenseignant";
	    }
	 
	 @RequestMapping(value = "/saveEns", method = RequestMethod.POST)
	 public String save(@Valid Enseignant en, BindingResult bindingResult)

	 {
	 	if(bindingResult.hasErrors()){
	 		return "enseignant/Addenseignant";
	 	}

	 	ensRepository.save(en);

	 	return "redirect:Index";
	 }
	 
	
	 
	
	 
	 //***********************DELETE************************
	
	 @RequestMapping(value="/supprimer")
	    public String supprimer(Long id) {
		 ensRepository.deleteById(id);  
		    return "redirect:Index";
	    }
	
	 //***********************UPDATE************************
	 @RequestMapping(value="/edit")
	    public String edit(Long id ,Model model) {
		 
		 Enseignant en= ensRepository.getOne(id);
		 model.addAttribute("ens",en);
		
			 List<PFE> listpfe = pferepository.findAll();
				model.addAttribute("pfeList", listpfe);
		 return "enseignant/Editenseignant";
		 
	 }
	



	 @RequestMapping(value = "/UpdateEns", method = RequestMethod.POST)
	 public String update(@Valid Enseignant en, BindingResult bindingResult)

	 {

	 	if (bindingResult.hasErrors()) {
	 		return "enseignant/Editenseignant";
	 	}
	 	ensRepository.save(en);
	 	return "redirect:Index";
	 }	
	 


}
