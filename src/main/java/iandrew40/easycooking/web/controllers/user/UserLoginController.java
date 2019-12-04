package iandrew40.easycooking.web.controllers.user;

import iandrew40.easycooking.service.models.user.UserLoginServiceModel;
import iandrew40.easycooking.service.services.user.UserLoginService;
import iandrew40.easycooking.web.models.user.UserLoginModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserLoginController {

    private final ModelMapper modelMapper;
    private final UserLoginService userLoginService;

    @Autowired
    public UserLoginController(ModelMapper modelMapper, UserLoginService userLoginService) {
        this.modelMapper = modelMapper;
        this.userLoginService = userLoginService;
    }


    @GetMapping("/login")
    public String getLoginForm(Model model){
        model.addAttribute("model", new UserLoginModel());

        return "user/login.html";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute UserLoginModel userLoginModel, HttpSession session){

        UserLoginServiceModel serviceModel = this.modelMapper.map(userLoginModel, UserLoginServiceModel.class);

        session.setAttribute("user", serviceModel);
        this.userLoginService.login(serviceModel);


        return "redirect:/";
    }
}
