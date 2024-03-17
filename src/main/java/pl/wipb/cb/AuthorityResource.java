package pl.wipb.cb;


import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/authorities")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthorityResource {

    private final AuthorityService authorityService;

    public AuthorityResource(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    @PostMapping
    Authority save(@RequestBody SaveAuthorityCommand cmd) {
        return authorityService.save(cmd);
    }
    @GetMapping
    List<Authority> findAll() {
        return authorityService.findAll();
    }

    @GetMapping("/{id}")
    Authority findById(@PathVariable("id") Long id) {
        return authorityService.findById(id);
    }


}
