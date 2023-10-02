package repository;

import model.UserModel;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public create(UserModel user) {
        // acessa db e salva user

    }
    public void updateOne(UserModel user) {
        // acessa db e atualiza user
    }
    public static void deleteById(Long id) {

    }
    public void findById(Long id) {

    }
    public void list() {

    }
}
