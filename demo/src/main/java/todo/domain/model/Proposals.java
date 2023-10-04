package todo.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

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

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    private LocalDate createdAt;

    @Override
    public String toString() {
        return "Proposals{" +
                "id=" + id +
                ", valor=" + valor +
                ", metaProductBankId='" + metaProductBankId + '\'' +
                ", proposalId='" + proposalId + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
