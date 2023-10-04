package todo.domain.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import todo.domain.model.Users;

import java.util.List;

public interface UserRepository extends JpaRepository<Users,Integer> {

    List<Users> findByNomeLike(String nome);
    List<Users> findByNomeLikeOrId(String nome, Integer id);
    List<Users> findByNomeLikeOrIdOrderById(String nome, Integer id);

    Users findOneByNome(String nome);

    @Query(value = " select * from users c where c.nome like '%:nome%' ", nativeQuery = true)
    List<Users> encontrarPorNome(@Param("nome") String nome);

    boolean existsByNome(String nome);
}
