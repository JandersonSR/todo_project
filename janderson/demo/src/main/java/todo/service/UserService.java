package todo.service;

import todo.domain.model.Users;
import todo.rest.dto.UserDTO;

public interface UserService {

    Users create(UserDTO dto);
}
