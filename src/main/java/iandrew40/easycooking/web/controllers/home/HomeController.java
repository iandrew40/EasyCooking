package iandrew40.easycooking.web.controllers.home;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    @PreAuthorize("isAnonymous()")
    public String getIndex(HttpSession session){
        return "index.html";
    }

    @GetMapping("/home")
    @PreAuthorize("isAuthenticated()")
    public String getHome(){

        return "/home";
    }
}
