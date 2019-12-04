package iandrew40.easycooking.web.controllers.user;

import iandrew40.easycooking.service.models.user.UserRegisterServiceModel;
import iandrew40.easycooking.service.services.user.UserRegisterService;
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
public class UserRegisterController {

    private final ModelMapper modelMapper;
    private final UserRegisterService userRegisterService;

    @Autowired
    public UserRegisterController(ModelMapper modelMapper, UserRegisterService userRegisterService) {
        this.modelMapper = modelMapper;
        this.userRegisterService = userRegisterService;
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model){
        model.addAttribute("model", new UserRegisterModel());

        return "user/register.html";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserRegisterModel registerModel){

        UserRegisterServiceModel serviceModel = this.modelMapper.map(registerModel, UserRegisterServiceModel.class);
        userRegisterService.register(serviceModel);

        return "redirect:/";
    }

}
