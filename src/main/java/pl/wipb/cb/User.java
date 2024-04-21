package pl.wipb.cb;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    private boolean blocked;
    private Integer loginAttempts;
    private LocalDate lastUnsuccessfulLogin;
    private LocalDate lastSuccessfulLogin;
    private Integer lastUnsuccessfulLoginAttempts;


    public Integer getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(Integer loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public LocalDate getLastUnsuccessfulLogin() {
        return lastUnsuccessfulLogin;
    }

    public void setLastUnsuccessfulLogin(LocalDate lastUnsuccessfulLogin) {
        this.lastUnsuccessfulLogin = lastUnsuccessfulLogin;
    }

    public LocalDate getLastSuccessfulLogin() {
        return lastSuccessfulLogin;
    }

    public void setLastSuccessfulLogin(LocalDate lastSuccessfulLogin) {
        this.lastSuccessfulLogin = lastSuccessfulLogin;
    }

    public Integer getLastUnsuccessfulLoginAttempts() {
        return lastUnsuccessfulLoginAttempts;
    }

    public void setLastUnsuccessfulLoginAttempts(Integer lastUnsuccessfulLoginAttempts) {
        this.lastUnsuccessfulLoginAttempts = lastUnsuccessfulLoginAttempts;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public User(Long userId) {
        this.id = userId;
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public User(String username, String password, boolean blocked) {
        this.username = username;
        this.password = password;
        this.blocked = blocked;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

