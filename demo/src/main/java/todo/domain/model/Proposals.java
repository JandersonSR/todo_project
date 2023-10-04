package todo.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

@Entity
public class Proposals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private BigDecimal valor;
    private String metaProductBankId;
    private String proposalId;
    private String createdAt;
}
