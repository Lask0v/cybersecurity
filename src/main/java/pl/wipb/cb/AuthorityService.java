package pl.wipb.cb;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService {


    private final AuthorityRepository authorityRepository;

    public AuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }


    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }

    public Authority save(SaveAuthorityCommand command) {
        Authority authority = new Authority();
        authority.setMessage(new Message(command.messageId()));
        authority.setUser(new User(command.userId()));
        authority.setCanModify(command.canModify());
        return authorityRepository.save(authority);
    }

    public Authority findById(Long id) {
        return authorityRepository.findById(id).orElseThrow();
    }
}


