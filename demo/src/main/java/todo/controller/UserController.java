package todo.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/users")

@Controller
public class UserController {

        @Autowired
        private UserService userService;


        @PostMapping(path = { "/" })
        public ResponseEntity<UserModel> create(@RequestBody UserModel user) {
                return ResponseEntity.ok(this.userService.create(user), HttpStatus.OK);
        }

        @PatchMapping(path = { "/{id}" })
        public ResponseEntity<UserModel> update(@PathVariable long id, @RequestBody UserModel user) {
                return ResponseEntity.ok(this.userService.updateOne(id, user), HttpStatus.OK);
        }

        @DeleteMapping(path = { "/{id}" })
        public void delete(@PathVariable long id) {
            UserService.deleteById(id);
        }

        @GetMapping(path = { "/{id}" })
        public void findById(@PathVariable long id) {
           Optional<Users> selectedUser = UserService.findById(id);
           if (selectedUser.isPresent) {
               return ResponseEntity.ok(this.selectedUser, HttpStatus.OK);
           }
            return ResponseEntity.notFound(this.selectedUser);

        }
        @GetMapping(path = { "/" })
        public void list() {
            UserService.list();
        }
}
