package iandrew40.easycooking.web.controllers.post;

import iandrew40.easycooking.service.models.post.PostCreateServiceModel;
import iandrew40.easycooking.service.services.post.PostCreateService;
import iandrew40.easycooking.web.annotations.PageTitle;
import iandrew40.easycooking.web.models.post.PostCreateModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/post")
public class PostCreateController {

    private final PostCreateService postCreateService;
    private final ModelMapper modelMapper;

    @Autowired
    public PostCreateController(PostCreateService postCreateService, ModelMapper modelMapper) {
        this.postCreateService = postCreateService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/create-post")
    @PageTitle("Create Post")
    public String getCreatePost(Model model){
        model.addAttribute("model", new PostCreateModel());

        return "post/create-post.html";
    }

    @PostMapping("/create-post")
    public String createPost(@ModelAttribute PostCreateModel postCreateModel){

        System.out.println();

        PostCreateServiceModel postCreateServiceModel = this.modelMapper
                .map(postCreateModel, PostCreateServiceModel.class);


        postCreateService.create(postCreateServiceModel);

        return "redirect:/";
    }
}
