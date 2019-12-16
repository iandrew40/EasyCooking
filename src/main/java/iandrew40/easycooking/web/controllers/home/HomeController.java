package iandrew40.easycooking.web.controllers.home;

import iandrew40.easycooking.web.annotations.PageTitle;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

    @GetMapping("/")
    @PreAuthorize("isAnonymous()")
    @PageTitle("Index")
    public String getIndex(ModelAndView modelAndView){
        modelAndView.setViewName("/");
        return "/index";
    }

    @GetMapping("/home")
    @PreAuthorize("isAuthenticated()")
    @PageTitle("Home")
    public ModelAndView getHome(ModelAndView modelAndView){

        modelAndView.setViewName("/home");
        return modelAndView;
    }
}
