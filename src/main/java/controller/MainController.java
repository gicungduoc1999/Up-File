package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	
	//mapping 
	@RequestMapping("home")
	public String home() {
		return "home/home";
	}
	@RequestMapping("login")
	public String login() {
		return "home/login";
	}
	//driver 
	@RequestMapping("driver")
	public String driver() {
		return "driver/driver";
	}
	@RequestMapping("manager")
	public String manager() {
		return "driver/manager";
	}
	
	
	
}
