package pl.wipb.cb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserSaveCLRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private Logger log = LoggerFactory.getLogger(getClass());

    public UserSaveCLRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Creating user");
        User user = new User();
        user.setUsername("user");
        user.setPassword("user");
        userRepository.save(user);
    }
}
