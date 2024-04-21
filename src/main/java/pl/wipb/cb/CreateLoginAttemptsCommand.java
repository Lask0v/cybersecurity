package pl.wipb.cb;

public record CreateLoginAttemptsCommand(Long userId, Integer attempts) {
}
