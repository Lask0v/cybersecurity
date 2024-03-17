package pl.wipb.cb;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
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
