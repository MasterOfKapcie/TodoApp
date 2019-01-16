package wat.edu.pl.todoapp.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wat.edu.pl.todoapp.model.Mail;
import wat.edu.pl.todoapp.model.dto.CardDto;

import java.util.List;

@RequestMapping("/api")
public interface TodoCardRestController {

    @RequestMapping(method = RequestMethod.GET, path = "/cards", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CardDto>> getAllCards();

    @RequestMapping(method = RequestMethod.POST, path = "/cards", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> saveCard(@RequestBody CardDto cardDto);

    @RequestMapping(method = RequestMethod.DELETE, path = "/cards/{id}")
    ResponseEntity<Void> deleteCard(@PathVariable("id") long cardId);

    @RequestMapping(method = RequestMethod.DELETE, path="/card/{id}/set-finished")
    ResponseEntity<Void> setFinished(@PathVariable("id") long cardId);

    @RequestMapping(path = "/mail", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    ResponseEntity<Void> wyslijMail(@RequestBody Mail mail);
}
