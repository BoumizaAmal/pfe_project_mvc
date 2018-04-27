package org.opendevup.controller;

import java.util.List;

import javax.validation.Valid;

import org.opendevup.model.Departement;
import org.opendevup.model.Filiere;
import org.opendevup.model.Matiere;
import org.opendevup.model.Unite;
import org.opendevup.repository.FiliereRepository;
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
@RequestMapping(value="/filieres")
public class FiliereController {
	
	@Autowired
	private FiliereRepository filrepository;
	
	
	@RequestMapping(value = "/listfilier")
	public String Index(Model model,
			@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name="motCle",defaultValue="")String mc) {

		Page<Filiere> filier = filrepository.chercheFiliere("%"+mc+"%",new PageRequest(p, 5));
		
		int pagesCount = filier.getTotalPages();
		int[] pages = new int[pagesCount];
		for (int i = 0; i < pagesCount; i++) {
			pages[i] = i;
		}

		model.addAttribute("pages", pages);
		
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle",mc);
		model.addAttribute("filier", filier);
		return "filiere/Filiere";
	}


	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String formFiliere(Model model) {
		model.addAttribute("filiere", new Filiere());
		
		return "filiere/Addfilier";
	}

	@RequestMapping(value = "/saveFilier", method = RequestMethod.POST)
	public String save(@Valid Filiere f, BindingResult bindingResult)

	{
		if(bindingResult.hasErrors()){
			return "filiere/Addfilier";
		}

		filrepository.save(f);

		return "redirect:filieres";
	}


	@RequestMapping("/supprimer")
	public String suppFilier(long id)
	{
	filrepository.deleteById(id);
	return "redirect:filieres";
	}




	@RequestMapping("/edit")
	public String updateFiliere(Long id,Model model){
		Filiere filier= filrepository.getOne(id);
	    model.addAttribute("filier",filier);
	return "filiere/Editfilier";
	}


	@RequestMapping(value = "/Updatefilier", method = RequestMethod.POST)
	public String update(@Valid Filiere f, BindingResult bindingResult)

	{

		if (bindingResult.hasErrors()) {
			return "filiere/Editfiliere";
		}
		filrepository.save(f);
		return "redirect:filieres";
	}

}
