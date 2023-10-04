package todo.domain.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    private String systemId;
    private LocalDate createdAt;

    @OneToMany(mappedBy = "users")
    private Set<Proposals> proposals;

    public Users() {}
    public Users(String nome) {
        this.setNome(nome);
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", systemId='" + systemId + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
