package wat.edu.pl.todoapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wat.edu.pl.todoapp.model.dto.CardDto;
import wat.edu.pl.todoapp.model.entity.Card;
import wat.edu.pl.todoapp.repository.CardRepository;
import wat.edu.pl.todoapp.service.CardService;
import wat.edu.pl.todoapp.service.mapper.CardMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    private final CardMapper cardMapper;

    @Override
    public void saveCard(CardDto cardDto) {
        cardRepository.save(cardMapper.mapToDbo(cardDto));
    }

    @Override
    public List<CardDto> getAllCards() {
        return cardRepository.findAll().stream().map(cardMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteCard(long cardId) {
        cardRepository.deleteById(cardId);
    }

    @Override
    public void setFinished(long cardId) {
        Card card =  cardRepository.findById(cardId).orElseThrow(() -> new RuntimeException("Could not find card with id: "+cardId));
        card.setFinished(true);
        cardRepository.save(card);
    }
}
