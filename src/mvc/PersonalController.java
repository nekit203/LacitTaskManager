package mvc;

import java.security.Principal;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.User;
import service.UserService;

@Controller
public class PersonalController {

    private final static Logger logger = Logger.getLogger(LoginController.class.getName());

    @Autowired
    private UserService srv;


    @RequestMapping("/saveinfo")
    public String saveinfo(Principal principal, Model model,
            HttpServletRequest request, HttpServletResponse response) throws ParseException {
        User user = srv.getUser(principal.getName());
        if (user==null)
            return "redirect:/logout";
        
        return "redirect:/mypage.html";
    }
}
