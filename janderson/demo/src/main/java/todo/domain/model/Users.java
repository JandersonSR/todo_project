package todo.domain.model;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "email", length = 100)
    private String email;

    private String password;
    private String level;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @OneToMany(mappedBy = "users")
    private Set<Todo> todos;

    public Users(String nome) {
        this.setNome(nome);
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = LocalDate.now();
    }

}
