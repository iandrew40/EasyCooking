package iandrew40.easycooking.service.services.user;

import iandrew40.easycooking.data.models.Recipe;
import iandrew40.easycooking.data.models.User;
import iandrew40.easycooking.service.models.user.UserRegisterServiceModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void register(UserRegisterServiceModel registerServiceModel);

    void addRecipeToUser(User user, Recipe recipe);

}
