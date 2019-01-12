package wat.edu.pl.todoapp.controller.impl;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wat.edu.pl.todoapp.controller.TodoCardRestController;
import wat.edu.pl.todoapp.model.dto.CardDto;
import wat.edu.pl.todoapp.service.CardService;

import java.util.List;

@RequestMapping("/api")
@RestController
@Log
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class TodoCardRestControllerImpl implements TodoCardRestController {

    private final CardService cardService;

    @Override
    public ResponseEntity<List<CardDto>> getAllCards() {
        return ResponseEntity.ok(cardService.getAllCards());
    }

    @Override
    public ResponseEntity<Void> saveCard(@RequestBody CardDto cardDto) {
        cardService.saveCard(cardDto);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> deleteCard(long cardId) {
        cardService.deleteCard(cardId);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> setFinished(long cardId) {
        cardService.setFinished(cardId);
        return ResponseEntity.ok(null);
    }
}
