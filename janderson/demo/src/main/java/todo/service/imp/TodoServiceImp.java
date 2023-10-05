package todo.service.imp;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import todo.domain.model.Todo;
import todo.domain.model.Users;
import todo.domain.repository.TodoRepository;
import todo.domain.repository.UserRepository;
import todo.exception.BusinessRuleException;
import todo.rest.dto.TodoDTO;
import todo.service.TodoService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoServiceImp implements TodoService {

    private final TodoRepository repository;
    private final UserRepository userRepository;

//    @Autowired
//    public TodoServiceImp(TodoRepository repository) {
//        this.repository = repository;
//    }

    public void validate (Todo todo) {

    }

//    public Todo create (Todo todo) {
//        validate(todo);
//        return this.repository.save(todo);
//    }

    public Todo updateOne (Todo todo) {
        validate(todo);
        return this.repository.save(todo);
    }

    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }
    public Optional<Todo> findById (Long id) {
        return this.repository.findById(id);
    }
    public List<Todo> list () {
        return this.repository.findAll();
    }

    @Override
    @Transactional
    public Todo create(TodoDTO dto) {
        Long userId = dto.getUsers();
        Users cliente = userRepository
                .findById(userId)
                .orElseThrow(() -> new BusinessRuleException("Código de cliente inválido."));

        Todo todo = new Todo();
        todo.setCreatedAt(LocalDate.now());
        todo.setTitle(dto.getTitle());
        todo.setDeadLine(dto.getDeadLine());
        todo.setUsers(cliente);

        return null;
    }
}
