package org.opendevup.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.loader.plan.build.spi.ReturnGraphTreePrinter;
import org.opendevup.model.Filiere;
import org.opendevup.model.Groupe;
import org.opendevup.model.Unite;
import org.opendevup.repository.FiliereRepository;
import org.opendevup.repository.GroupeRepository;
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
@RequestMapping(value="/Groupe")
public class GroupeController {

	
	@Autowired
	private GroupeRepository grprepository;
	

@RequestMapping(value = "/Groupes")
public String Index(Model model,
		@RequestParam(name = "page", defaultValue = "0") int p,
		@RequestParam(name="motCle",defaultValue="")String mc) {

	Page<Groupe> grps = grprepository.chercheGrp("%"+mc+"%",new PageRequest(p, 5));
	
	int pagesCount = grps.getTotalPages();
	int[] pages = new int[pagesCount];
	for (int i = 0; i < pagesCount; i++) {
		pages[i] = i;
	}

	model.addAttribute("pages", pages);
	
	model.addAttribute("pageCourante", p);
	model.addAttribute("motCle",mc);
	model.addAttribute("grps", grps);
	return "groupe/groupes";
}


@RequestMapping(value = "/form", method = RequestMethod.GET)
public String formGroupe(Model model) {
	model.addAttribute("groupe", new Groupe());
	
	return "groupe/Addgroupe";
}

@RequestMapping(value = "/saveGroupe", method = RequestMethod.POST)
public String save(@Valid Groupe g, BindingResult bindingResult)

{
	if(bindingResult.hasErrors()){
		return "groupe/Addgroupe";
	}

	grprepository.save(g);

	return "redirect:Groupes";
}


@RequestMapping("/supprimer")
public String suppGroupe(long id)
{
grprepository.deleteById(id);
return "redirect:Groupes";
}




@RequestMapping("/edit")
public String updateGroupe(Long id,Model model){
	Groupe grp=grprepository.getOne(id);
    model.addAttribute("grp",grp);
return "groupe/Editgroupe";
}


@RequestMapping(value = "/UpdateGroupe", method = RequestMethod.POST)
public String update(@Valid Groupe g, BindingResult bindingResult)

{

	if (bindingResult.hasErrors()) {
		return "groupe/Editgroupe";
	}
	grprepository.save(g);
	return "redirect:Groupes";
}
}
