package todo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.domain.model.Proposals;

public interface ProposalRepository extends JpaRepository<Proposals,Integer> {
}
