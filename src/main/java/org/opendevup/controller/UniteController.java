package org.opendevup.controller;

import java.util.List;

import javax.validation.Valid;

import org.opendevup.model.Unite;
import org.opendevup.repository.IuniteRepository;
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
@RequestMapping(value="/unite")
public class UniteController {
@Autowired
private IuniteRepository iuniteRepository;


@RequestMapping(value = "/Unites")
public String Index(Model model,
		@RequestParam(name = "page", defaultValue = "0") int p,
		@RequestParam(name="motCle",defaultValue="")String mc) {

	Page<Unite> units = iuniteRepository.chercheUnite("%"+mc+"%",new PageRequest(p, 5));
	
	int pagesCount = units.getTotalPages();
	int[] pages = new int[pagesCount];
	for (int i = 0; i < pagesCount; i++) {
		pages[i] = i;
	}

	model.addAttribute("pages", pages);
	
	model.addAttribute("pageCourante", p);
	model.addAttribute("motCle",mc);
	model.addAttribute("units", units);
	return "unite/unites";
}


@RequestMapping(value = "/form", method = RequestMethod.GET)
public String formUnite(Model model) {
	model.addAttribute("unite", new Unite());
	
	return "unite/Addunite";
}

@RequestMapping(value = "/saveUnite", method = RequestMethod.POST)
public String save(@Valid Unite u, BindingResult bindingResult)

{
	if(bindingResult.hasErrors()){
		return "unite/Addunite";
	}

	iuniteRepository.save(u);

	return "redirect:Unites";
}


@RequestMapping("/supprimer")
public String suppUnite(long id)
{
iuniteRepository.deleteById(id);
return "redirect:Unites";
}




@RequestMapping("/edit")
public String updateUnite(Long id,Model model){
	Unite unite=iuniteRepository.getOne(id);
    model.addAttribute("unite",unite);
return "unite/Editunite";
}


@RequestMapping(value = "/UpdateUnite", method = RequestMethod.POST)
public String update(@Valid Unite u, BindingResult bindingResult)

{

	if (bindingResult.hasErrors()) {
		return "unite/Editunite";
	}
	iuniteRepository.save(u);
	return "redirect:Unites";
}

}
