package fr.adaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogAndLogoutController {

	@RequestMapping("/loginUrl")
	public String pageLogin(){
		return "login";
	}


}
