package iandrew40.easycooking.web.controllers.user;

import iandrew40.easycooking.service.models.user.UserRegisterServiceModel;
import iandrew40.easycooking.service.services.user.UserService;
import iandrew40.easycooking.web.annotations.PageTitle;
import iandrew40.easycooking.web.models.user.UserLoginModel;
import iandrew40.easycooking.web.models.user.UserRegisterModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;

    @Autowired
    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/register")
    @PageTitle("Register")
    public String getRegisterForm(Model model){
        model.addAttribute("model", new UserRegisterModel());

        return "user/register.html";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserRegisterModel registerModel){
        if (!registerModel.getPassword().equals(registerModel.getConfirmPassword())){
            return "user/register.html";
        }

        UserRegisterServiceModel serviceModel = this.modelMapper.map(registerModel, UserRegisterServiceModel.class);

        this.userService.register(serviceModel);


        return "redirect:/user/login";
    }

    @GetMapping("/login")
    @PageTitle("Login")
    public String getLoginForm(Model model){
        model.addAttribute("model", new UserLoginModel());

        return "user/login.html";
    }
}
