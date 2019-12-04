package iandrew40.easycooking.service.services.user;

import iandrew40.easycooking.service.models.user.UserRegisterServiceModel;

public interface ValidationService {

    boolean isValid(UserRegisterServiceModel registerServiceModel);

}
