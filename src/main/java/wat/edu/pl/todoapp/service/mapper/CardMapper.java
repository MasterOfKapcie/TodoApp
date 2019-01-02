package wat.edu.pl.todoapp.service.mapper;

import wat.edu.pl.todoapp.model.dto.CardDto;
import wat.edu.pl.todoapp.model.entity.Card;

public interface CardMapper {
    CardDto mapToDto(Card card);
    Card mapToDbo(CardDto cardDto);
}
