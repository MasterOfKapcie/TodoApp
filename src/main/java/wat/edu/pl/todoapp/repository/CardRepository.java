package wat.edu.pl.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wat.edu.pl.todoapp.model.entity.Card;

public interface CardRepository extends JpaRepository<Card,Long> {
}
