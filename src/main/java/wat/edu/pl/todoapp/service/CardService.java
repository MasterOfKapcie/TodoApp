package wat.edu.pl.todoapp.service;

import wat.edu.pl.todoapp.model.dto.CardDto;

import java.util.List;

public interface CardService {
    void saveCard(CardDto cardDto);
    List<CardDto> getAllCards();
    void deleteCard(long cardId);
    void setFinished(long cardId);
}
