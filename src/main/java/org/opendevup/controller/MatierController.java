package org.opendevup.controller;

import java.util.List;

import javax.validation.Valid;

import org.opendevup.model.Matiere;
import org.opendevup.model.Unite;
import org.opendevup.repository.MatierRepository;
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
@RequestMapping(value="/matier")
public class MatierController {
	
	@Autowired
	MatierRepository matierrepository;
	

@RequestMapping(value = "/Matiers")
public String Index(Model model,
		@RequestParam(name = "page", defaultValue = "0") int p,
		@RequestParam(name="motCle",defaultValue="")String mc) {

	Page<Matiere> matier = matierrepository.chercheMatier("%"+mc+"%",new PageRequest(p, 5));
	
	int pagesCount = matier.getTotalPages();
	int[] pages = new int[pagesCount];
	for (int i = 0; i < pagesCount; i++) {
		pages[i] = i;
	}

	model.addAttribute("pages", pages);
	
	model.addAttribute("pageCourante", p);
	model.addAttribute("motCle",mc);
	model.addAttribute("matier", matier);
	return "matier/matiers";
}


@RequestMapping(value = "/form", method = RequestMethod.GET)
public String formMatier(Model model) {
	model.addAttribute("matier", new Matiere());
	
	return "matier/Addmatier";
}

@RequestMapping(value = "/saveMatier", method = RequestMethod.POST)
public String save(@Valid Matiere m, BindingResult bindingResult)

{
	if(bindingResult.hasErrors()){
		return "Addmatier";
	}

	matierrepository.save(m);

	return "redirect:Matiers";
}


@RequestMapping("/supprimer")
public String suppMatier(long id)
{
matierrepository.deleteById(id);
return "redirect:Matiers";
}




@RequestMapping("/edit")
public String updateMatier(Long id,Model model){
	Matiere matier=matierrepository.getOne(id);
    model.addAttribute("matier",matier);
return "matier/Editmatier";
}


@RequestMapping(value = "/Updatematier", method = RequestMethod.POST)
public String update(@Valid Matiere m, BindingResult bindingResult)

{

	if (bindingResult.hasErrors()) {
		return "matier/Editunite";
	}
	matierrepository.save(m);
	return "redirect:Matiers";
}

}
