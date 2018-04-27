package org.opendevup.controller;

import java.util.List;

import javax.validation.Valid;

import org.opendevup.model.Departement;
import org.opendevup.model.Unite;
import org.opendevup.repository.IdepartementRepository;
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
@RequestMapping(value="/departement")
public class DepartementController {
@Autowired
	private IdepartementRepository departementRepository;

@RequestMapping(value = "/Depts")
public String Index(Model model,
		@RequestParam(name = "page", defaultValue = "0") int p,
		@RequestParam(name="motCle",defaultValue="")String mc) {

	Page<Departement> depar = departementRepository.chercheDept("%"+mc+"%",new PageRequest(p, 5));
	
	int pagesCount = depar.getTotalPages();
	int[] pages = new int[pagesCount];
	for (int i = 0; i < pagesCount; i++) {
		pages[i] = i;
	}

	model.addAttribute("pages", pages);
	
	model.addAttribute("pageCourante", p);
	model.addAttribute("motCle",mc);
	model.addAttribute("depar", depar);
	return "Departments";
}


@RequestMapping(value = "/form", method = RequestMethod.GET)
public String formDepartment(Model model) {
	model.addAttribute("deprt", new Departement());
	
	return "Adddept";
}

@RequestMapping(value = "/saveDept", method = RequestMethod.POST)
public String save(@Valid Departement d, BindingResult bindingResult)

{
	if(bindingResult.hasErrors()){
		return "Adddept";
	}

	departementRepository.save(d);

	return "redirect:Depts";
}


@RequestMapping("/supprimer")
public String suppDept(long id)
{
departementRepository.deleteById(id);
return "redirect:Depts";
}




@RequestMapping("/edit")
public String updateDept(Long id,Model model){
	Departement depart= departementRepository.getOne(id);
    model.addAttribute("depart",depart);
return "Editdept";
}


@RequestMapping(value = "/UpdateDept", method = RequestMethod.POST)
public String update(@Valid Departement d, BindingResult bindingResult)

{

	if (bindingResult.hasErrors()) {
		return "Editdept";
	}
	departementRepository.save(d);
	return "redirect:Depts";
}

}
