package cliniquemvc_example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cliniquemvc_example.form.maladeForm;
import cliniquemvc_example.model.Medecin;
import cliniquemvc_example.service.MedecinService;

@Controller
@RequestMapping(value = "/medecin")

public class MedecinController {

	@Autowired
	private MedecinService medecinService;


	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("medecin/list");
		List<Medecin> listMedecin = medecinService.listAllMedecin();
		model.addObject("listMedecin", listMedecin);
		model.addObject("medecinActive", "active");
		model.addObject("medecinListActive", "active");
		return model;
	}

	@RequestMapping(value = "/list/search", method = RequestMethod.POST)
	public ModelAndView searchmedecin(@RequestParam("search") String des) {
		List<Medecin> listMedecin1 = medecinService.searchmedecin(des);
		ModelAndView model = new ModelAndView("medecin/list");
		model.addObject("listMedecin", listMedecin1);
		model.addObject("medecinActive", "active");
		model.addObject("medecinListActive", "active");
		return model;

	}




	@RequestMapping(value = { "/list2" }, method = RequestMethod.GET)
	public ModelAndView list2() {
		ModelAndView model = new ModelAndView("malade/list2");
		List<maladeForm> listMalade = medecinService.listAllMalade();
		model.addObject("listMalade", listMalade);
		model.addObject("medecinActive", "active");
		model.addObject("medecinListActive", "active");
		return model;
	}

	@RequestMapping(value = "/list3/search", method = RequestMethod.POST)
	public ModelAndView searchmalade(@RequestParam("search") String des) {
		List<maladeForm> listMalade1 = medecinService.searchmalade(des);
		ModelAndView model = new ModelAndView("malade/list3");
		model.addObject("listMalade", listMalade1);
		model.addObject("medecinActive", "active");
		model.addObject("medecinListActive", "active");
		return model;

	}


}

