package iandrew40.easycooking.service.services.user;

import iandrew40.easycooking.data.models.User;
import iandrew40.easycooking.data.repositories.UserRepository;
import iandrew40.easycooking.service.models.user.UserRegisterServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationService validationService;
    private final HashingService hashingService;

    @Autowired
    public UserRegisterServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationService validationService, HashingService hashingService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationService = validationService;
        this.hashingService = hashingService;
    }


    @Override
    public void register(UserRegisterServiceModel registerServiceModel) {

        if (!validationService.isValid(registerServiceModel)){
            return;
        }

        registerServiceModel.setPassword(this.hashingService.hashPassword(registerServiceModel.getPassword()));
        registerServiceModel.setSex(registerServiceModel.getSex().toUpperCase());
        registerServiceModel.setStatus(registerServiceModel.getStatus().toUpperCase());

        User user = this.modelMapper.map(registerServiceModel, User.class);
        this.userRepository.save(user);

    }
}
