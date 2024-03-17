package pl.wipb.cb;

public record SaveAuthorityCommand(Long messageId, Long userId, Boolean canModify) {
}
