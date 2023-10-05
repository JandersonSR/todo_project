package todo.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private BigDecimal valor;
    private String title;
    private String description;

    @Column(name = "has_finished")
    private Boolean hasFinished;

    @Column(name = "dead_line")
    private LocalDate deadLine;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    @Column(name = "created_at")
    private LocalDate createdAt;
}
