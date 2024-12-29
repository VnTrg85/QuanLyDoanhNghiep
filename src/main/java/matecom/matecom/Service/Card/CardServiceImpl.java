package matecom.matecom.Service.Card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matecom.matecom.Repository.CardRepository;
import java.util.List;

import matecom.matecom.Entity.Card;
import matecom.matecom.Repository.List_cardsRepository;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private List_cardsRepository listCardsRepository;

    @Override
    public Card addCard(int listCardId, Card card) {
        card.setList_cards(listCardsRepository.findById(listCardId)
                .orElseThrow(() -> new RuntimeException("List_card not found!")));
        return cardRepository.save(card);
    }

    @Override
    public List<Card> getCardsByListCardId(int listCardId) {
        return cardRepository.findAll().stream()
                .filter(card -> card.getList_cards().getId() == listCardId)
                .toList();
    }

    @Override
    public Card updateCard(int id, Card updatedCard) {
        Card existingCard = cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found!"));
        if(updatedCard.getName() != null){
            existingCard.setName(updatedCard.getName());
        }
        if (updatedCard.getDescription() != null) {
            existingCard.setDescription(updatedCard.getDescription());
        }
        if (updatedCard.getDate_start() != null) {
            existingCard.setDate_start(updatedCard.getDate_start());
        }
        if (updatedCard.getDate_end() != null) {
            existingCard.setDate_end(updatedCard.getDate_end());
        }
        return cardRepository.save(existingCard);
    }

    @Override
    public void deleteCard(int id) {
        if (!cardRepository.existsById(id)) {
            throw new RuntimeException("Card not found!");
        }
        cardRepository.deleteById(id);
    }
    
    @Override
    public Card getCardsByCardID(int id){
        return cardRepository.findById(id).orElseThrow(() -> new RuntimeException("Card not found"));
    }
}
