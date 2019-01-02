package wat.edu.pl.todoapp.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "card")
@NoArgsConstructor
public class Card implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String cardCategory;

    private LocalDateTime eventCardDateTime;

    private String cardDescription;
}
