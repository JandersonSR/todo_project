package todo.service;

import todo.domain.model.Todo;
import todo.rest.dto.TodoDTO;

public interface TodoService {
    Todo create(TodoDTO dto);

}
