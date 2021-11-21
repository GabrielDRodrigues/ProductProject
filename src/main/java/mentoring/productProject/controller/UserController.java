package mentoring.productProject.controller;

import mentoring.productProject.controller.form.UserForm;
import mentoring.productProject.repository.UserRepository;
import mentoring.productProject.resource.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @GetMapping
    public List<UserDto> userList (){
        List<User> users = userRepository.findAll();
        return UserDto.converter(users);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UserDto> registerUser(@RequestBody @Valid UserForm form, UriComponentsBuilder uriComponentsBuilder){
        User user = form.converter();
        userRepository.save(user);

        URI uri = uriComponentsBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDto(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> detail (@PathVariable Integer id){
        Optional <User> user = userRepository.findById(id);
        if (user.isPresent()){
            return ResponseEntity.ok(new UserDto(user.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UserDto> update (@PathVariable Integer id, @RequestBody @Valid UserForm form){
        Optional <User> userUpdate = userRepository.findById(id);
        if (userUpdate.isPresent()) {
            User user = form.update(id, userRepository);
            return ResponseEntity.ok(new UserDto(user));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping ("/{id}")
    @Transactional
    public ResponseEntity<?> remove (@PathVariable Integer id){
        Optional <User> userRemove = userRepository.findById(id);
        if (userRemove.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
