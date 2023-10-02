package controller;

import model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@SpringBootApplication
@RestController
@RequestMapping("/task")

public class UserController {

        @Autowired
        private UserService userService;

        // injetar propriedade diretamente
        @Value("${application.titleName}")
        private String titleName;


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
            UserService.findById(id);
        }
        @GetMapping(path = { "/" })
        public void list() {
            UserService.list();
        }



}
