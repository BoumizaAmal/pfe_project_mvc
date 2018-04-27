package org.opendevup.controller;

import java.util.List;

import javax.validation.Valid;

import org.opendevup.model.Filiere;
import org.opendevup.model.PFE;
import org.opendevup.model.Unite;
import org.opendevup.repository.PFERepository;
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
@RequestMapping(value="/PFE")
public class PFEController {
	@Autowired
	private PFERepository pferepository;
	
	

	@RequestMapping(value = "/listpfe")
	public String Index(Model model,
			@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name="motCle",defaultValue="")String mc) {

		Page<PFE> pfe = pferepository.cherchePFE("%"+mc+"%",new PageRequest(p, 5));
		
		int pagesCount = pfe.getTotalPages();
		int[] pages = new int[pagesCount];
		for (int i = 0; i < pagesCount; i++) {
			pages[i] = i;
		}

		model.addAttribute("pages", pages);
		
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle",mc);
		model.addAttribute("pfe", pfe);
		return "pfe/pfe";
	}


@RequestMapping(value = "/form", method = RequestMethod.GET)
public String formPFE(Model model) {
	model.addAttribute("project", new PFE());
	
	return "pfe/Addpfe";
}

@RequestMapping(value = "/savePfe", method = RequestMethod.POST)
public String save(@Valid PFE p, BindingResult bindingResult)throws Exception

{
	if(bindingResult.hasErrors()){
		return "pfe/Addpfe";
	}

	pferepository.save(p);

	return "redirect:listpfe";
}


@RequestMapping("/supprimer")
public String supppfe(long id)
{
pferepository.deleteById(id);
return "redirect:listpfe";
}




@RequestMapping("/edit")
public String updatePFE(Long id,Model model){
	PFE project=pferepository.getOne(id);
    model.addAttribute("project",project);
return "pfe/Editpfe";
}


@RequestMapping(value = "/UpdatePFE", method = RequestMethod.POST)
public String update(@Valid PFE pfe, BindingResult bindingResult)

{

	if (bindingResult.hasErrors()) {
		return "pfe/Editpfe";
	}
	pferepository.save(pfe);
	return "redirect:listpfe";
}
	

}
