package todo.rest.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import todo.domain.model.Users;
import todo.rest.dto.UserDTO;
import todo.service.UserService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public Users create(@RequestBody UserDTO user) {
        System.out.println("Passing here 1");
            return this.userService.create(user);
        }

        @PatchMapping("{id}")
        public ResponseEntity<Users> update(@PathVariable Long id, @RequestBody UserDTO user) {
            System.out.println("Passing here 2");
            Optional<Users> selectedUser = this.userService.findById(id);
            if (selectedUser.isPresent()) {
                return ResponseEntity.ok(this.userService.updateOne(user));
            }
            return ResponseEntity.notFound().build();
        }

        @DeleteMapping("{id}")
        public ResponseEntity delete(@PathVariable Long id) {
            System.out.println("Passing here 3");
            Optional<Users> selectedUser = this.userService.findById(id);
            if (selectedUser.isPresent()) {
                this.userService.deleteById(id);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        }

        @GetMapping("{id}")
        public Users findById(@PathVariable Long id) {
            System.out.println("Passing here 4");
           return this.userService
                   .findById(id)
                   .orElseThrow(() ->
                           new ResponseStatusException(
                                   HttpStatus.NOT_FOUND,
                                   "Usuario não encontrado"
                           )
                   );
        }
        @GetMapping
        public List<Users> list(Users filter) {
            System.out.println("Passing here 5");
            ExampleMatcher matcher = ExampleMatcher
                    .matching()
                    .withIgnoreCase()
                    .withStringMatcher(
                            ExampleMatcher.StringMatcher.CONTAINING );

            Example example = Example.of(filter, matcher);
            return this.userService.list(example);
        }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void fullUpdate( @PathVariable Long id,
                        @RequestBody Users users ){
        this.userService
                .findById(id)
                .map( clienteExistente -> {
                    users.setId(clienteExistente.getId());
                    this.userService.create(users);
                    return clienteExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Usuário não encontrado") );
    }
}
