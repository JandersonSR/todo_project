package service;

import model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService (UserRepository repository) {
        this.repository = repository;
    }

    public void validate (UserModel user) {

    }

    public UserModel create (UserModel user) {
        validate(user);
        UserModel userCreated = this.repository.create(user);
        return userCreated
    }

    public void updateOne (UserModel user) {
        validate(user);
        this.repository.updateOne(user);
    }
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }
    public void findById (Long userId) {
        this.repository.findById(userId);
    }
    public void list () {
        this.repository.list();
    }
}
