package todo.domain.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String userId;

    @Column(name = "nome", length = 100)
    private String nome;

    private String systemId;
    private String createdAt;

    public Users() {}
    public Users(String nome) {
        this.setNome(nome);
    }
}
