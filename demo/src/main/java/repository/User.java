package repository;

import model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface User extends JpaRepository<UserModel, Long> {
}
