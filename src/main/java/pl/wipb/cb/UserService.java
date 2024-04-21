package pl.wipb.cb;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final static int MAX_DELAY  = 1000;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User saveUser(User user) {
        return userRepository.findByUsername(user.getUsername()).orElse(userRepository.save(user));
    }

    @Transactional
    public void createLoginAttempts(CreateLoginAttemptsCommand cmd) {
        userRepository.findById(cmd.userId())
                .ifPresent(user -> user.setLoginAttempts(cmd.attempts()));
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User login(AuthCommand command) {
        Optional<User> userOptional = userRepository.findByUsernameAndPassword(command.username(), command.password());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setLastSuccessfulLogin(LocalDate.now());
            user.setLoginAttempts(0);
            userRepository.save(user);
            return user;
        } else {
            Optional<User> unsuccessfulUserOptional = userRepository.findByUsername(command.username());
            if (unsuccessfulUserOptional.isPresent()) {
                User unsuccessfulUser = unsuccessfulUserOptional.get();
                unsuccessfulUser.setLastUnsuccessfulLogin(LocalDate.now());
                Integer lastUnsuccessfulLoginAttempts = unsuccessfulUser.getLastUnsuccessfulLoginAttempts();
                int delay = lastUnsuccessfulLoginAttempts != null ? (int) Math.pow(2, lastUnsuccessfulLoginAttempts) : 1;
                delay = Math.min(delay, MAX_DELAY); // Limitujemy maksymalne opóźnienie

                // Oczekiwanie na upłynięcie czasu
                long startTime = System.currentTimeMillis();
                while (System.currentTimeMillis() - startTime < delay * 1000L) {
                    // Pusta pętla, czekamy na upłynięcie czasu
                }

                unsuccessfulUser.setLastUnsuccessfulLoginAttempts(lastUnsuccessfulLoginAttempts != null ? lastUnsuccessfulLoginAttempts + 1 : 1);
                userRepository.save(unsuccessfulUser); // Zachowaj zmiany dla nieudanego logowania
            }
            return null; // Zwróć null, jeśli logowanie nie powiodło się
        }
    }

}

