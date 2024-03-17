package pl.wipb.cb;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public User save(@RequestBody SaveUserCommand cmd) {
        User user = new User();
        user.setPassword(cmd.password());
        user.setUsername(cmd.login());
        return userService.saveUser(user);
    }
}
