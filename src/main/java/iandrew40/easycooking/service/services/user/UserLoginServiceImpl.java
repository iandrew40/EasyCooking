package iandrew40.easycooking.service.services.user;

import iandrew40.easycooking.data.repositories.UserRepository;
import iandrew40.easycooking.service.models.user.UserLoginServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    private final UserRepository userRepository;
    private final HashingService hashingService;

    @Autowired
    public UserLoginServiceImpl(UserRepository userRepository, HashingService hashingService) {
        this.userRepository = userRepository;
        this.hashingService = hashingService;
    }

    @Override
    public void login(UserLoginServiceModel model) {
        String hashPassword = hashingService.hashPassword(model.getPassword());

        if (this.userRepository.findUserByUsernameAndPassword(model.getUsername(), hashPassword) == null) {
            System.out.println("null");
        } else {
            System.out.println("found");
        }


    }

}
