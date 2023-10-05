package todo.rest.dto;

import lombok.*;
import todo.domain.model.Users;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
    private Long id;
    private String description;
    private String title;
    private boolean isFinished;
    private LocalDate deadLine;
    private Long users;

}
