package todo.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import todo.domain.model.Proposals;
import todo.domain.model.Users;

@Repository
public class ProposalRepository {

    private static String INSERT = "insert into proposals (metaProductBankId) values (?)";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Proposals create(Proposals proposalModel) {
        // acessa db e salva user
        jdbcTemplate.update( INSERT, new Object[] { proposalModel.getMetaProductBankId() });
        return proposalModel;
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
