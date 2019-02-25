package mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.User;
import security.SecurityService;
import security.UserSecurityService;
import service.UserService;
import validation.EmailExistsException;
import validation.EmailNotValidException;

@Controller
public class RegistrationController {
    @Autowired
    private UserService srv;
    
    @Autowired
    private UserDetailsService uds;

    @Autowired
    RequestCache requestCache;
    
    @Autowired
    private AuthenticationManager  authManager;

    private final static Logger logger = Logger.getLogger(LoginController.class.getName());

    @RequestMapping("/reg")
    public String registerUserAccount(@ModelAttribute("user") @Valid entity.User account, BindingResult result,
            Model model, HttpServletRequest request, HttpServletResponse response)
            throws EmailExistsException {
        logger.debug("Registering user account with information: {}" + account.getEmail());
        User registered = new User();
        if (!result.hasErrors()) {
            if ((!account.getEmail().isEmpty()) && (!account.getReal_name().isEmpty())
                    && (!account.getPassword().isEmpty())) {
                registered = detectEmail(account);
            } else {
                model.addAttribute("email", "Fill in all the fields");
                return "index";
            }
        }
        if (registered == null) {
            model.addAttribute("email", "Email is already exist : " + account.getEmail());
            return "index";
        }else if (registered.getEmail().equals("EmailNotValidException") == true) {
            model.addAttribute("email", "Your email is not correct: " + account.getEmail());
            return "index";
        }
        logger.debug("begin auto logIn");
        doAutoLogin(registered.getEmail(), registered.getPassword(), request);
        
        return "redirect:/mypage.html";
    }

    private entity.User detectEmail(final entity.User account) {
        User registered = null;
        try {
            registered = srv.createUserAccount(account);
        } catch (final EmailExistsException e) {
            return null;
        } catch (EmailNotValidException e) {
            registered = new User();
            registered.setEmail("EmailNotValidException");
            return registered;
        }
        return registered;
    }
    
    private void doAutoLogin(String username, String password, HttpServletRequest request) {

        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            token.setDetails(new WebAuthenticationDetails(request));
            Authentication authentication = authManager.authenticate(token);
            logger.debug("Logging in with "+ authentication.getPrincipal());
            SecurityContext sc = SecurityContextHolder.getContext();
            sc.setAuthentication(authentication);
            HttpSession session = request.getSession(true);
            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, sc);
        } catch (Exception e) {
            SecurityContextHolder.getContext().setAuthentication(null);
            logger.error("Failure in autoLogin", e);
        }

    }
}


