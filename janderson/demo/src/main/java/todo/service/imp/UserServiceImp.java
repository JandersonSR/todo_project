package todo.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.domain.model.Users;
import todo.domain.repository.UserRepository;
import org.springframework.data.domain.Example;
import todo.rest.dto.UserDTO;
import todo.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    private UserRepository repository;

    @Autowired
    public UserServiceImp(UserRepository repository) {
        this.repository = repository;
    }

    public void validate (Users user) {

    }

    public Users create (Users user) {
        validate(user);
        return this.repository.save(user);
    }

    public Users updateOne (Users user) {
        validate(user);
        return this.repository.save(user);
    }

    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }
    public Optional<Users> findById (Long id) {
        return this.repository.findById(id);
    }
    public List<Users> list (Example filter) {
        return this.repository.findAll(filter);
    }

    @Override
    public Users create(UserDTO dto) {


//        Long userId = dto.getUser();
        return null;
    }
}
