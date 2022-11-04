package microservices.book.multiplication.user;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/{idList}")
    public List<Users> getUsersByIdList(@PathVariable final List<String> idList) {
        return userRepository.findAllByIdIn(idList);
    }
}
