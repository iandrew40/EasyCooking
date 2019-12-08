package iandrew40.easycooking.service.services.post;

import iandrew40.easycooking.data.models.Post;
import iandrew40.easycooking.data.repositories.PostRepository;
import iandrew40.easycooking.service.models.post.PostCreateServiceModel;
import iandrew40.easycooking.service.services._shared.DateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostCreateServiceImpl implements PostCreateService{

    private final ModelMapper modelMapper;
    private final PostRepository postRepository;
    private final DateService dateService;

    @Autowired
    public PostCreateServiceImpl(ModelMapper modelMapper, PostRepository postRepository, DateService dateService) {
        this.modelMapper = modelMapper;
        this.postRepository = postRepository;
        this.dateService = dateService;
    }

    @Override
    public void create(PostCreateServiceModel postCreateServiceModel) {

        postCreateServiceModel.setDateAdded(this.dateService.getCurrentDate());

        Post post = this.modelMapper.map(postCreateServiceModel, Post.class);
        this.postRepository.save(post);
    }
}
