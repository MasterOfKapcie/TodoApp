package wat.edu.pl.todoapp.service.mapper.impl;

import org.springframework.stereotype.Component;
import wat.edu.pl.todoapp.model.dto.CardDto;
import wat.edu.pl.todoapp.model.entity.Card;
import wat.edu.pl.todoapp.service.mapper.CardMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CardMapperImpl implements CardMapper {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    @Override
    public CardDto mapToDto(Card card) {
        CardDto cardDto = new CardDto();
        cardDto.setCardCategory(card.getCardCategory());
        cardDto.setCardDescription(card.getCardDescription());
        cardDto.setEventCardDateTime(card.getEventCardDateTime().format(formatter));
        cardDto.setId(card.getId());
        cardDto.setFinished(card.isFinished());
        return cardDto;
    }

    @Override
    public Card mapToDbo(CardDto cardDto) {
        Card card = new Card();
        card.setCardCategory(cardDto.getCardCategory());
        card.setCardDescription(cardDto.getCardDescription());
        card.setId(cardDto.getId());
        card.setEventCardDateTime(LocalDateTime.parse(cardDto.getEventCardDateTime(),formatter));
        card.setFinished(false);
        return card;
    }
}
