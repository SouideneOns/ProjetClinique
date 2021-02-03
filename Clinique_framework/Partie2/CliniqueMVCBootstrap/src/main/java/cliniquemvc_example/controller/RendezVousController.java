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

import cliniquemvc_example.model.RendezVous;
import cliniquemvc_example.service.RendezVousService;
import cliniquemvc_example.service.UserService;
@Controller
@RequestMapping(value = "/rendezvous")
public class RendezVousController {
	@Autowired
public RendezVousService rendezvousService; 
	@Autowired
public UserService userService;
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("home/home");
		model.addObject("homeActive", "active");
		return model;
	}
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("malade/list1");
		List<RendezVous> listRendezVous = rendezvousService.listAllRendezVous();
		model.addObject("listRendezVous", listRendezVous);
		model.addObject("rendezvousActive", "active");
		model.addObject("rendezvousListActive", "active");
		return model;
	}
	@RequestMapping(value = "/list/search", method = RequestMethod.POST)
	public ModelAndView searchcustomer(@RequestParam("search") String des) {
		List<RendezVous> listRendezVous1 = rendezvousService.searchRendezVous(des);
		ModelAndView model = new ModelAndView("malade/list1");
		model.addObject("listRendezVous", listRendezVous1);
		model.addObject("rendezvousActive", "active");
		model.addObject("rendezvousListActive", "active");
		return model;

	}
	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("malade/form1");
		RendezVous rendezVous = new RendezVous();
		model.addObject("rendezvousForm", rendezVous);
		model.addObject("rendezvousActive", "active");
		model.addObject("rendezvousAddActive", "active");
		return model;
	}
	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {
		rendezvousService.deleteRendezVous(id);
		return new ModelAndView("redirect:/rendezvous/list");
	}
	@RequestMapping(value = { "/update/{id}" }, method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("malade/form1");
		RendezVous rendezvous = rendezvousService.findRendezVousById(id);
		model.addObject("rendezvousForm", rendezvous);
		model.addObject("rendezvousActive", "active");
		return model;
	}
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("rendezvousForm") @Validated RendezVous rendezvous, BindingResult result) {
		ModelAndView model = new ModelAndView("malade/form1");
		if (result.hasErrors()) {
			return model;
		}
		if (rendezvous.getId() != null) {
			rendezvousService.updateRendezVous(rendezvous);
		} else {
			rendezvousService.addRendezVous(rendezvous);
		}
		return new ModelAndView("redirect:/rendezvous/list");
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
}

