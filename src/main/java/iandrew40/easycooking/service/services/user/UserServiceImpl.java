package iandrew40.easycooking.service.services.user;

import iandrew40.easycooking.data.models.Recipe;
import iandrew40.easycooking.data.models.User;
import iandrew40.easycooking.data.repositories.RoleRepository;
import iandrew40.easycooking.data.repositories.UserRepository;
import iandrew40.easycooking.service.models.user.UserRegisterServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationService validationService;
    private final HashingService hashingService;
    private final RoleService roleService;
    private final RoleRepository roleRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationService validationService, HashingService hashingService, RoleService roleService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationService = validationService;
        this.hashingService = hashingService;
        this.roleService = roleService;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void register(UserRegisterServiceModel registerServiceModel) {
        if (!validationService.isValid(registerServiceModel)) {
            return;
        }

        registerServiceModel.setPassword(this.hashingService.hashPassword(registerServiceModel.getPassword()));
        registerServiceModel.setSex(registerServiceModel.getSex().toUpperCase());

        User user = this.modelMapper.map(registerServiceModel, User.class);

        if (this.userRepository.count() == 0){
            this.roleService.seedRolesInDb();

            user.setAuthorities(new HashSet<>(this.roleRepository.findAll()));
        }else {
            user.setAuthorities(new HashSet<>(Set.of(this.roleRepository.findByAuthority("USER"))));
        }


        this.userRepository.save(user);

    }

    @Override
    public void addRecipeToUser(User user, Recipe recipe) {

       List<Recipe> recipes = new ArrayList<>();

       recipes.addAll(user.getCreatedRecipes());
       recipes.add(recipe);
       user.setCreatedRecipes(recipes);



    }
}

