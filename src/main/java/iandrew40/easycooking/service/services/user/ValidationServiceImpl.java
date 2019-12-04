package iandrew40.easycooking.service.services.user;

import iandrew40.easycooking.data.repositories.UserRepository;
import iandrew40.easycooking.service.models.user.UserRegisterServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidationServiceImpl implements ValidationService {

    private final UserRepository userRepository;

    @Autowired
    public ValidationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(UserRegisterServiceModel model) {

        if (doPasswordsMatch(model.getPassword(), model.getConfirmPassword())
                && isEmailValid(model.getEmail()) && isUsernameFree(model.getUsername())) {
            return true;
        } else {
            return false;
        }
    }

    private boolean doPasswordsMatch(String password, String confirmPassword) {
        if (password.equals(confirmPassword)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmailValid(String email){
        String emailRegex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    private boolean isUsernameFree(String username){
        return !this.userRepository.existsByUsername(username);
    }

}
