package implementation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	
	@RequestMapping({"/", "index"})
	public  String inicio() {
		return "index";
	}
	
	@RequestMapping("/webprivado")
	public String privado() {
		return "private";
	}
	
	@RequestMapping("/webpublico")
	public String loginpub() {
		return "public";
	}
	
	@RequestMapping("/webadmin")
	  public String admin() {
	    return "admin";
	  }
	
	@RequestMapping("/login")
	  public String login() {
	    return "login";
	  }

}
