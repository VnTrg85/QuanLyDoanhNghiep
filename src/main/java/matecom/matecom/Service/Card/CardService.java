package matecom.matecom.Service.Card;

import java.util.List;

import matecom.matecom.Entity.Card;

public interface CardService {
    public Card addCard(int listCardId, Card card);
    public List<Card> getCardsByListCardId(int listCardId);
    public Card updateCard(int id, Card updatedCard);
    public void deleteCard(int id);
    public Card getCardsByCardID(int id);
}
