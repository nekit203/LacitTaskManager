package mvc;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.User;

import service.UserService;


@Controller
public class LoginController {

    private final static Logger logger = Logger.getLogger(LoginController.class.getName());
 
    @Autowired
    private UserService srv;


    @RequestMapping("/index")
    public String index(Model model) {
    	logger.debug("index.jsp");
    	entity.User user = new entity.User();
        model.addAttribute("user", user);
        return "index";
    }


    @RequestMapping("/mypage")
    public String mypage(Principal principal, Model model) {
    	logger.debug("mypage.jsp");
    	   User user = srv.getUser(principal.getName());
           if (user==null) 
               return "redirect:/logout";  
          
           model.addAttribute("user", user);         
           return "mypage";
    }

}
