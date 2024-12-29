package matecom.matecom.Controller;

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
import matecom.matecom.Entity.Card;
import matecom.matecom.Service.Card.CardService;

import java.util.List;


@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping("/list-card/{listCardId}")
    public ResponseEntity<List<Card>> getCardsByListCard(@PathVariable int listCardId) {
        List<Card> cards = cardService.getCardsByListCardId(listCardId);
        return ResponseEntity.ok(cards);
    }

    @GetMapping("/cardsdetail/{id}")
    public ResponseEntity<Card> getCardsByCardIDs(@PathVariable int id) {
        Card card = cardService.getCardsByCardID(id);
        return ResponseEntity.ok(card);
    }
    

    @PostMapping("/list-card/{listCardId}")
    public ResponseEntity<Card> addCard(@PathVariable int listCardId, @RequestBody Card card) {
        Card createdCard = cardService.addCard(listCardId, card);
        return ResponseEntity.ok(createdCard);
    }

    @PutMapping("/carddetail/{id}")
    public ResponseEntity<Card> updateCard(@PathVariable int id, @RequestBody Card card) {
        Card updatedCard = cardService.updateCard(id, card);
        if (updatedCard != null) {
            return ResponseEntity.ok(updatedCard);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable int id) {
        cardService.deleteCard(id);
    }
}
