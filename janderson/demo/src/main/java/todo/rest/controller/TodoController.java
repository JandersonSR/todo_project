package todo.rest.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import todo.domain.model.Todo;
import todo.service.TodoService;
import todo.service.imp.TodoServiceImp;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/todo")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        System.out.println("Passing here");
        return ResponseEntity.ok(this.todoService.create(todo));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Todo> update(@PathVariable Long id, @RequestBody Todo todo) {
        Optional<Todo> selectedTodo = this.todoService.findById(id);
        if (selectedTodo.isPresent()) {
            return ResponseEntity.ok(this.todoService.updateOne(todo));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Optional<Todo> selectedTodo = this.todoService.findById(id);
        if (selectedTodo.isPresent()) {
            this.todoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public Todo findById(@PathVariable Long id) {
        return this.todoService
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Usuário não encontrado!"
                        )
                );
    }
    @GetMapping
    public ResponseEntity<List<Todo>> list() {
        System.out.println("Passing here");
        return ResponseEntity.ok(this.todoService.list());
    }
}
