package todo.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import todo.domain.model.Users;

@Repository
public class UserRepository {

    private static String INSERT = "insert into users (nome) values (?)";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Users create(Users userModel) {
        // acessa db e salva user
        jdbcTemplate.update( INSERT, new Object[] { userModel.getNome() });
        return userModel;
    }
/*
    public void updateOne(UserModel user) {
        // acessa db e atualiza user
    }
    public static void deleteById(Long id) {

    }
    public void findById(Long id) {

    }
    public void list() {

    }

 */
}
