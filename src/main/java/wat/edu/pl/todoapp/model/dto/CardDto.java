package wat.edu.pl.todoapp.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CardDto implements Serializable {
    private long id;

    private String cardCategory;

    private String eventCardDateTime;

    private String cardDescription;

    private boolean isFinished;
}
