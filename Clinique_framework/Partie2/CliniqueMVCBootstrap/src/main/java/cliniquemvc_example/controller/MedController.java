package cliniquemvc_example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import cliniquemvc_example.form.UserForm;
import cliniquemvc_example.form.medecinForm;
import cliniquemvc_example.model.Contact;
import cliniquemvc_example.model.Malade;
import cliniquemvc_example.service.MedService;
import cliniquemvc_example.service.UserService;

@Controller
@RequestMapping("/malades")
public class MedController {

	@Autowired
	private MedService medService;

	@Autowired
	UserService userService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("home/home");
		model.addObject("homeActive", "active");
		return model;
	}

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("malade/list");
		List<Malade> listMalade = medService.listAllMalade();
		model.addObject("listMalade", listMalade);
		model.addObject("maladeActive", "active");
		model.addObject("maladeListActive", "active");
		return model;
	}

	@RequestMapping(value = "/list/search", method = RequestMethod.POST)
	public ModelAndView searchcustomer(@RequestParam("search") String des) {
		List<Malade> listMalade1 = medService.searchmalade(des);
		ModelAndView model = new ModelAndView("malade/list");
		model.addObject("listMalade", listMalade1);
		model.addObject("maladeActive", "active");
		model.addObject("maladeListActive", "active");
		return model;

	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("malade/form");
		Malade malade = new Malade();
		model.addObject("maladeForm", malade);
		model.addObject("maladeActive", "active");
		model.addObject("maladeAddActive", "active");
		return model;
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {
		medService.deleteMalade(id);
		return new ModelAndView("redirect:/malades/list");
	}

	@RequestMapping(value = { "/update/{id}" }, method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("malade/form");
		Malade malade = medService.findMaladById(id);
		model.addObject("maladeForm", malade);
		model.addObject("maladeActive", "active");
		return model;
	}

	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("maladeForm") @Validated Malade malade, BindingResult result) {
		ModelAndView model = new ModelAndView("malade/form");
		if (result.hasErrors()) {
			return model;
		}
		if (malade.getId() != null) {
			medService.updateMalade(malade);
		} else {
			medService.addMalade(malade);
		}
		return new ModelAndView("redirect:/malades/list");
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView("user/signup");
		model.addObject("userForm", new UserForm());

		return model;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("userForm") @Validated UserForm userForm, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "/user/signup";
		} else {
			userService.add(userForm.getUsername(), userForm.getPassword());
			redirectAttributes.addFlashAttribute("msg", "Your account has been created successfully!");

			return "redirect:/login";
		}
	}

	@RequestMapping(value = { "/list2" }, method = RequestMethod.GET)
	public ModelAndView list2() {
		ModelAndView model = new ModelAndView("malade/list2");
		List<medecinForm> listMedecin = medService.listAllMedecin();
		model.addObject("listMedecin", listMedecin);
		model.addObject("medecinActive", "active");
		model.addObject("medecinListActive", "active");
		return model;
	}

	@RequestMapping(value = "/list3/search", method = RequestMethod.POST)
	public ModelAndView searchmalade(@RequestParam("search") String des) {
		List<medecinForm> listMedecin1 = medService.searchmedecin(des);
		ModelAndView model = new ModelAndView("malade/list3");
		model.addObject("listMedecin", listMedecin1);
		model.addObject("medecinActive", "active");
		model.addObject("medecinListActive", "active");
		return model;

	}

	@RequestMapping(value = { "/list4" }, method = RequestMethod.GET)
	public ModelAndView list4() {
		ModelAndView model = new ModelAndView("malade/list4");
		List<Contact> listContact = medService.listAllContact();
		model.addObject("listContact", listContact);
		model.addObject("medecinActive", "active");
		model.addObject("medecinListActive", "active");
		return model;
	}

	@RequestMapping(value = "/list4/search", method = RequestMethod.POST)
	public ModelAndView searchmedecin(@RequestParam("search") String des) {
		List<Contact> listContact1 = medService.searchcontact(des);
		ModelAndView model = new ModelAndView("malade/list4");
		model.addObject("listContact", listContact1);
		model.addObject("medecinActive", "active");
		model.addObject("medecinListActive", "active");
		return model;

	}
}
