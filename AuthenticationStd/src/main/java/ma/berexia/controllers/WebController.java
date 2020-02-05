package ma.berexia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.berexia.services.ClientService;
import ma.berexia.services.UserService;

@Controller
public class WebController {

	@Autowired
	private UserService userService;
	@Autowired
	private ClientService clientService;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/home")
	public String homePage() {
		return "home";
	}

	@RequestMapping("/inscription")
	public String inscriptionPage() {
		return "inscription";
	}

	@RequestMapping("/register")
	public String registerPage() {
		return "register";
	}
}
