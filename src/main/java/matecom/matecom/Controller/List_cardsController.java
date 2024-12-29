package matecom.matecom.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import matecom.matecom.Entity.List_cards;
import matecom.matecom.Service.List_cards.List_cardsService;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/list-cards")
public class List_cardsController {
    @Autowired
    private List_cardsService listCardService;

    @PostMapping("/task/{taskId}")
    public ResponseEntity<List_cards> addListCard(@PathVariable int taskId, @RequestBody List_cards listCard) {
        List_cards createdListCard = listCardService.addListCard(taskId, listCard);
        return ResponseEntity.ok(createdListCard);
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<List_cards>> getListCardsByTask(@PathVariable int taskId) {
        List<List_cards> listCards = listCardService.getAllListCardsByTaskId(taskId);
        return ResponseEntity.ok(listCards);
    }

    @PutMapping("/{id}")
    public List_cards updateListCard(@PathVariable int id, @RequestBody List_cards list_card) {
        return listCardService.updateListCard(id, list_card);
    }

    @DeleteMapping("/{id}")
    public void deleteListCard(@PathVariable int id) {
        listCardService.deleteListCard(id);
    }
}
