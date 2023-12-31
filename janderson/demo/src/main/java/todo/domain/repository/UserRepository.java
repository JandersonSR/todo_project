package todo.domain.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import todo.domain.model.Users;

import java.util.List;

public interface UserRepository extends JpaRepository<Users,Long> {

    List<Users> findByNomeLike(String nome);
    List<Users> findByNomeLikeOrId(String nome, Long id);
    List<Users> findByNomeLikeOrIdOrderById(String nome, Long id);

    Users findOneByNome(String nome);

//    @Query(" select u from users u left join fetch u.proposals where u.id = :id ")
//    Users findUserFetchProposals(@Param("id") Integer id);

    @Query(value = " select * from users u where u.nome like '%:nome%' ", nativeQuery = true)
    List<Users> encontrarPorNome(@Param("nome") String nome);


    boolean existsByNome(String nome);
}
