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
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer number;
    private Number valor;
    private String metaProductBankId;
    private String id;
    private String createdAt;
}
