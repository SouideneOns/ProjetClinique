package cliniquemvc_example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cliniquemvc_example.form.UserForm;
import cliniquemvc_example.form.maladeForm;
import cliniquemvc_example.form.rendezForm;

import cliniquemvc_example.model.UserInfo;
import cliniquemvc_example.service.UserService;
import cliniquemvc_example.validator.CustomerValidator;



@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	CustomerValidator customerValidator;

	@Autowired
	UserService userService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(customerValidator);
	}
	
	@RequestMapping(value = {"/portfolio" }, method = RequestMethod.GET)
	public ModelAndView portfolio() {
		ModelAndView model = new ModelAndView();
		model.setViewName("user/portfolio");
		return model;
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView form() {
		ModelAndView model = new ModelAndView("user/form");
		model.addObject("maladeForm", new maladeForm());

		return model;
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String submit(@ModelAttribute("maladeForm") @Validated maladeForm maladeForm, BindingResult result,
			RedirectAttributes redirectAttributes) {

			userService.addM(maladeForm.getCIN(),maladeForm.getFull_name(),maladeForm.getGender(),maladeForm.getDate_place(),maladeForm.getAge(),maladeForm.getPhone1(),maladeForm.getPhone2(),maladeForm.getAddress(),maladeForm.getGrs(),maladeForm.getMaladies(),maladeForm.getTraitements(),maladeForm.getQuestion());
			redirectAttributes.addFlashAttribute("msg", "Your account has been created successfully!");

			return "redirect:/login";
		}
	@RequestMapping(value = "/rendezvous", method = RequestMethod.GET)
	public ModelAndView rendezvous() {
		ModelAndView model = new ModelAndView("malade/rendezvous");
		model.addObject("rendezForm", new rendezForm());

		return model;
	}
	
	@RequestMapping(value = "/submit2", method = RequestMethod.POST)
	public String submit(@ModelAttribute("rendezForm") @Validated rendezForm rendezForm, BindingResult result,
			RedirectAttributes redirectAttributes) {

			userService.addR(rendezForm.getCIN(),rendezForm.getFull_name(),rendezForm.getNaissance(),rendezForm.getType_rd(),rendezForm.getNom_doc(),rendezForm.getDate(),rendezForm.getHeure(),rendezForm.getQuestion(),rendezForm.getEtat());
			redirectAttributes.addFlashAttribute("msg", "Your account has been created successfully!");

			return "redirect:/user/list4";
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

			return "redirect:/user/form";
		}
	}
	

	@RequestMapping(value = { "/list4" }, method = RequestMethod.GET)
	public ModelAndView list4() {
		ModelAndView model = new ModelAndView("malade/list4");
		List<rendezForm> listRdv = userService.listAllRdv();
		model.addObject("listRdv", listRdv);
		model.addObject("medecinActive", "active");
		model.addObject("medecinListActive", "active");
		return model;
	}

	@RequestMapping(value = "/list5/search", method = RequestMethod.POST)
	public ModelAndView searchRdv(@RequestParam("search") String des) {
		List<rendezForm> listRdv1 = userService.searchRdv(des);
		ModelAndView model = new ModelAndView("malade/list5");
		model.addObject("listRdv", listRdv1);
		model.addObject("medecinActive", "active");
		model.addObject("medecinListActive", "active");
		return model;

	}
	
	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {

		userService.deleteRdv(id);
		return new ModelAndView("redirect:/user/list4");
	}

	

}
