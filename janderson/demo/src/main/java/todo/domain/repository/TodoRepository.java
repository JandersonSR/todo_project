package todo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.domain.model.Todo;
import todo.domain.model.Users;

import java.util.List;
import java.util.Set;


public interface TodoRepository extends JpaRepository<Todo,Long> {
    List<Todo> findByCliente(Users cliente);
}
