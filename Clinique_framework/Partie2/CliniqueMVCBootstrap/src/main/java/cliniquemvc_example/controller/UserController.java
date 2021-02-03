package cliniquemvc_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cliniquemvc_example.form.UserForm;
import cliniquemvc_example.form.medecinForm;
import cliniquemvc_example.model.UserInfo;
import cliniquemvc_example.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

	

	@Autowired
	UserService userService;
	


	@RequestMapping(value = {"/portfolio" }, method = RequestMethod.GET)
	public ModelAndView portfolio() {
		ModelAndView model = new ModelAndView();
		model.setViewName("user/portfolio");
		return model;}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView form() {
		ModelAndView model = new ModelAndView("user/form");
		model.addObject("medecinForm", new medecinForm());

		return model;
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String submit(@ModelAttribute("medecinForm") medecinForm medecinForm, BindingResult result,
			RedirectAttributes redirectAttributes) {

			userService.addM(medecinForm.getCIN(),medecinForm.getFull_name(),medecinForm.getGender(),medecinForm.getSpecialité(),medecinForm.getDate(),medecinForm.getPlace(),medecinForm.getPhone(),medecinForm.getAge(),medecinForm.getAddress(),medecinForm.getPhone2(),medecinForm.getMail(), medecinForm.getImmatricule());
			redirectAttributes.addFlashAttribute("msg", "Your account has been created successfully!");

			return "redirect:/login";
		}
	

	

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("user/lists");
		model.addObject("list", userService.list());

		return model;
	}

	@RequestMapping(value = "/changePass/{username}", method = RequestMethod.GET)
	public ModelAndView changePass(@PathVariable("username") String username) {
		ModelAndView model = new ModelAndView("user/change_pass");
		model.addObject("user", userService.findUserByUsername(username));

		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView Save(@ModelAttribute("user") UserInfo user) {
		ModelAndView model = changePass(user.getUsername());
		userService.update(user.getUsername(), user.getPassword());
		model.addObject("msg", "Your password has been changed successfully!");

		return model;
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

}
